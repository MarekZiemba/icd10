package pl.mziemba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mziemba.entity.Category;
import pl.mziemba.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    @PostMapping(path = "/category")
    void save(@RequestParam String name, @RequestParam String evaluationCriteria, @RequestParam String description) {

        final Category category = new Category();

        category.setName(name);
        category.setEvaluationCriteria(evaluationCriteria);
        category.setDescription(description);
    }

    @GetMapping(path = "/categories", produces = "text/plain;charset=utf-8")
    String findAll() {
        final List<Category> categories = categoryService.findAll();
        return categories.toString();
    }

    @GetMapping(path = "/category/name", produces = "text/plain;charset=utf-8")
    String findByPatientPesel(@RequestParam("name") String name) {
        final List<Category> categories = categoryService.findByName(name);
        return categories.toString();
    }
    
}
