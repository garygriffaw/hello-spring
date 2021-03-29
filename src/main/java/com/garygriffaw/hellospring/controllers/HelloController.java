package com.garygriffaw.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    // handles requests of the form /hello?name=Gary
//    @GetMapping("/greeting")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/greeting")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language, Model model) {
        String greeting = createMessage(language, name);
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Path parameter
    // handles requests of the form /hello/Gary
    @GetMapping("/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = createMessage("english", name);
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("/form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("/hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Joe");
        names.add("Mary");
        names.add("Chris");
        names.add("Mark");

        model.addAttribute("names", names);

        return "hello-list";
    }

    public static String createMessage(String language, String name) {
        String greeting = "";

        if (language.equals("english"))
            greeting = "Hello";
        else if (language.equals("french"))
            greeting = "Bonjour";
        else if (language.equals("spanish"))
            greeting = "Hola";
        else if (language.equals("hindi"))
            greeting = "Namaste";
        else if (language.equals("mandarin"))
            greeting = "Ni Hau";
        else
            greeting = "Hi";

        return greeting + ", " + name;
    }
}
