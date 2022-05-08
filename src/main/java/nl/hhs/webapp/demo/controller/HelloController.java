package nl.hhs.webapp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("${view.index}") public String
    hello(
            @RequestParam(value = "name", defaultValue = "test", required = false)
                    String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "index";
    }
}
