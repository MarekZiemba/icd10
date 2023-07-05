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
import pl.mziemba.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class VisitFormController {

    private final VisitService visitService;
    private final PatientService patientService;
    private final TreatmentService treatmentService;
    private final SpecialistService specialistService;

    // wyswietlenie formularza dodawania wizyty
    @GetMapping(path = "/user/visit/add")
    String showAddVisitForm(Model model) {
        model.addAttribute("visit", new Visit());
        return "visit/add";
    }

    // obsluga formularza dodawania wizyty
    @PostMapping(path = "/user/visit/add")
    String processAddVisitForm(@Valid Visit visit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "visit/add";
        }
        visitService.save(visit);
        return "redirect:/user/visit/list";
    }

    @GetMapping(path = "/user/visit/edit")
    String showEditVisitForm(@RequestParam Long id, Model model) {
        model.addAttribute("visit", visitService.findById(id));
        return "visit/edit";
    }

    @PostMapping(path = "/user/visit/edit")
    String processEditVisitForm(@Valid Visit visit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "visit/edit";
        }
        visitService.update(visit);
        return "redirect:/user/visit/list";
    }

    @GetMapping(path = "/user/visit/remove")
    String processRemoveVisit(@RequestParam Long id) {
        visitService.deleteById(id);
        return "redirect:/user/visit/list";
    }

    // wyswietlanie listy wszystkich specjalistów
    @GetMapping(path = "/user/visit/list")
    String showVisitList( Model model) {
        List<Visit> visits = visitService.findAll();
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/user/visit/search")
    String showSearchVisitForm() {
        return "visit/search";
    }

    @GetMapping(path = "/user/visit/search", params = "dateOfVisit")
    String findByDate(@RequestParam LocalDate dateOfVisit, Model model) {
        List<Visit> visits = visitService.findByDate(dateOfVisit);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/user/visit/search", params = {"dateOfVisit", "timeOfVisit"})
    String findByDateAndTime(@RequestParam LocalDate dateOfVisit, LocalTime timeOfVisit, Model model) {
        List<Visit> visits = visitService.findByDateAndTime(dateOfVisit, timeOfVisit);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/user/visit/search", params = {"dateOfVisit1", "dateOfVisit2"})
    String findByDateBetween(@RequestParam LocalDate dateOfVisit1, LocalDate dateOfVisit2, Model model) {
        List<Visit> visits = visitService.findByDateBetween(dateOfVisit1, dateOfVisit2);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/user/visit/search/patient", params = {"firstName", "lastName"})
    String findByPatientByFullName(@RequestParam String firstName, String lastName, Model model) {
        List<Visit> visits = visitService.findByPatientByFullName(firstName, lastName);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/user/visit/search/treatment", params = "name")
    String findByTreatmentByName(@RequestParam String name, Model model) {
        List<Visit> visits = visitService.findByTreatmentByName(name);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/user/visit/search/specialist", params = {"firstName", "lastName"})
    String findBySpecialistByFullName(@RequestParam String firstName, String lastName, Model model) {
        List<Visit> visits = visitService.findBySpecialistByFullName(firstName, lastName);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

// umieszczenie w modelu pod kluczamim 'patients' kolekcji obiektow Patient,
    @ModelAttribute("patients")
    Collection<Patient> patients() {
        return patientService.findAll();
    }

// umieszczenie w modelu pod kluczamim 'treatments' kolekcji obiektow Treatment
    @ModelAttribute("treatments")
    Collection<Treatment> treatments() {
        return treatmentService.findAll();
    }

//  umieszczenie w modelu pod kluczamim 'specialists' kolekcji obiektow Specialist
    @ModelAttribute("specialists")
    Collection<Specialist> specialists() {
        return specialistService.findAll();
    }

}
