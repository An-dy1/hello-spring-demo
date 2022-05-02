package org.launchcode.hellospring.controllers;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewController {

  @RequestMapping("about-us-2")
  @ResponseBody
  public String getAboutUsPage() {
    return "<h1>About Us</h1>";
  }

  @GetMapping("contact-us-2")
  @ResponseBody
  public String getContactUsForm() {
    // action: tells the form the URL where it will be processed
    return "<form action='/contact-us-2' method='post'>" +
              "<label for='email'>Email</label>" +
              "<input type='text' name='email'>" +
              "<br>" +

              "<label for='birth month'>Birth month:</label>" +
              "<select name='birthMonth'>" +
                "<option value='march'>March</option>" +
                "<option value='april'>April</option>" +
                "<option value='may'>May</option>" +
              "</select>" +
              "<br>" +

              "<input type='submit'>" +
            "</form>";
  }

  @PostMapping("contact-us-2")
  @ResponseBody
  public String getCompletedForm(@RequestParam String email, @RequestParam String birthMonth) {
    return "<p>Thank you for submitting your form!</p>" +
        "<p>We will contact you at:</p>" +
        email +
        "<br><p>And tell you happy birthday in </p>" + birthMonth;
  }
}
