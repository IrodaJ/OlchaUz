package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements BaseService{
    static List<Category>categories=new ArrayList<>();

    public boolean add(Category category){
        for (Category category1:categories) {
            if (category1.getName().equals(category.getName())) {
                return false;
            }
        }
            categories.add(category);
            return true;
    }
    @Override
    public boolean delete(int categoryId) {
        for (Category category:categories) {
            if (category!=null){
                if (category.getId()==categoryId){
                    categories.remove(category);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getById(int id) {
        for (Category category:categories) {
            if (category!=null){
                if (category.getId()==id)
                    return category;
            }
        }
        return null;
    }
    public void showParentCategories(){
        for (Category category : categories) {
            if (category!=null) {
                if (category.getParentId() == 0) {
                    System.out.println(category);
                }
            }
        }
    }
    public void showAllCategories(){
        for (Category category : categories) {
            if (category!=null)
                System.out.println(category);
        }
    }
    public void showSubCategories(int parentId){
        for (Category category:categories) {
            if (category!=null){
                if (category.getParentId()==parentId){
                    System.out.println(category);
                }
            }
        }
    }
}
