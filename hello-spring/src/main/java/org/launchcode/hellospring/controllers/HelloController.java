package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {


//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }


//    //lives at /hello/goodbye
//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }

    // Responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

//    @RequestMapping(value="hello", method = RequestMethod.POST)
//    @ResponseBody
//    public String helloPost(@RequestParam String name, @RequestParam String language) {
//        if (name == null) {
//            name = "World";
//        }
//
//        return createMessage(name, language);
//
//        // For a bonus mission, students can change this response text to look nicer.
//        // This is subjective, but students should be modifying the HTML of the response string.
//    }
//
//    public static String createMessage(String n, String l) {
//        String greeting = "";
//
//        if (l.equals("english")) {
//            greeting = "Hello";
//        }
//        else if (l.equals("french")) {
//            greeting = "Bonjour";
//        }
//        else if (l.equals("italian")) {
//            greeting = "Bonjourno";
//        }
//        else if (l.equals("spanish")) {
//            greeting = "Hola";
//        }
//        else if (l.equals("german")) {
//            greeting = "Hallo";
//        }
//
//        return greeting + " " + n;
//    }



}
