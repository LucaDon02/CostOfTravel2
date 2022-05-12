package nl.hhs.webapp.demo.controller;

import nl.hhs.webapp.demo.model.user.User;
import nl.hhs.webapp.demo.service.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService USER_SERVICE;

    @Autowired
    UserController(UserService userService) {
        USER_SERVICE = userService;

    }

    @PostMapping("${api.post.registration-request}") public String
    register(
            @Valid @RequestBody User request,
            Errors err,
            Model model
    ) {
        model.addAttribute(new User());
        if ( err.hasErrors() ) {
            model.addAttribute("name", "");
            return "error";
        }
         USER_SERVICE.save(request);
         return "";
    }
}
