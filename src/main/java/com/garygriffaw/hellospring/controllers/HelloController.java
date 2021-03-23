package com.garygriffaw.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
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
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return createMessage(language, name);
    }

    // Path parameter
    // handles requests of the form /hello/Gary
    @GetMapping("/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='greeting' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language' id='language'>" +
                "  <option value='english'>English</option>" +
                "  <option value='french'>French</option>" +
                "  <option value='spanish'>Spanish</option>" +
                "  <option value='hindi'>Hindi</option>" +
                "  <option value='mandarin'>Mandarin</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "<html>";
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

        return "<h2>" + greeting + ", " + name + "!</h2>";
    }
}
