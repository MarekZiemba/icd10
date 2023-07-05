package pl.mziemba.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.User;
import pl.mziemba.repository.UserRepository;

//@Controller
//@RequestMapping("register")
@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @GetMapping(path = "/registration", produces = "text/plain;charset=utf-8")
    public void registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

//    @GetMapping(path = "/register")
//    @ResponseBody
//    public boolean createUser(@RequestParam String username, @RequestParam String password, @RequestParam String matchingPassword) {
//        //
//
//        User user = new User();
////        user.setUsername(userDto.getUsername());
//        user.setUsername(username);
////        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setPassword(passwordEncoder.encode(password));
//        userRepository.save(user);
//        return "redirect:/login;
//    }
}

//        User user = new User();
//        user.setUsername("Admin");
//        user.setPassword(passwordEncoder.encode("admin"));
//        userRepository.save(user);
//
//        User user2 = new User();
//        user2.setUsername("User");
//        user2.setPassword(passwordEncoder.encode("user"));
//        userRepository.save(user2);
//        return true;
//    }
//}
