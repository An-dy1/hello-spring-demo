package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewController {

  @RequestMapping("about-us")
  @ResponseBody
  public String getAboutUsPage() {
    return "<h1>About Us</h1>";
  }

  @GetMapping("contact-us")
  @ResponseBody
  public String getContactUsForm() {
    return "<form action='contact-us' method='post'>" +
              "<label for='email' />" +
              "<input type='text' name='email'>" +
              "<input type='submit'>" +
            "</form>";
  }

  @PostMapping("contact-us")
  @ResponseBody
  public String getCompletedForm(@RequestParam String email) {
    return "<p>Thank you for submitting your form!</p>" +
        "<p>We will contact you at:</p>" +
        email;
  }
}
