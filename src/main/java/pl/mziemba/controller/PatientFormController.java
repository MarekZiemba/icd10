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
import pl.mziemba.entity.Category;
import pl.mziemba.entity.Insurance;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Specialist;
import pl.mziemba.service.PatientService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientFormController {

    private final PatientService patientService;

    // wyswietlenie formularza dodawania pacjenta
    @GetMapping(path = "/patient/add")
    String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
//            model.addAttribute("categories", categoryService.getAllCategories());
//    model.addAttribute("specialists", specialistService.getAllSpecialists())
        return "patient/add";
    }

    // obsluga formularza dodawania pacjentów
    @PostMapping(path = "/patient/add")
    String processAddPatientForm(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient/add";
        }
        patientService.save(patient);
        return "redirect:/patient/list";
    }

    @GetMapping(path = "/patient/edit")
    String showEditPatientForm(@RequestParam Long id, Model model) {
        model.addAttribute("patient", patientService.findById(id));
        return "patient/edit";
    }

    @PostMapping(path = "/patient/edit")
    String processEditPatientForm(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient/edit";
        }
        patientService.update(patient);
        return "redirect:/patient/list";
    }

    @GetMapping(path = "/patient/remove")
    String processRemovePatient(@RequestParam Long id) {
        patientService.deleteById(id);
        return "redirect:/patient/list";
    }

    // wyswietlanie listy wszystkich pacjentów
    @GetMapping(path = "/patient/list")
    String showPatientList(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patient/list";
    }

//    @ModelAttribute("insurance")
//    Collection<Insurance> insurances() {
//        return insuranceService.findAll();
//    }
//
//    @ModelAttribute("authors")
//    Collection<Category> categories() {
//        return categoryService.findAll();
//    }
//
//    Collection<Specialist> specialists() {
//        return specialistService.findAll();
//    }



}
