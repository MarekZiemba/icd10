package pl.mziemba.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mziemba.entity.User;

import java.util.Set;

@Controller
@RequiredArgsConstructor
class ValidationController {

    private final Validator validator;

    @GetMapping(path = "/validate")
    String validateTest(User user, Model model) {

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        model.addAttribute("violations", violations);

        return "validator/result";
    }
}
