package pl.mziemba.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mziemba.entity.Specialist;
import pl.mziemba.service.SpecialistService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SpecialistFormController {

    private final SpecialistService specialistService;

    // wyswietlenie formularza dodawania specjalissty
    @GetMapping(path = "/specialist/add")
    String showAddSpecialistForm(Model model) {
        model.addAttribute("specialist", new Specialist());
        return "specialist/add";
    }

    // obsluga formularza dodawania specjalistów
    @PostMapping(path = "/specialist/add")
    String processAddSpecialistForm(@Valid Specialist specialist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "specialist/add";
        }
        specialistService.save(specialist);
        return "redirect:/specialist/list";
    }

    @GetMapping(path = "/specialist/edit")
    String showEditSpecialistForm(@RequestParam Long id, Model model) {
        model.addAttribute("specialist", specialistService.findById(id));
        return "specialist/edit";
    }

    @PostMapping(path = "/specialist/edit")
    String processEditSpecialistForm(@Valid Specialist specialist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "specialist/edit";
        }
        specialistService.update(specialist);
        return "redirect:/specialist/list";
    }

    @GetMapping(path = "/specialist/remove")
    String processRemoveSpecialist(@RequestParam Long id) {
        specialistService.deleteById(id);
        return "redirect:/specialist/list";
    }

    // wyswietlanie listy wszystkich pacjentów
    @GetMapping(path = "/specialist/list")
    String showSpecialistList(Model model) {
        List<Specialist> specialists = specialistService.findAll();
        model.addAttribute("specialists", specialists);
        return "specialist/list";
    }

}
