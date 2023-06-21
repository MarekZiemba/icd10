package pl.mziemba.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mziemba.entity.User;
import pl.mziemba.repository.UserRepository;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    @ResponseBody
    public boolean createTestUser(){

        User user = new User();
        user.setUsername("Admin");
        user.setPassword(passwordEncoder.encode("admin"));
        userRepository.save(user);

        User user2 = new User();
        user2.setUsername("User");
        user2.setPassword(passwordEncoder.encode("user"));
        userRepository.save(user2);

        return true;
    }
}
