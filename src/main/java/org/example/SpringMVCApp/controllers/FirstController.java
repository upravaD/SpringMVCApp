package org.example.SpringMVCApp.controllers;

import org.example.SpringMVCApp.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        if (name != null && surname != null) {
            model.addAttribute("message", "Hello, " + name + " " + surname);
        } else {
            model.addAttribute("message", "Parameters is null");
        }
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a") Integer a,
                            @RequestParam(value = "b") Integer b,
                            @RequestParam(value = "action") String action,
                            Model model) {
        Calculator calculator = new Calculator(a, b);
        Double result;
        switch (action) {
            case "addition"         -> result = calculator.addition();
            case "subtraction"      -> result = calculator.subtraction();
            case "multiplication"   -> result = calculator.multiplication();
            case "division"         -> result = calculator.division();
            default                 -> throw new IllegalStateException("Unexpected value: " + action);
        }
        model.addAttribute("a", calculator.getA());
        model.addAttribute("b", calculator.getB());
        model.addAttribute("action", calculator.getSymbol());
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
