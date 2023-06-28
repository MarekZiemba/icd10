package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Role;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.User;
import pl.mziemba.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SpecialistService specialistService;
    private final RoleService roleService;


    @PostMapping(path = "/user")
    void save(@RequestParam String username, @RequestParam String password, @RequestParam int enabled, @RequestParam String specialistFirstName, @RequestParam String specialistLastName,  @RequestParam String name) {

        final User user = new User();

        user.setUsername(username);
        user.setEnabled(enabled);
        user.setPassword(password);

        Specialist specialist = new Specialist();
        specialist.setFirstName(specialistFirstName);
        specialist.setLastName(specialistLastName);
        specialistService.save(specialist);
        user.setSpecialist(specialist);
        
        Role role = new Role();
        role.setName(name);
        roleService.save(role);
        user.setRole(role);
        
        userService.save(user);
    }

    @GetMapping(path = "/users", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<User> users = userService.findAll();
        return users.toString();
    }

    @GetMapping(path = "/user/username", produces = "text/plain;charset=utf-8")
    String findByDate(@RequestParam("username") String username) {
        final Optional<User> users = userService.findByUsername(username);
        return users.toString();
    }

    @GetMapping(path = "/user/specialist", produces = "text/plain;charset=utf-8", params = "id")
    String findBySpecialist(Specialist specialist) {
        final List<User> users = userService.findBySpecialist(specialist);
        return users.toString();
    }

    @GetMapping(path = "/user/specialist", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findByPSpecialistFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<User> users = userService.findBySpecialistByFullName(firstName, lastName);
        return users.toString();
    }

    @GetMapping(path = "/user/role", produces = "text/plain;charset=utf-8", params = "id")
    String findByTreatment(Role role) {
        final List<User> users = userService.findByRole(role);
        return users.toString();
    }

    @GetMapping(path = "/user/role", produces = "text/plain;charset=utf-8", params = "name")
    String findByRoleName(@RequestParam("name") String name) {
        final List<User> users = userService.findByRoleName(name);
        return users.toString();
    }
    
    @DeleteMapping(path = "/user/{id}")
    void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
