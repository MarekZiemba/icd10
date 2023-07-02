package pl.mziemba.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mziemba.entity.*;
import pl.mziemba.service.SpecialistService;
import pl.mziemba.service.RoleService;
import pl.mziemba.service.UserService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserFormController {

    private final UserService userService;
    private final SpecialistService specialistService;
    private final RoleService roleService;


    // wyswietlenie formularza dodawania użytkownika
    @GetMapping(path = "/user/add")
    String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    // obsluga formularza dodawania użytkownika
    @PostMapping(path = "/user/add")
    String processAddUserForm(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/add";
        }
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping(path = "/user/edit")
    String showEditUserForm(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/edit";
    }

    @PostMapping(path = "/user/edit")
    String processEditUserForm(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping(path = "/user/remove")
    String processRemoveUser(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/user/list";
    }

    // wyswietlanie listy wszystkich użytkowników
    @GetMapping(path = "/user/list")
    String showUserList( Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping(path = "/user/search")
    String showSearchUserForm() {
        return "user/search";
    }

    @GetMapping(path = "/user/search", params = "username")
    String findByUsername(@RequestParam String username, Model model) {
        List<User> users = userService.findByUsername(username);
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping(path = "/user/search/specialist", params = {"firstName", "lastName"})
    String findBySpecialistByFullName(@RequestParam String firstName, String lastName, Model model) {
        List<User> users = userService.findBySpecialistByFullName(firstName, lastName);
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping(path = "/user/search/role", params = "name")
    String findByRoleName(@RequestParam String name, Model model) {
        List<User> users = userService.findByRoleName(name);
        model.addAttribute("users", users);
        return "user/list";
    }

    // umieszczenie w modelu pod kluczamim 'specialists' kolekcji obiektow Specialist
    @ModelAttribute("specialists")
    Collection<Specialist> specialists() {
        return specialistService.findAll();
    }

    // umieszczenie w modelu pod kluczamim 'roles' kolekcji obiektow Role
    @ModelAttribute("roles")
    Collection<Role> roles() {
        return roleService.findAll();
    }

}
