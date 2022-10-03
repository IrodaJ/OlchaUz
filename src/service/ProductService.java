package service;

import model.Base;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements BaseService {
    static List<Product>products=new ArrayList<>();
    public boolean add(Product product){
        for (Product product1 : products) {
            if (product1!=null){
            if (product1.getName().equals(product.getName())) {
                return false;
            }
            }
        }
        for (Category category : CategoryService.categories) {
            if (category.getId() == product.getCategoryId() && getById(product.getCategoryId()) == null) {
                        products.add(product);
                        return true;
            }
        }
        return false;
    }
    public void showList(){
        for (Product product : products) {
            if (product!=null){
                System.out.println(product);
            }
        }
    }
    @Override
    public boolean delete(int productId) {
        for (Product product : products) {
            if (product!=null){
                if (product.getId()==productId){
                    products.remove(product);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object getById(int productId) {
        for (Product product : products) {
            if (product!=null){
                if (product.getId()==productId){
                    return product;
                }
            }
        }
        return null;
    }
}
