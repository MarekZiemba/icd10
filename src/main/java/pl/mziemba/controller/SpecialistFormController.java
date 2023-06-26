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
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Specialization;
import pl.mziemba.service.SpecialistService;
import pl.mziemba.service.SpecializationService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SpecialistFormController {

    private final SpecialistService specialistService;
    private final SpecializationService specializationService;

    // wyswietlenie formularza dodawania specjalisty
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

    // wyswietlanie listy wszystkich specjalistów
    @GetMapping(path = "/specialist/list")
    String showSpecialistList(Model model) {
        List<Specialist> specialists = specialistService.findAll();
        model.addAttribute("specialists", specialists);
        return "specialist/list";
    }

    @GetMapping(path = "/specialist/search")
    String showSearchSpecialistForm() {
        return "specialist/search";
    }

    @GetMapping(path = "/specialist/search", params = {"firstName", "lastName"})
    String findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        List<Specialist> specialists = specialistService.findByFirstNameAndLastName(firstName,  lastName);
        model.addAttribute("specialists", specialists);
        return "specialist/list";
    }

    @GetMapping(path = "/specialist/search", params = "dateOfBirth")
    String findByDateOfBirth(@RequestParam String dateOfBirth, Model model) {
        List<Specialist> specialists = specialistService.findByDateOfBirth(dateOfBirth);
        model.addAttribute("specialists", specialists);
        return "specialist/list";
    }

    @GetMapping(path = "/specialist/search", params = "pesel")
    String findByPesel(@RequestParam String pesel, Model model) {
        List<Specialist> specialists = specialistService.findByPesel(pesel);
        model.addAttribute("specialists", specialists);
        return "specialist/list";
    }

    @GetMapping(path = "/specialist/search/specialization", params = "name")
    String findBySpecializationByName(@RequestParam String name, Model model) {
        List<Specialist> specialists = specialistService.findBySpecializationByName(name);
        model.addAttribute("specialists", specialists);
        return "specialist/list";
    }


    // umieszczenie w modelu pod kluczem 'specializations' kolekcji obiektow Specialization
    @ModelAttribute("specializations")
    Collection<Specialization> specializations() {
        return specializationService.findAll();
    }

}
