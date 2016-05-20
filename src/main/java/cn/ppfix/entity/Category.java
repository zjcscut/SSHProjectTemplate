package cn.ppfix.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjc
 * @version 2016/5/20 2:09
 */
public class Category implements java.io.Serializable {
    private Integer id;
    private String name;
    private Set<Category> childCategories = new HashSet<>(0);
    private Category parentCategory;

    public Category() {
    }

    public Category(String name, Set<Category> childCategories, Category parentCategory) {
        this.name = name;
        this.childCategories = childCategories;
        this.parentCategory = parentCategory;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getChildCategories() {
        return this.childCategories;
    }

    public void setChildCategories(Set<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public Category getParentCategory() {
        return this.parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

}
