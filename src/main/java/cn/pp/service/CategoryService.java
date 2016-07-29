package cn.pp.service;

import cn.pp.common.dao.CategoryDAO;
import cn.pp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @author zjc
 * @version 2016/5/20 2:15
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public void saveCategoryWithCascade() {
        Category foodCategory = new Category("food", new HashSet(), null);
        Category fruitCategory = new Category("fruit", new HashSet(), null);
        Category vegetableCategory = new Category("vegetable", new HashSet(), null);
        Category appleCategory = new Category("apple", new HashSet(), null);
        Category orangeCategory = new Category("orange", new HashSet(), null);
        Category tomatoCategory = new Category("tomato", new HashSet(), null);

        foodCategory.getChildCategories().add(fruitCategory);
        fruitCategory.setParentCategory(foodCategory);

        foodCategory.getChildCategories().add(vegetableCategory);
        vegetableCategory.setParentCategory(foodCategory);

        fruitCategory.getChildCategories().add(appleCategory);
        appleCategory.setParentCategory(fruitCategory);

        fruitCategory.getChildCategories().add(orangeCategory);
        orangeCategory.setParentCategory(fruitCategory);

        tomatoCategory.setParentCategory(fruitCategory);
        fruitCategory.getChildCategories().add(tomatoCategory);

        categoryDAO.saveInt(foodCategory);
    }

    public void modifyCategoryAssociation() {
        Category tomatoCategory = categoryDAO.findCategoryByName("tomato");
        Category fruitCategory = categoryDAO.findCategoryByName("fruit");
        Category vegetableCategory = categoryDAO.findCategoryByName("vegetable");

        tomatoCategory.setParentCategory(vegetableCategory);
        vegetableCategory.getChildCategories().add(tomatoCategory);
        fruitCategory.getChildCategories().remove(tomatoCategory);
    }

}
