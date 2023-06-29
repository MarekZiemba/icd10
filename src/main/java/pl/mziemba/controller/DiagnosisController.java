package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.service.DiagnosisService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;
    
    @PostMapping(path = "/diagnosis")
    void save(@RequestParam String name, @RequestParam String diagnosisCriteria, @RequestParam String description) {

        final Diagnosis diagnosis = new Diagnosis();

        diagnosis.setName(name);
        diagnosis.setDiagnosisCriteria(diagnosisCriteria);
        diagnosis.setDescription(description);
    }

    @GetMapping(path = "/diagnoses", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Diagnosis> diagnoses = diagnosisService.findAll();
        return diagnoses.toString();
    }

    @GetMapping(path = "/diagnosis/name", produces = "text/plain;charset=utf-8")
    String findByPatientPesel(@RequestParam("name") String name) {
        final List<Diagnosis> diagnoses = diagnosisService.findByName(name);
        return diagnoses.toString();
    }
}
