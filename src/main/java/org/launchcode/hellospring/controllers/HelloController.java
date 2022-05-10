package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("hello")
public class HelloController {

  //    // Handle request at path /hello
//    @GetMapping()
//    public String hello() {
//        return "Hello, Spring!";
//    }

  // lives at /hello/goodbye
  @GetMapping("goodbye")
  @ResponseBody
  public String goodbye() {
    return "Goodbye, Spring!";
  }

  // Handle requests of the form /hello?name=LaunchCode
  @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
  public String helloWithQueryParam(@RequestParam String name, Model model) {
    String greeting = "Hello, " + name;
    model.addAttribute("greeting", greeting);
    return "hello";

  }

  // Handles requests of the form /hello/LaunchCode
  @GetMapping("{name}")
  public String helloWithPathParam(@PathVariable String name, Model model) {
    String pathGreeting = "Hello, " + name;
    model.addAttribute("greeting", pathGreeting);
    return "hello";
  }

  // /hello/form
  @RequestMapping(value = "form", method = RequestMethod.GET)
  public String helloForm() {
    return "form";
  }

  @RequestMapping(value = "/form/language", method = {RequestMethod.POST})
  @ResponseBody
  public static String helloWithQueryParamLanguageName(@RequestParam String name, @RequestParam String language) {

    if (name == "") {
      return "Hello, world";
    }

    if (language.equals("French")) {
      return "Bonjour, " + name;
    } else if (language.equals("Creole")) {
      return "Bonjou, " + name;
    } else {
      return "Bon matin " + name;
    }
  }

  @RequestMapping(value = "/form/language", method = RequestMethod.GET)
  @ResponseBody
  public String helloFormLanguage() {
    return "<html>" +
        "<body>" +
        "<form action = '/hello/form/language' method = 'post'>" + // submit a request to /hello/form/languagee
        "<input type = 'text' name='name' >" +
        "<select name='language'>" +
        "<option value='French'>French</option>" +
        "<option value='Creole'>Creole</option>" +
        "<option value='Québecois'>Québecois</option>" +
        "</select>" +
        "<input type='submit' value='Speak French' >" +
        "</form>" +
        "</body>" +
        "</html>";
  }

  @GetMapping("names")
  public String helloNames(Model model) {
    List<String> localNames = new ArrayList<>();
    localNames.add("Amelia");
    localNames.add("Cecelia");
    localNames.add("Delia");
    localNames.add("Celia");

    model.addAttribute("names", localNames);
    return "hello-list";
  }

}
