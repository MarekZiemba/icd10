package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Role;
import pl.mziemba.service.RoleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping(path = "/role")
    void save(@RequestParam String name) {

        final Role role = new Role();
        role.setName(name);
        roleService.save(role);
    }

    @GetMapping(path = "/roles", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Role> roles = roleService.findAll();
        return roles.toString();
    }

    @GetMapping(path = "/role", produces = "text/plain;charset=utf-8")
    String findByName(@RequestParam("name") String name) {
        final List<Role> roles = roleService.findByName(name);
        return roles.toString();
    }

    @DeleteMapping(path = "/role/{id}")
    void deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
    }

}