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
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Specialist;
import pl.mziemba.security.LoggedInUserDetails;
import pl.mziemba.service.DiagnosisService;
import pl.mziemba.service.PatientService;
import pl.mziemba.service.SpecialistService;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientFormController {

    private final PatientService patientService;
    private final DiagnosisService diagnosisService;
    private final SpecialistService specialistService;
    private final LoggedInUserDetails loggedInUserDetails;

    // wyswietlenie formularza dodawania pacjenta
    @GetMapping(path = "/user/patient/add")
    String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());

        // Odczytaj aktualnie zalogowanego specjalistę
        String loggedInSpecialistId = loggedInUserDetails.getLoggedInSpecialistId();
        model.addAttribute("loggedInSpecialistId", loggedInSpecialistId);

        String loggedInUserFullName = loggedInUserDetails.getLoggedInUserFullName();
        model.addAttribute("loggedInUserFullName", loggedInUserFullName);

        return "patient/add";
    }

    // obsluga formularza dodawania pacjentów
    @PostMapping(path = "/user/patient/add")
    String processAddPatientForm(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient/add";
        }
        patientService.save(patient);
        return "redirect:/user/patient/list";
    }

    @GetMapping(path = "/user/patient/edit")
    String showEditPatientForm(@RequestParam Long id, Model model) {
        model.addAttribute("patient", patientService.findById(id));

        // Odczytaj aktualnie zalogowanego specjalistę
        String loggedInSpecialistId = loggedInUserDetails.getLoggedInSpecialistId();
        model.addAttribute("loggedInSpecialistId", loggedInSpecialistId);

        String loggedInUserFullName = loggedInUserDetails.getLoggedInUserFullName();
        model.addAttribute("loggedInUserFullName", loggedInUserFullName);

        return "patient/edit";
    }

    @PostMapping(path = "/user/patient/edit")
    String processEditPatientForm(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient/edit";
        }
        patientService.update(patient);
        return "redirect:/user/patient/list";
    }

    @GetMapping(path = "/user/patient/remove")
    String processRemovePatient(@RequestParam Long id) {
        patientService.deleteById(id);
        return "redirect:/user/patient/list";
    }

    // wyswietlanie listy wszystkich pacjentów
    @GetMapping(path = "/user/patient/list")
    String showPatientList(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping(path = "/user/patient/search")
    String showSearchPatientForm() {
        return "patient/search";
    }

    // np. http://localhost:8080/patient/search?firstName&lastName=Jan+Kowalski
    @GetMapping(path = "/user/patient/search", params = {"firstName", "lastName"})
    String findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        List<Patient> patients = patientService.findByFirstNameAndLastName(firstName,  lastName);
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping(path = "/user/patient/search", params = "dateOfBirth")
    String findByDateOfBirth(@RequestParam String dateOfBirth, Model model) {
        List<Patient> patients = patientService.findByDateOfBirth(dateOfBirth);
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping(path = "/user/patient/search", params = "pesel")
    String findByPesel(@RequestParam String pesel, Model model) {
        List<Patient> patients = patientService.findByPesel(pesel);
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping(path = "/user/patient/search", params = "insurance")
    String findByInsurance(@RequestParam String insurance, Model model) {
        List<Patient> patients = patientService.findByInsurance(insurance);
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping(path = "/user/patient/search/diagnosis", params = "name")
    String findByDiagnosis(@RequestParam String name, Model model) {
        List<Patient> patients = patientService.findByDiagnosisNameContains(name);
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping(path = "/user/patient/search/specialist", params = {"firstName", "lastName"})
    String findBySpecialist(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        List<Patient> patients = patientService.findBySpecialistFullName(firstName, lastName);
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    // umieszczenie w modelu pod kluczem 'diagnoses' kolekcji obiektow Diagnosis
    @ModelAttribute("diagnoses")
    Collection<Diagnosis> diagnoses() {
        return diagnosisService.findAll();
    }

    @ModelAttribute("specialists")
    Collection<Specialist> specialists() {
        return specialistService.findAll();
    }

}
