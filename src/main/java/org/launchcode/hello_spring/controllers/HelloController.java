package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("hello")
public class HelloController {

    // Handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles requests at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String aGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", aGreeting);
        return "hello";
    }

    //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
//        return "Hello, " + name + "!";
        return createMessage(name, language);
    }

//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    public String helloWQP(@RequestParam String name, Model model) {
//        String aGreeting = "Hello, " + name + "!";
//        model.addAttribute("greeting", aGreeting);
//        return "hello";
//    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

    @GetMapping("form")
    public String helloForm() {
//        return "<html>" +
//                "<body " +
//                "style='" +
//                "background-color: #2D3748;" +
//                "display: flex;" +
//                "justify-content: center;" +
//                "align-items: center;" +
//                "height: 100vh;" +
//                "margin: auto;" +
//                "overflow: hidden;" +
//                "'>" +
//                "<form action='hello' method='post'>" +
//                "<label style='color:white;'for='name'>Name: </label>" +
//                "<input type='text' name='name'>" +
//                "<select id='language' name='language'>" +
//                "<option value='English' selected>English</option>" +
//                "<option value='French'>French</option>" +
//                "<option value='German'>German</option>" +
//                "<option value='Russian'>Russian</option>" +
//                "<option value='Spanish'>Spanish</option>" +
//                "</select>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
        return "form";
    }

    public static String createMessage(String name, String language) {
        String greeting = "";

        if (name.trim().isEmpty()) {
            if (language.equals("French")) {
                name = "le monde";
            } else if (language.equals("German")) {
                name = "Welt";
            } else if (language.equals("Russian")) {
                name = "мир";
            } else if (language.equals("Spanish")) {
                name = "Mundo";
            } else {
                name = "World";
            }
        }

        if (language.equals("French")) {
            greeting = "Bonjour, ";
        } else if (language.equals("German")) {
            greeting = "Hallo, ";
        } else if (language.equals("Russian")) {
            greeting = "Привет, ";
        } else if (language.equals("Spanish")) {
            greeting = "¡Hola, ";
        } else {
            greeting = "Hello, ";
        }

        return "<body " +
                "style='" +
                "background-color: #2D3748;" +
                "display: flex;" +
                "justify-content: center;" +
                "align-items: center;" +
                "height: 100vh;" +
                "margin: auto;" +
                "overflow: hidden;" +
                "'>" +
                "<h1 " +
                "style='" +
                "background-color: #6d8bbd;" +
                "border: 2px solid black;" +
                "padding: 20px;" +
                "'>" +
                greeting + name + "!" +
                "</h1>" +
                "</body>";


    }
}
