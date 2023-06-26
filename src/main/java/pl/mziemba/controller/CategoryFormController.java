package pl.mziemba.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mziemba.entity.Category;
import pl.mziemba.service.CategoryService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryFormController {
    
    private final CategoryService categoryService;

    // wyswietlenie formularza dodawania kategorii
    @GetMapping(path = "/category/add")
    String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    // obsluga formularza dodawania kategorii
    @PostMapping(path = "/category/add")
    String processAddCategoryForm(@Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/add";
        }
        categoryService.save(category);
        return "redirect:/category/list";
    }

    @GetMapping(path = "/category/edit")
    String showEditCategoryForm(@RequestParam Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping(path = "/category/edit")
    String processEditCategoryForm(@Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/edit";
        }
        categoryService.update(category);
        return "redirect:/category/list";
    }

    @GetMapping(path = "/category/remove")
    String processRemoveCategory(@RequestParam Long id) {
        categoryService.deleteById(id);
        return "redirect:/category/list";
    }

    // wyswietlanie listy wszystkich kategorii
    @GetMapping(path = "/category/list")
    String showCategoryList(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping(path = "/category/search")
    String showSearchCategoryForm() {
        return "category/search";
    }

    @GetMapping(path = "/category/search", params = "name")
    String findByPesel(@RequestParam String name, Model model) {
        List<Category> categories = categoryService.findByName(name);
        model.addAttribute("categories", categories);
        return "category/list";
    }

}
