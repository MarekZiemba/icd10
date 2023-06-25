package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Treatment;
import pl.mziemba.entity.Specialization;
import pl.mziemba.service.SpecialistService;
import pl.mziemba.service.TreatmentService;
import pl.mziemba.service.SpecializationService;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentService treatmentService;
    private final SpecialistService specialistService;

    @PostMapping(path = "/treatment")
    void save(@RequestParam String name, @RequestParam String firstName,  @RequestParam String lastName) {

        final Treatment treatment = new Treatment();

        treatment.setName(name);

        Specialist specialist = new Specialist();
        specialist.setFirstName(firstName);
        specialist.setLastName(lastName);
        treatment.setSpecialist(specialist);
    }

    @GetMapping(path = "/treatments", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Treatment> treatments = treatmentService.findAll();
        return treatments.toString();
    }

    @GetMapping(path = "/treatment/name", produces = "text/plain;charset=utf-8")
    String findByName(@RequestParam("name") String name) {
        final List<Treatment> treatments = treatmentService.findByName(name);
        return treatments.toString();
    }

    @GetMapping(path = "/treatment/specialist", produces = "text/plain;charset=utf-8", params = "id")
    String findBySpecialist(Specialist specialist) {
        final List<Treatment> treatments = treatmentService.findBySpecialist(specialist);
        return treatments.toString();
    }

    @GetMapping(path = "/treatment/specialist", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findBySpecialistFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Treatment> treatments = treatmentService.findBySpecialistFullName(firstName, lastName);
        return treatments.toString();
    }

    // umieszczenie w modelu pod kluczem 'specializations' kolekcji obiektow Specialist
    @ModelAttribute("specialist")
    Collection<Specialist> findAllSpecialists() {
        return specialistService.findAll();
    }

}
