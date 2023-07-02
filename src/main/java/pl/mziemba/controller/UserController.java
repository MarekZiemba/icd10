package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Role;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.User;
import pl.mziemba.service.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SpecialistService specialistService;
    private final RoleService roleService;


    @PostMapping(path = "/user")
    void save(@RequestParam String username, @RequestParam String password, @RequestParam int enabled, @RequestParam String specialistFirstName, @RequestParam String specialistLastName,  @RequestParam("roleId") Long[] roleId) {

        final User user = new User();

        user.setUsername(username);
        user.setEnabled(enabled);
        user.setPassword(password);

        Specialist specialist = new Specialist();
        specialist.setFirstName(specialistFirstName);
        specialist.setLastName(specialistLastName);
        specialistService.save(specialist);
        user.setSpecialist(specialist);
        
        Set<Role> roles = Arrays.stream(roleId)
                        .map(id -> new Role())
                                .collect(Collectors.toSet());
        user.setRoles(roles);
        
        userService.save(user);
    }

    @GetMapping(path = "/users", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<User> users = userService.findAll();
        return users.toString();
    }

    @GetMapping(path = "/user/username", produces = "text/plain;charset=utf-8")
    String findByUsername(@RequestParam("username") String username) {
        final List<User> users = userService.findByUsername(username);
        return users.toString();
    }

    @GetMapping(path = "/user/specialist", produces = "text/plain;charset=utf-8", params = "id")
    String findBySpecialist(Specialist specialist) {
        final List<User> users = userService.findBySpecialist(specialist);
        return users.toString();
    }

    @GetMapping(path = "/user/specialist", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findBySpecialistFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<User> users = userService.findBySpecialistByFullName(firstName, lastName);
        return users.toString();
    }

    @GetMapping(path = "/user/role", produces = "text/plain;charset=utf-8", params = "id")
    String findByTreatment(Role role) {
        final List<User> users = userService.findByRoles(role);
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
