package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

  @GetMapping("contact-us")
  @ResponseBody
  public String getContactUsForm() {
    return "<html>" +
              "<body>" +
                "<form method='post'>" +
                "<label for='email'>Email</label>" +
                "<input type='text' name='email' placeholder='test@test.com'>" +
                "<br>" +

                "<label for='birthMonth'>Birth month:</label>" +
                "<select name='birthMonth'>" +
                  "<option value='march'>March</option>" +
                  "<option value='april'>April</option>" +
                  "<option value='may'>May</option>" +
                "</select>" +
                "<br>" +

                "<input type='submit'>" +
                "</form>" +
            "</body>" +
        "</html>";
  }

  @PostMapping("contact-us")
  @ResponseBody
  public String postToContactUsForm(@RequestParam String email, @RequestParam String birthMonth) {
    return "<html>" +
              "<body>" +
                "<p>Thank you for contacting us! We will email you back at: </p><br>" +
                email +
                "<p>And we will send a birthday card in: </p>" + birthMonth +
              "</body>" +
            "</html>";
  }


}
