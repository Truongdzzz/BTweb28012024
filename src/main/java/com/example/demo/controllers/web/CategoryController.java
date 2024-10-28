package com.example.demo.controllers.web;

import com.example.demo.dto.request.CategoryCreationRequest;
import com.example.demo.entity.Category;
import com.example.demo.sevice.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private categoryService cs;
    @PostMapping("/category")
    Category addCategory(@RequestBody CategoryCreationRequest c) {
        return cs.createCategory(c);
    }
    @GetMapping("/category")
    public String getALlCategories(Model model) {
        List<Category> listCate = cs.getAllCategories();
        model.addAttribute("categories", listCate);
        return "category.html";
    }
    @GetMapping("/category/update/{id}")
    public String updateCategory(@PathVariable long id,Model model) {
        Category category = cs.getCategoryById(id);
        model.addAttribute("category", category);
        return "categoryUpdate.html";
    }
    @PutMapping("/category/{id}")
    Category updateCategory(@PathVariable int id, @RequestBody CategoryCreationRequest c) {
        return cs.updateCategory(id, c);
    }
    @DeleteMapping("category/{id}")
    String deleteCategory(@PathVariable int id) {
        cs.deleteCategory(id);
        return "Deleted Category "+id;
    }
}
