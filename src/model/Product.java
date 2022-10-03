package model;

public class Product extends Base {
    private double price;
    private int categoryId;
    private int count;

    public Product(double price, int categoryId, int count) {
        this.price = price;
        this.categoryId = categoryId;
        this.count = count;
    }
    public Product(){
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", categoryId=" + categoryId +
                ", count=" + count +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
