package pl.mziemba.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class AuthenticationController {

    @GetMapping(path = "/login")
    String login() {
        return "login";
    }

    @PostMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }

//    @GetMapping(path = "register")
//    String register() {
//        return "register";
//    }

}
