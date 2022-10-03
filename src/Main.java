import model.Category;
import model.Product;
import model.User;
import service.CategoryService;
import service.ProductService;
import service.UserService;

import java.util.Scanner;

public class Main {
       static Scanner scannerInt=new Scanner(System.in);
        static Scanner scannerStr=new Scanner(System.in);
        static UserService userService=new UserService();
        static CategoryService categoryService=new CategoryService();
        static ProductService productService=new ProductService();

    public static void main(String[] args) {

        int var1=10;
        while (var1!=0) {
            System.out.println("1.LogIn 2.Register 0.EXIT");
            var1=scannerInt.nextInt();
            switch (var1){
                case 1->{
                    System.out.println("enter phoneNumber: ");
                    String phoneNumber=scannerStr.nextLine();
                    System.out.println("enter password: ");
                    String password= scannerStr.nextLine();
                    User curretUser=userService.login(phoneNumber,password);
                    if (curretUser!=null){
                        if (curretUser.getRole().equals("ADMIN")){
                            forAdmin();
                        } else if (curretUser.getRole().equals("USER")) {
                            forUser();
                        }
                    }
                }
                case 2->{
                    User user=new User();
                    System.out.println("enter name: ");
                    user.setName(scannerStr.nextLine());
                    System.out.println("enter phoneNumber: ");
                    user.setPhoneNumber(scannerStr.nextLine());
                    System.out.println("enter password: ");
                    user.setPassword(scannerStr.nextLine());
                    System.out.println("enter role: ");
                    user.setRole(scannerStr.nextLine());
                    System.out.println(userService.add(user));
                }
                case 0->{}
            }
        }
    }
   private static void forAdmin(){
        int var1=10;
        while (var1!=0) {
            System.out.println("1.Category 2.Product 3.OrderList 0.back");
            var1=scannerInt.nextInt();
            switch (var1){
                case 1->{
                    categoryForAdmin();
                }
                case 2->{
                    productForAdmin();
                }
                case 3->{
                    orderListForAdmin();
                }
                case 0->{}
            }
        }
   }

    private static void forUser(){
        int var3=10;
        while (var3!=0) {
            System.out.println("1.CategoryList 2.OrderList 0.back");
            var3=scannerInt.nextInt();
            switch (var3){
                case 1->{
                    categoryService.showParentCategories();

                }
                case 2->{

                }
                case 0->{}
            }
        }
    }

    private static void orderListForAdmin() {
    }

    private static void productForAdmin() {
        int var5=10;
        while (var5!=0){
            System.out.println("1.addProduct 2.deleteProduct 3.showProductList 0.back");
            var5=scannerInt.nextInt();
            switch (var5){
                case 1->{
                    Product product=new Product();
                    System.out.println("enter name: ");
                    product.setName(scannerStr.nextLine());
                    System.out.println("enter price: ");
                    product.setPrice(new Scanner(System.in).nextDouble());
                    System.out.println("enter count: ");
                    product.setCount(scannerInt.nextInt());

                    categoryService.showAllCategories();

                    System.out.println("enter categoryId:");
                    product.setCategoryId(scannerInt.nextInt());
                    System.out.println(productService.add(product));
                }
                case 2->{
                    System.out.println("enter productId:");
                    productService.delete(scannerInt.nextInt());
                }
                case 3->{
                    productService.showList();
                }
                case 0->{

                }
            }
        }

    }

    private static void categoryForAdmin() {
        int var2=10;
        while (var2!=0) {
            System.out.println("1.addCategory 2.deleteCategory 3.showCategoryList 0.back");
            var2=scannerInt.nextInt();
            switch (var2){
                case 1->{
                    Category category = new Category();
                    System.out.println("enter name: ");
                    category.setName(scannerStr.nextLine());
                    System.out.println("enter parentId: ");
                    category.setParentId(scannerInt.nextInt());
                    System.out.println(categoryService.add(category));
                }
                case 2->{
                    System.out.println("enter categoryId:");
                    int categoryId=scannerInt.nextInt();
                    System.out.println(categoryService.delete(categoryId));
                }
                case 3-> {
                    categoryService.showParentCategories();
                    int var4 = 10;
                    while (var4 != 0) {
                        System.out.println("enter categoryId: (0.exit)");
                        var4=scannerInt.nextInt();
                        categoryService.showSubCategories(var4);
                        if (categoryService.getById(var4)==null){
                            System.out.println("Hi");
                        }
                    }
                }
                case 0->{}
            }

        }
    }
}