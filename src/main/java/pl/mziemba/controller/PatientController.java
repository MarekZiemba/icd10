package pl.mziemba.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Category;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Specialist;
import pl.mziemba.service.PatientService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping(path = "/patient")
    void save(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth, @RequestParam String pesel, @RequestParam String insurance, @RequestParam("diagnosisId") Long[] diagnosisId, @RequestParam("categoryId") Long[] categoryIds,@RequestParam("specialistId") Long[] specialistIds) {

        final Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(dateOfBirth);
        patient.setPesel(pesel);
        patient.setInsurance(insurance);

        Set<Category> categories = Arrays.stream(categoryIds)
                .map(id -> new Category())
                .collect(Collectors.toSet());
        patient.setCategories(categories);

        Set<Diagnosis> diagnoses = Arrays.stream(diagnosisId)
                .map(id -> new Diagnosis())
                .collect(Collectors.toSet());
        patient.setDiagnosis(diagnoses);

        Set<Specialist> specialists = Arrays.stream(specialistIds)
                .map(id -> new Specialist())
                .collect(Collectors.toSet());
        patient.setSpecialists(specialists);
        patientService.save(patient);
    }

    @GetMapping(path = "/patients", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Patient> patients = patientService.findAll();
        return patients.toString();
    }

    @GetMapping(path = "/patient", produces = "text/plain;charset=utf-8")
    String findByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Patient> patients = patientService.findByFirstNameAndLastName(firstName, lastName);
        return patients.toString();
    }

    @GetMapping(path = "/patient/dateofbirth", produces = "text/plain;charset=utf-8")
    String findAllByPatientDateOfBirth(@RequestParam("dateOfBirth") String dateOfBirth) {
        final List<Patient> patients = patientService.findByDateOfBirth(dateOfBirth);
        return patients.toString();
    }

    @GetMapping(path = "/patient/pesel", produces = "text/plain;charset=utf-8")
    String findByPatientPesel(@RequestParam("pesel") String pesel) {
        final List<Patient> patients = patientService.findByPesel(pesel);
        return patients.toString();
    }

    /*
    @GetMapping(path = "/patient/{pesel}", produces = "text/plain;charset=utf-8")
String findByPatientPesel(@PathVariable @RequestParam("pesel") String pesel) {
    final List<Patient> patients = patientService.findByPesel(pesel);
    return patients.toString();
}
     */

    @GetMapping(path = "/patient/insurance", produces = "text/plain;charset=utf-8")
    String findByInsurance(@RequestParam("insurance") String insurance) {
        final List<Patient> patients = patientService.findByInsurance(insurance);
        return patients.toString();
    }

    @GetMapping(path = "/patient/category", produces = "text/plain;charset=utf-8", params = "id")
    String findByCategory(Category category) {
        final List<Patient> patients = patientService.findByCategory(category);
        return patients.toString();
    }

    @GetMapping(path = "/patient/category", produces = "text/plain;charset=utf-8", params = "name")
    String findByCategoryName(@RequestParam("name") String name) {
        final List<Patient> patients = patientService.findByCategoryName(name);
        return patients.toString();
    }

    @GetMapping(path = "/patient/specialist", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findBySpecialistFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Patient> patients = patientService.findBySpecialistFullName(firstName, lastName);
        return patients.toString();
    }

    @DeleteMapping(path = "/patient/{id}")
    void deleteById(@PathVariable Long id) {
        patientService.deleteById(id);
    }

}
