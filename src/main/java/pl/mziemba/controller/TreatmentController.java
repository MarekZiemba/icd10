package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Treatment;
import pl.mziemba.service.SpecialistService;
import pl.mziemba.service.TreatmentService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentService treatmentService;
    private final SpecialistService specialistService;

    @PostMapping(path = "/treatment")
    void save(@RequestParam String name, @RequestParam String firstName,  @RequestParam String lastName, @RequestParam("specialistId") Long[] specialistIds) {

        final Treatment treatment = new Treatment();

        treatment.setName(name);

        Set<Specialist> specialists = Arrays.stream(specialistIds)
                .map(id -> new Specialist())
                .collect(Collectors.toSet());
        treatment.setSpecialists(specialists);
        treatmentService.save(treatment);
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

    @GetMapping(path = "/treatment/specialist", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findBySpecialistFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Treatment> treatments = treatmentService.findBySpecialistFullName(firstName, lastName);
        return treatments.toString();
    }

    @DeleteMapping(path = "/treatment/{id}")
    void deleteById(@PathVariable Long id) {
        treatmentService.deleteById(id);
    }

    // umieszczenie w modelu pod kluczem 'specializations' kolekcji obiektow Specialist
    @ModelAttribute("specialists")
    Collection<Specialist> findAllSpecialists() {
        return specialistService.findAll();
    }

}
