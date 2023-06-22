package pl.mziemba.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Category;
import pl.mziemba.entity.Insurance;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Specialist;
import pl.mziemba.service.PatientService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PatientController {
    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(path = "/patient")
    void save(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth, @RequestParam String pesel, @RequestParam String insuranceNumber, @RequestParam("categoryId") Long[] categoryIds, @RequestParam("specialistId") Long[] specialistIds) {

        final Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(dateOfBirth);
        patient.setPesel(pesel);

        Insurance insurance = new Insurance();
        insurance.setInsuranceNumber(insuranceNumber);
        patient.setInsurance(insurance);

        Set<Category> categories = Arrays.stream(categoryIds)
                .map(id -> new Category())
                .collect(Collectors.toSet());
        patient.setCategories(categories);
        patientService.save(patient);

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

    @GetMapping(path = "/patient/insurance", produces = "text/plain;charset=utf-8", params = "id")
    String findByInsurance(Insurance insurance) {
        final List<Patient> patients = patientService.findByInsurance(insurance);
        return patients.toString();
    }

    @GetMapping(path = "/patient/insurance", produces = "text/plain;charset=utf-8", params = "insuranceNumber")
    String findByInsuranceByNumber(@RequestParam("insuranceNumber") String insuranceNumber) {
        final List<Patient> patients = patientService.findByInsuranceByInsuranceNumber(insuranceNumber);
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
    String findByCategoryName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Patient> patients = patientService.findBySpecialistFullName(firstName, lastName);
        return patients.toString();
    }


}
