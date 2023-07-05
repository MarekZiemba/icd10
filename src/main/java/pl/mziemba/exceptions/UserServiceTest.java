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
public class UserServiceTest {

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
        Optional<User> byUser = userRepository.findByUsername(user.getUsername());
        if(byUser.isPresent()){
            return Arrays.asList("usernameAlreadyExists");
        }
        return Collections.emptyList();
    }

}