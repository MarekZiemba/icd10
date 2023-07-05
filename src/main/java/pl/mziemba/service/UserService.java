package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.*;
import pl.mziemba.exceptions.UserServiceTest;
import pl.mziemba.exceptions.ValidationException;
import pl.mziemba.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    public final UserServiceTest userServiceTest;

    private List<String> validate(User user) {
        Optional<User> byUser = userRepository.findByUsername(user.getUsername());
        if(byUser.isPresent()){
            return Arrays.asList("usernameAlreadyExists");
        }
        return Collections.emptyList();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public void deleteById(Long id){
        User user = userRepository.findById(User.class, id);
        user.removeSpecialist();
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findByUsername(String username) {
        return userRepository.findByUsernameContains(username);
    }

    public  List<User> findBySpecialist(Specialist specialist) {
        return userRepository.findBySpecialist(specialist);
    }
    public  List<User> findBySpecialistByFullName(String firstName, String lastName) {
        return userRepository.findBySpecialistFirstNameAndSpecialistLastName(firstName, lastName);
    }

    public  List<User> findByRoles(Role role) {
        return userRepository.findByRoles(role);
    }

    public  List<User> findByRoleName(String name) {
        return userRepository.findByRolesName(name);
    }
    
}
