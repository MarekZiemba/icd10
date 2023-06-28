package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.*;
import pl.mziemba.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;
    private final PatientService patientService;
    private final TreatmentService treatmentService;
    private final SpecialistService specialistService;

    @PostMapping(path = "/visit")
    void save(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfVisit, @RequestParam LocalTime timeOfVisit, @RequestParam String description, @RequestParam String patientFirstName, @RequestParam String patientLastName, @RequestParam String name, @RequestParam String specialistFirstName, @RequestParam String specialistLastName) {

        final Visit visit = new Visit();

        visit.setDateOfVisit(dateOfVisit);
        visit.setTimeOfVisit(timeOfVisit);
        visit.setDescription(description);

        Patient patient = new Patient();
        patient.setFirstName(patientFirstName);
        patient.setLastName(patientLastName);
        patientService.save(patient);
        visit.setPatient(patient);

        Treatment treatment = new Treatment();
        treatment.setName(name);
        treatmentService.save(treatment);
        visit.setTreatment(treatment);

        Specialist specialist = new Specialist();
        specialist.setFirstName(specialistFirstName);
        specialist.setLastName(specialistLastName);
        specialistService.save(specialist);
        visit.setSpecialist(specialist);

        visitService.save(visit);
    }

    @GetMapping(path = "/visits", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Visit> visits = visitService.findAll();
        return visits.toString();
    }

    @GetMapping(path = "/visit/Date", produces = "text/plain;charset=utf-8")
    String findByDate(@RequestParam("dateOfVisit") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfVisit) {
        final List<Visit> visits = visitService.findByDate(dateOfVisit);
        return visits.toString();
    }

    @GetMapping(path = "/visit/DateAndTime", produces = "text/plain;charset=utf-8")
    String findByDateAndTime(@RequestParam("dateOfVisit") LocalDate dateOfVisit, @RequestParam("timeOfVisit") LocalTime timeOfVisit) {
        final List<Visit> visits = visitService.findByDateAndTime(dateOfVisit, timeOfVisit);
        return visits.toString();
    }

    @GetMapping(path = "/visit/DateAndTimeBetween", produces = "text/plain;charset=utf-8")
    String findByDateBetween(@RequestParam("dateOfVisit") LocalDate dateOfVisit1, @RequestParam("timeOfVisit") LocalDate dateOfVisit2) {
        final List<Visit> visits = visitService.findByDateBetween(dateOfVisit1, dateOfVisit2);
        return visits.toString();
    }

    @GetMapping(path = "/visit/patient", produces = "text/plain;charset=utf-8", params = "id")
    String findByPatient(Patient patient) {
        final List<Visit> visits = visitService.findByPatient(patient);
        return visits.toString();
    }

    @GetMapping(path = "/visit/patient", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findByPatientFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Visit> visits = visitService.findByPatientByFullName(firstName, lastName);
        return visits.toString();
    }

    @GetMapping(path = "/visit/treatment", produces = "text/plain;charset=utf-8", params = "id")
    String findByTreatment(Treatment treatment) {
        final List<Visit> visits = visitService.findByTreatment(treatment);
        return visits.toString();
    }

    @GetMapping(path = "/visit/treatment", produces = "text/plain;charset=utf-8", params = "name")
    String findByTreatmentByName(@RequestParam("name") String name) {
        final List<Visit> visits = visitService.findByTreatmentByName(name);
        return visits.toString();
    }

    @GetMapping(path = "/visit/specialist", produces = "text/plain;charset=utf-8", params = "id")
    String findBySpecialist(Specialist specialist) {
        final List<Visit> visits = visitService.findBySpecialist(specialist);
        return visits.toString();
    }

    @GetMapping(path = "/visit/specialist", produces = "text/plain;charset=utf-8", params = {"firstName", "lastName"})
    String findByPSpecialistFullName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        final List<Visit> visits = visitService.findBySpecialistByFullName(firstName, lastName);
        return visits.toString();
    }

    @DeleteMapping(path = "/visit/{id}")
    void deleteById(@PathVariable Long id) {
        visitService.deleteById(id);
    }
}
