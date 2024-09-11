package com.partiw.api.controller;

import com.partiw.api.domain.category.Category;
import com.partiw.api.domain.category.CategoryRequestDTO;
import com.partiw.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> create(@RequestParam("name") String name,
                                           @RequestParam("valueMax") Integer valueMax,
                                           @RequestParam("coParticipation") Integer coParticipation,
                                           @RequestParam("companyId") UUID companyId) {
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO(name, valueMax, coParticipation, companyId);
        Category newCategory = this.categoryService.createCategory(categoryRequestDTO);
        return ResponseEntity.ok(newCategory);
    }

    @GetMapping
    public ResponseEntity<Category> get(@RequestParam("categoryId") UUID categoryId) {
        Category category = this.categoryService.getCategory(categoryId);
        return ResponseEntity.ok(category);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/company")
    public ResponseEntity<List<Category>> getAllCategory(@RequestParam("companyId") UUID companyId) {
        List<Category>  category = this.categoryService.getCategoryByCompany(companyId);
        return ResponseEntity.ok(category);
    }
}
