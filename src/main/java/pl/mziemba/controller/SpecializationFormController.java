package pl.mziemba.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mziemba.entity.Specialization;
import pl.mziemba.service.SpecializationService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SpecializationFormController {
    
    private final SpecializationService specializationService;

    // wyswietlenie formularza dodawania specjalizacji
    @GetMapping(path = "/admin/specialization/add")
    String showAddSpecializationForm(Model model) {
        model.addAttribute("specialization", new Specialization());
        return "specialization/add";
    }

    // obsluga formularza dodawania specjalizacji
    @PostMapping(path = "/admin/specialization/add")
    String processAddSpecializationForm(@Valid Specialization specialization, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "specialization/add";
        }
        specializationService.save(specialization);
        return "redirect:/admin/specialization/list";
    }

    @GetMapping(path = "/admin/specialization/edit")
    String showEditSpecializationForm(@RequestParam Long id, Model model) {
        model.addAttribute("specialization", specializationService.findById(id));
        return "specialization/edit";
    }

    @PostMapping(path = "/admin/specialization/edit")
    String processEditSpecializationForm(@Valid Specialization specialization, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "specialization/edit";
        }
        specializationService.update(specialization);
        return "redirect:/user/specialization/list";
    }

    @GetMapping(path = "/admin/specialization/remove")
    String processRemoveSpecialization(@RequestParam Long id) {
        specializationService.deleteById(id);
        return "redirect:/user/specialization/list";
    }
    @GetMapping(path = "/user/specialization/list")
    String showSpecializationList(Model model) {
        List<Specialization> specializations = specializationService.findAll();
        model.addAttribute("specializations", specializations);
        return "specialization/list";
    }
    
    @GetMapping(path = "/user/specialization/search")
    String showSearchSpecializationForm() {
        return "specialization/search";
    }

    @GetMapping(path = "/user/specialization/search", params = "name")
    String findByName(@RequestParam String name, Model model) {
        List<Specialization> specializations = specializationService.findByName(name);
        model.addAttribute("specializations", specializations);
        return "specialization/list";
    }

}
