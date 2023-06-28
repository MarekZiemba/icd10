package pl.mziemba.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mziemba.entity.Role;
import pl.mziemba.service.RoleService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleFormController {

    private final RoleService roleService;

    // wyswietlenie formularza dodawania roli
    @GetMapping(path = "/role/add")
    String showAddRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "role/add";
    }

    // obsluga formularza dodawania roli
    @PostMapping(path = "/role/add")
    String processAddRoleForm(@Valid Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "role/add";
        }
        roleService.save(role);
        return "redirect:/role/list";
    }

    @GetMapping(path = "/role/edit")
    String showEditRoleForm(@RequestParam Long id, Model model) {
        model.addAttribute("role", roleService.findById(id));
        return "role/edit";
    }

    @PostMapping(path = "/role/edit")
    String processEditRoleForm(@Valid Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "role/edit";
        }
        roleService.update(role);
        return "redirect:/role/list";
    }

    @GetMapping(path = "/role/remove")
    String processRemoveRole(@RequestParam Long id) {
        roleService.deleteById(id);
        return "redirect:/role/list";
    }
    @GetMapping(path = "/role/list")
    String showRoleList(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "role/list";
    }

    @GetMapping(path = "/role/search")
    String showSearchRoleForm() {
        return "role/search";
    }

    @GetMapping(path = "/role/search", params = "name")
    String findByName(@RequestParam String name, Model model) {
        List<Role> roles = roleService.findByName(name);
        model.addAttribute("roles", roles);
        return "role/list";
    }
    
}
