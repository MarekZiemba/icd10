package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.*;
import pl.mziemba.service.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;
    private final PatientService patientService;
    private final TreatmentService treatmentService;
    private final SpecialistService specialistService;

    @PostMapping(path = "/visit")
    void save(@RequestParam String dateOfVisit, @RequestParam String timeOfVisit, @RequestParam String description, @RequestParam String patientFirstName, @RequestParam String patientLastName, @RequestParam String name, @RequestParam String firstName, @RequestParam String lastName) {

        final Visit visit = new Visit();

        visit.setDateOfVisit(dateOfVisit);
        visit.setTimeOfVisit(timeOfVisit);
        visit.setDescription(description);

        Patient patient = new Patient();
        patient.setFirstName(patientFirstName);
        patient.setLastName(patientLastName);
        visit.setPatient (patient);

        Treatment treatment = new Treatment();
        treatment.setName(name);
        visit.setTreatment (treatment);

        Specialist specialist = new Specialist();
        specialist.setFirstName(firstName);
        specialist.setLastName(lastName);
        visit.setSpecialist (specialist);
    }

    @GetMapping(path = "/visits", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Visit> visits = visitService.findAll();
        return visits.toString();
    }

    @GetMapping(path = "/visit/DateAndTime", produces = "text/plain;charset=utf-8")
    String findByPatientPesel(@RequestParam("dateOfVisit") String dateOfVisit, @RequestParam("timeOfVisit") String timeOfVisit) {
        final List<Visit> visits = visitService.findByDateAndTime(dateOfVisit, timeOfVisit);
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
    String findByTreatment(@RequestParam("name") String name) {
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

    // umieszczenie w modelu pod odpowiednimi kluczami, kolekcji odpowiadających obiektów
    @ModelAttribute("patients")
    Collection<Patient> findAllPatients() {
        return patientService.findAll();
    }

    @ModelAttribute("treatments")
    Collection<Treatment> findAllTreatments() {
        return treatmentService.findAll();
    }

    @ModelAttribute("specialists")
    Collection<Specialist> findAllSpecialists() {
        return specialistService.findAll();
    }


}
