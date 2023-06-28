package pl.mziemba.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mziemba.entity.User;
import pl.mziemba.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(String username, String password) throws ValidationException {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        List<String> validationFailures = validate(user);
        if(validationFailures.isEmpty()){
            return userRepository.save(user);
        } else {
            throw new ValidationException(validationFailures);
        }

    }

    private List<String> validate(User user) {
        Optional<User> byLogin = userRepository.findByUsername(user.getUsername());
        if(byLogin.isPresent()){
            return Arrays.asList("loginAlreadyExists");
        }
        return Collections.emptyList();
    }



}