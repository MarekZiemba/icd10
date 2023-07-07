package pl.mziemba.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.User;
import pl.mziemba.exceptions.ValidationException;
import pl.mziemba.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(path = "/register", produces = "text/plain;charset=utf-8")
    public User registerUser(@RequestParam String username, @RequestParam String password) throws ValidationException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        List<String> validationFailures = validate(user);
        if(validationFailures.isEmpty()){
            return userRepository.save(user);
        } else {
            throw new ValidationException(validationFailures);
        }
    }
    private List<String> validate(User user) {
        Optional<User> byUser = userRepository.findByUsername(user.getUsername());
        if(byUser.isPresent()){
            return Arrays.asList("usernameAlreadyExists");
        }
        return Collections.emptyList();
    }
}
