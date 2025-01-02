package io.jarburg.ThyleafAndSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {
    @GetMapping
    public String index(Model model) {
        List<String> demigods = List.of("Marika", "Rennala", "Radahn");
        model.addAttribute("pageTitle", "Taming thymeleaf");
        model.addAttribute("demigods", demigods);
        return "index";
    }
}
