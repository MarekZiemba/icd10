package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Specialization;
import pl.mziemba.service.SpecializationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService specializationService;

    @PostMapping(path = "/specialization")
    void save(@RequestParam String name) {

        final Specialization specialization = new Specialization();
        specialization.setName(name);
        specializationService.save(specialization);
    }

    @GetMapping(path = "/specializations", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Specialization> specializations = specializationService.findAll();
        return specializations.toString();
    }

    @GetMapping(path = "/specialization", produces = "text/plain;charset=utf-8")
    String findByName(@RequestParam("name") String name) {
        final List<Specialization> specializations = specializationService.findByName(name);
        return specializations.toString();
    }

    @DeleteMapping(path = "/specialization/{id}")
    void deleteById(@PathVariable Long id) {
        specializationService.deleteById(id);
    }

}
