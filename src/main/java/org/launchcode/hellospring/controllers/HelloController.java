package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping()
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";

        if(name == "") {
            return "Hello, Spring";
        } else {
            return "Hello, " + name + "!";
        }

    }



    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @RequestMapping(value="form", method = RequestMethod.GET)
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                            "<input type = 'text' name = 'name' >" +
                            "<input type = 'submit' value = 'Greet Me!' >" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }


    @RequestMapping(value = "/form/language", method = {RequestMethod.POST})
    public static String helloWithQueryParamLanguageName(@RequestParam String name, @RequestParam String language) {

        if(name == "") {
            return "Hello, world";
        }

        if(language.equals("French") ) {
            return "Bonjour, " + name;
        } else if(language.equals("Creole")) {
            return "Bonjou, " + name;
        } else {
            return "Bon matin " + name;
        }
    }

    @RequestMapping(value="/form/language", method= RequestMethod.GET)
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

}
