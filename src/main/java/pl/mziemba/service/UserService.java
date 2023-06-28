package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.*;
import pl.mziemba.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public  List<User> findBySpecialist(Specialist specialist) {
        return userRepository.findBySpecialist(specialist);
    }
    public  List<User> findBySpecialistByFullName(String firstName, String lastName) {
        return userRepository.findBySpecialistFirstNameAndSpecialistLastName(firstName, lastName);
    }

    public  List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    public  List<User> findByRoleName(String name) {
        return userRepository.findByRoleName(name);
    }
    
}
