package org.example.aplikaceproskolu;

import jakarta.servlet.http.HttpServletResponse;
import org.example.aplikaceproskolu.objekty.ClassRoom;
import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.UserPrincipal;
import org.example.aplikaceproskolu.objekty.Users;
import org.example.aplikaceproskolu.repo.ClassRoomRepo;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


/**
 * The DatabaseRestController class provides RESTful web service endpoints for
 * managing users, problems, and classrooms. It includes functionalities for adding
 * problems, retrieving all users, handling classroom creation, and obtaining user
 * details by ID.
 */
@RestController
public class DatabaseRestController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProblemRepo problemRepo;
    @Autowired
    ClassRoomRepo classRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    /**
     * Handles the creation of a new problem entry by accepting a Problem object,
     * setting the creation date, saving it to the database, and redirecting to the root page.
     *
     * @param problem the Problem object containing details of the problem to be added.
     * @param httpResponse the HttpServletResponse used to send a redirect response.
     * @throws IOException if an input or output exception occurred during the redirection.
     */
    @PreAuthorize("permitAll()")
    @PostMapping("/api/problem-add")
    public void addProblem(@ModelAttribute("problem") Problem problem, HttpServletResponse httpResponse) throws IOException {
        System.out.println("Post: " + problem.getUserId());
        problem.setCreated(new Date());
        problemRepo.save(problem);
        httpResponse.sendRedirect("/");
    }

    /**
     * Retrieves all user entities from the database.
     *
     * @return a list of all users available in the repository
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/users")
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    /**
     * Handles HTTP GET requests to the "/api/test" endpoint.
     *
     * @return a simple string "test".
     */
    @GetMapping("/api/test")
    public String test() {
//        return userRepo.currentUser();
        return "test";
    }

    /**
     * Retrieves all instances of ClassRoom from the repository.
     *
     * @return a list of all ClassRoom entities stored in the database.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/classes")
    public List<ClassRoom> classes() {
        return classRepo.findAll();
    }

    /**
     * Handles the creation of classroom entities by processing a payload containing
     * classroom names. Each name is extracted from the payload, a new ClassRoom object
     * is created, and the object is saved to the database.
     *
     * @param payload a map containing the classroom identifiers as keys and their names as values.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/create-classes")
    public void createClasses(@RequestBody Map<Integer, String> payload) {
        for (String obj : payload.values()) {
            System.out.println(obj);
            ClassRoom classRoom = new ClassRoom();
            classRoom.setName(obj);
            classRepo.save(classRoom);
        }
    }

    /**
     * Retrieves a user by their unique identifier and adds the user to the model.
     *
     * @param id the unique identifier of the user to be retrieved
     * @param model the model to which the user details are added
     * @return the name of the view to be rendered, in this case "account"
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/account/{id}")
    public Users getUserById(@PathVariable() UUID id) {
        return userRepo.findById(id).orElse(null);
    }

    /**
     * Returns a users which is saved to database
     * @param user the user you want to save
     * @return the user that was saved
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/add-user")
    public void newUser(@ModelAttribute("addUser") Users user, HttpServletResponse httpResponse) throws IOException {
        if (userRepo.findByEmail(user.getEmail()) == null) {
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
            httpResponse.sendRedirect("/");
        }
    }

    /**
     * Handles requests to the "api/problem/{id}" endpoint by mapping a UUID path variable
     * to the specified problem.
     *
     * @param problemUUID the UUID of the problem to be retrieved
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to be rendered, in this case "problem"
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("api/problem/{id}")
    public Problem problem(@PathVariable() UUID id) {
        return problemRepo.findById(id).orElse(null);
    }

    /**
     * Handles requests to the "api/all-problems" endpoint by mapping a UUID path variable
     * to the specified problem.
     *
     * @return all problems from database
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/all-problems")
    public List<Problem> getAllProblems() {
        return problemRepo.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/delete-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        Users user = userRepo.findById(id).orElse(null);

        if (user != null) {
            List<Problem> problemsByUser = problemRepo.getAllByUserId(Objects.requireNonNull(userRepo.findById(id).orElse(null)));
            problemRepo.deleteAll(problemsByUser);
            userRepo.delete(Objects.requireNonNull(userRepo.findById(id).orElse(null)));
            return ResponseEntity.noContent().build(); // 204 No Content (SPRÁVNĚ)
        }

        return ResponseEntity.notFound().build(); // 404 pokud uživatel neexistuje
    }


    @PutMapping("/api/complete-problem/{id}")
    public void completeProblem(@PathVariable() UUID id, @RequestBody Map<Integer, Double> payload, @AuthenticationPrincipal UserPrincipal user) {
        Problem problem = problemRepo.findById(id).orElseThrow();
//        UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        problem.setUserWhoFixedId(user.getUser());
        problem.setTime(payload.get(0));
        problemRepo.save(problem);
    }
}
