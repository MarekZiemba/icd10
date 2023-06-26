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
import pl.mziemba.entity.Treatment;
import pl.mziemba.entity.Specialist;
import pl.mziemba.service.TreatmentService;
import pl.mziemba.service.SpecialistService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TreatmentFormController {

    private final TreatmentService treatmentService;
    private final SpecialistService specialistService;

    // wyswietlenie formularza dodawania usługi (terapii, badania)
    @GetMapping(path = "/treatment/add")
    String showAddTreatmentForm(Model model) {
        model.addAttribute("treatment", new Treatment());
        return "treatment/add";
    }

    // obsluga formularza dodawania usługi
    @PostMapping(path = "/treatment/add")
    String processAddTreatmentForm(@Valid Treatment treatment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "treatment/add";
        }
        treatmentService.save(treatment);
        return "redirect:/treatment/list";
    }

    @GetMapping(path = "/treatment/edit")
    String showEditTreatmentForm(@RequestParam Long id, Model model) {
        model.addAttribute("treatment", treatmentService.findById(id));
        return "treatment/edit";
    }

    @PostMapping(path = "/treatment/edit")
    String processEditTreatmentForm(@Valid Treatment treatment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "treatment/edit";
        }
        treatmentService.update(treatment);
        return "redirect:/treatment/list";
    }

    @GetMapping(path = "/treatment/remove")
    String processRemoveTreatment(@RequestParam Long id) {
        treatmentService.deleteById(id);
        return "redirect:/treatment/list";
    }

    // wyswietlanie listy wszystkich pacjentów
    @GetMapping(path = "/treatment/list")
    String showTreatmentList(Model model) {
        List<Treatment> treatments = treatmentService.findAll();
        model.addAttribute("treatments", treatments);
        return "treatment/list";
    }

    @GetMapping(path = "/treatment/search")
    String showSearchTreatmentForm() {
        return "treatment/search";
    }
    
    @GetMapping(path = "/treatment/search", params = "name")
    String findByPesel(@RequestParam String name, Model model) {
        List<Treatment> treatments = treatmentService.findByName(name);
        model.addAttribute("treatments", treatments);
        return "treatment/list";
    }
    
    @GetMapping(path = "/treatment/search/specialist", params = {"firstName", "lastName"})
    String findBySpecialist(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        List<Treatment> treatments = treatmentService.findBySpecialistFullName(firstName, lastName);
        model.addAttribute("treatments", treatments);
        return "treatment/list";
    }
    
    // umieszczenie w modelu pod kluczem 'specialists' kolekcji obiektow Specialist
    @ModelAttribute("specialists")
    Collection<Specialist> specialists() {
        return specialistService.findAll();
    }
    
}
