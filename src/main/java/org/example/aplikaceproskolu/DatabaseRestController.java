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
import org.springframework.security.core.context.SecurityContextHolder;
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

    /**
     * Handles the creation of a new problem entry by accepting a Problem object,
     * setting the creation date, saving it to the database, and redirecting to the root page.
     *
     * @param problem the Problem object containing details of the problem to be added.
     * @param httpResponse the HttpServletResponse used to send a redirect response.
     * @throws IOException if an input or output exception occurred during the redirection.
     */
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
    @GetMapping("/api/account/{id}")
    public String getUserById(@PathVariable() UUID id, Model model) {
        model.addAttribute(Objects.requireNonNull(userRepo.findById(id).orElse(null)));
        return "account";
    }
}
