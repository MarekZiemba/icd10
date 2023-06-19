package pl.mziemba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mziemba.entity.Patient;
import pl.mziemba.service.PatientService;

import java.util.List;

@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "/patients", produces = "text/plain;charset=utf-8")
    String findAll() {

        final List<Patient> patients = patientService.findAll();

        return patients.toString();
    }

}
