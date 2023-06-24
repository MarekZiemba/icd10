package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Specialization;
import pl.mziemba.service.SpecialistService;
import pl.mziemba.service.SpecializationService;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpecialistController {

    private final SpecialistService specialistService;
    private final SpecializationService specializationService;

//    public SpecialistController(SpecialistService specialistService, SpecializationService specializationService) {
//        this.specialistService = specialistService;
//        this.specializationService = specializationService;
//    }

    @PostMapping(path = "/specialist")
    void save(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth, @RequestParam String pesel, @RequestParam String name) {

        final Specialist specialist = new Specialist();

        specialist.setFirstName(firstName);
        specialist.setLastName(lastName);
        specialist.setDateOfBirth(dateOfBirth);
        specialist.setPesel(pesel);

        Specialization specialization = new Specialization();
        specialization.setName(name);
        specialist.setSpecialization (specialization);
    }

    @GetMapping(path = "/specialists", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Specialist> specialists = specialistService.findAll();
        return specialists.toString();
    }

    @GetMapping(path = "/specialist", produces = "text/plain;charset=utf-8")
    String findByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Specialist> specialists = specialistService.findByFirstNameAndLastName(firstName, lastName);
        return specialists.toString();
    }

    @GetMapping(path = "/specialist/dateOfbirth", produces = "text/plain;charset=utf-8")
    String findAllByPatientDateOfBirth(@RequestParam("dateOfBirth") String dateOfBirth) {
        final List<Specialist> specialists = specialistService.findByDateOfBirth(dateOfBirth);
        return specialists.toString();
    }

    @GetMapping(path = "/specialist/pesel", produces = "text/plain;charset=utf-8")
    String findByPatientPesel(@RequestParam("pesel") String pesel) {
        final List<Specialist> specialists = specialistService.findByPesel(pesel);
        return specialists.toString();
    }

    @GetMapping(path = "/specialist/insurance", produces = "text/plain;charset=utf-8", params = "id")
    String findByInsurance(Specialization specialization) {
        final List<Specialist> specialists = specialistService.findBySpecialization(specialization);
        return specialists.toString();
    }

    @GetMapping(path = "/specialist/insurance", produces = "text/plain;charset=utf-8", params = "insuranceNumber")
    String findByInsuranceByNumber(@RequestParam("insuranceNumber") String name) {
        final List<Specialist> specialists = specialistService.findBySpecializationByName(name);
        return specialists.toString();
    }

    // umieszczenie w modelu pod kluczem 'specializations' kolekcji obiektow Specialization
    @ModelAttribute("specializations")
    Collection<Specialization> findAllSpecializations() {
        return specializationService.findAll();
    }

}
