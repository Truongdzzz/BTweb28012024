package com.example.demo.sevice;

import com.example.demo.dto.request.CategoryCreationRequest;
import com.example.demo.entity.Category;
import com.example.demo.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {
    @Autowired
    private categoryRepository cr;

    public Category createCategory(CategoryCreationRequest request){
        Category category = new Category();
        category.setCost(request.getCost());
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setImage(request.getImage());
        cr.save(category);
        return category;
    }
    public List<Category> getAllCategories(){
        return cr.findAll();
    }
    public Category getCategoryById(long id){
        Category category = cr.findById(id).get();
        return category;
    }
    public Category updateCategory(long id, CategoryCreationRequest category){
        Category category1 = cr.findById(id).get();
        category1.setCost(category.getCost());
        category1.setName(category.getName());
        category1.setDescription(category.getDescription());
        category1.setImage(category.getImage());
        cr.save(category1);
        return category1;
    }
    public boolean deleteCategory(long id){
        try {
            cr.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
