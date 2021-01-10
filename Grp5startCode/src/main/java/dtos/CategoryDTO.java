/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Wagner
 */
public class CategoryDTO {

    private String name;
    private List<CategoryDTO> allCategories = new ArrayList();

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO(Category c) {
        this.name = c.getName();
    }

    public CategoryDTO(List<Category> categoryList) {
        categoryList.forEach((c) -> {
            allCategories.add(new CategoryDTO(c));
        });
    }
}
