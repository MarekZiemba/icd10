package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.service.DiagnosisService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;
    
    @PostMapping(path = "/diagnosis")
    void save(@RequestParam String name, @RequestParam String evaluationCriteria, @RequestParam String description) {

        final Diagnosis diagnosis = new Diagnosis();

        diagnosis.setName(name);
        diagnosis.setEvaluationCriteria(evaluationCriteria);
        diagnosisService.save(diagnosis);

    }

    @GetMapping(path = "/diagnoses", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Diagnosis> diagnoses = diagnosisService.findAll();
        return diagnoses.toString();
    }

    @GetMapping(path = "/diagnosis/name", produces = "text/plain;charset=utf-8")
    String findByName(@RequestParam("name") String name) {
        final List<Diagnosis> diagnoses = diagnosisService.findByName(name);
        return diagnoses.toString();
    }

    @DeleteMapping(path = "/diagnosis/{id}")
    void deleteById(@PathVariable Long id) {
        diagnosisService.deleteById(id);
    }
}
