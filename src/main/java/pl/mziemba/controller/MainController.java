package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mziemba.security.LoggedInUserDetails;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final LoggedInUserDetails loggedInUserDetails;

    @GetMapping("/main")
    public String mainViewController(Model model) {
        String loggedInUserFullName = loggedInUserDetails.getLoggedInUserFullName();
        model.addAttribute("loggedInUserFullName", loggedInUserFullName);
        return "main";
    }
}
