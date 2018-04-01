package com.example.mybatisplustest.havetry.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

  @RequestMapping("/")
  public String welcome() {
    return "loginPage";
  }

  @RequestMapping("/addUserPage")
  public String addUserPage() {
    return "addUserPage";
  }

  @RequestMapping(value = "/mPage")
  public String mPage(HttpServletRequest request, Model model) {
    String sessionValue = (String) request.getSession().getAttribute("username");
    String sessionValue2 = (String) request.getSession().getAttribute("password");
    model.addAttribute("username", sessionValue);
    model.addAttribute("password", sessionValue2);
    return "mPage";
  }

}
