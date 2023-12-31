package pl.mziemba.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.service.DiagnosisService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DiagnosisFormController {

    private final DiagnosisService diagnosisService;

    // wyswietlenie formularza dodawania rozpoznania
    @GetMapping(path = "/admin/diagnosis/add")
    String showAddDiagnosisForm(Model model) {
        model.addAttribute("diagnosis", new Diagnosis());
        return "diagnosis/add";
    }

    // obsluga formularza dodawania rozpoznania
    @PostMapping(path = "/admin/diagnosis/add")
    String processAddDiagnosisForm(@Valid Diagnosis diagnosis, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "diagnosis/add";
        }
        diagnosisService.save(diagnosis);
        return "redirect:/user/diagnosis/list";
    }

    @GetMapping(path = "/admin/diagnosis/edit")
    String showEditDiagnosisForm(@RequestParam Long id, Model model) {
        model.addAttribute("diagnosis", diagnosisService.findById(id));
        return "diagnosis/edit";
    }

    @PostMapping(path = "/admin/diagnosis/edit")
    String processEditDiagnosisForm(@Valid Diagnosis diagnosis, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "diagnosis/edit";
        }
        diagnosisService.update(diagnosis);
        return "redirect:/user/diagnosis/list";
    }

    @GetMapping(path = "/admin/diagnosis/remove")
    String processRemoveDiagnosis(@RequestParam Long id) {
        diagnosisService.deleteById(id);
        return "redirect:/user/diagnosis/list";
    }

    // wyswietlanie listy wszystkich kategorii
    @GetMapping(path = "/user/diagnosis/list")
    String showDiagnosisList(Model model) {
        List<Diagnosis> diagnoses = diagnosisService.findAll();
        model.addAttribute("diagnoses", diagnoses);
        return "diagnosis/list";
    }

    @GetMapping(path = "/user/diagnosis/search")
    String showSearchDiagnosisForm() {
        return "diagnosis/search";
    }

    @GetMapping(path = "/user/diagnosis/search", params = "name")
    String findByName(@RequestParam String name, Model model) {
        List<Diagnosis> diagnoses = diagnosisService.findByName(name);
        model.addAttribute("diagnoses", diagnoses);
        return "diagnosis/list";
    }

}
