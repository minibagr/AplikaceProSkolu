package org.example.aplikaceproskolu;

import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.UserPrincipal;
import org.example.aplikaceproskolu.objekty.Users;
import org.example.aplikaceproskolu.repo.ClassRoomRepo;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

/**
 * Controller class for handling web requests related to user accounts, problems, and authentication.
 */
@Controller
public class NewController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ClassRoomRepo classroomRepo;
    @Autowired
    private ProblemRepo problemRepo;

    /**
     * Handles the root URL ("/") by retrieving and displaying all available problems.
     *
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to be rendered, in this case, "index"
     */
    @PreAuthorize("permitAll()")
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("problems", problemRepo.findAll(Sort.by(Sort.Direction.ASC, "created")));
        return "index";
    }

    /**
     * Handles requests to the "/login" endpoint, returning the view name for the login page.
     *
     * @return the name of the view to be rendered for the login page, "login"
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Handles requests to the "/account" endpoint by retrieving the current user's details
     * and the count of problems associated with them, then adds these attributes to the model.
     *
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to be rendered, in this case "account"
     */
    @PreAuthorize("permitAll()")
    @GetMapping("/account")
    public String getUserById(Model model) {
        UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        float percantage = problemRepo.countProblemNotSolvedByUser(currentUser.getUser()) / (float)problemRepo.countProblemByUser(currentUser.getUser()) * 100;

        model.addAttribute("percantage", (int) percantage);
        model.addAttribute("problemsCount", problemRepo.countProblemByUser(currentUser.getUser()));
        model.addAttribute("userDetails", currentUser.getUser());
        model.addAttribute("addUser", new Users());
        return "account";
    }

    /**
     * Handles requests to the "/problemy" endpoint, ensuring the requestor has an ADMIN role.
     *
     * @return a string "ahoj" which usually indicates the view name to be rendered
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/problemy")
    public String problemy() {
        return "ahoj";
    }

    /**
     * Handles requests to the "/problem-add" endpoint, allowing users with roles
     * 'USER' or 'ADMIN' to access the problem addition page. This method retrieves
     * the current user's details and list of classes to populate the view with
     * necessary data for adding a new problem.
     *
     * @param model the model object used to pass attributes to the view, including
     *              the current user, available classes, and an empty problem object
     * @return the name of the view to be rendered, "problem-add"
     */
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/problem-add")
    public String problemAdd(Model model) {
        UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("userAdd", currentUser.getUser());
        model.addAttribute("classes", classroomRepo.findAll());
        model.addAttribute("problem", new Problem());
        return "problem-add";
    }

    /**
     * Handles requests to the "/problem/{id}" endpoint by mapping a UUID path variable
     * to the specified problem.
     *
     * @param problemUUID the UUID of the problem to be retrieved
     * @param model the model object used to pass attributes to the view
     * @return the name of the view to be rendered, in this case "problem"
     */
    @GetMapping("/problem/{id}")
    public String problem(@PathVariable UUID problemUUID, Model model) {
        return "problem";
    }
}
