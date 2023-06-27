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
    @GetMapping(path = "/visit/add")
    String showAddVisitForm(Model model) {
        model.addAttribute("visit", new Visit());
        return "visit/add";
    }

    // obsluga formularza dodawania wizyty
    @PostMapping(path = "/visit/add")
    String processAddVisitForm(@Valid Visit visit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "visit/add";
        }
        visitService.save(visit);
        return "redirect:/visit/list";
    }

    @GetMapping(path = "/visit/edit")
    String showEditVisitForm(@RequestParam Long id, Model model) {
        model.addAttribute("visit", visitService.findById(id));
        return "visit/edit";
    }

    @PostMapping(path = "/visit/edit")
    String processEditVisitForm(@Valid Visit visit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "visit/edit";
        }
        visitService.update(visit);
        return "redirect:/visit/list";
    }

    @GetMapping(path = "/visit/remove")
    String processRemoveVisit(@RequestParam Long id) {
        visitService.deleteById(id);
        return "redirect:/visit/list";
    }

    // wyswietlanie listy wszystkich specjalistów
    @GetMapping(path = "/visit/list")
    String showVisitList(Model model) {
        List<Visit> visits = visitService.findAll();
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/visit/search")
    String showSearchVisitForm() {
        return "visit/search";
    }

    @GetMapping(path = "/visit/search", params = "dateOfVisit")
    String findByDate(@RequestParam String dateOfVisit, Model model) {
        List<Visit> visits = visitService.findByDate(dateOfVisit);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/visit/search", params = {"dateOfVisit", "timeOfVisit"})
    String findByDateAndTime(@RequestParam String dateOfVisit, String timeOfVisit, Model model) {
        List<Visit> visits = visitService.findByDateAndTime(dateOfVisit, timeOfVisit);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/visit/search/patient", params = {"firstName", "lastName"})
    String findByPatientByFullName(@RequestParam String firstName, String lastName, Model model) {
        List<Visit> visits = visitService.findByPatientByFullName(firstName, lastName);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/visit/search/treatment", params = "name")
    String findByTreatmentByName(@RequestParam String name, Model model) {
        List<Visit> visits = visitService.findByTreatmentByName(name);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

    @GetMapping(path = "/visit/search/specialist", params = {"firstName", "lastName"})
    String findBySpecialistByFullName(@RequestParam String firstName, String lastName, Model model) {
        List<Visit> visits = visitService.findBySpecialistByFullName(firstName, lastName);
        model.addAttribute("visits", visits);
        return "visit/list";
    }

// umieszczenie w modelu pod kluczamim 'patients' kolekcji obiektow Patient,
    @ModelAttribute("specializations")
    Collection<Patient> patients() {
        return patientService.findAll();
    }

//umieszczenie w modelu pod kluczamim 'treatments' kolekcji obiektow Treatment
    @ModelAttribute("specializations")
    Collection<Treatment> treatments() {
        return treatmentService.findAll();
    }

//    mieszczenie w modelu pod kluczamim 'specialists' kolekcji obiektow Specialist
    @ModelAttribute("specializations")
    Collection<Specialist> specialists() {
        return specialistService.findAll();
    }


//    // umieszczenie w modelu pod odpowiednimi kluczami, kolekcji odpowiadających obiektów
//    @ModelAttribute("patients")
//    Collection<Patient> findAllPatients() {
//        return patientService.findAll();
//    }
//
//    @ModelAttribute("treatments")
//    Collection<Treatment> findAllTreatments() {
//        return treatmentService.findAll();
//    }
//
//    @ModelAttribute("specialists")
//    Collection<Specialist> findAllSpecialists() {
//        return specialistService.findAll();
//    }
}
