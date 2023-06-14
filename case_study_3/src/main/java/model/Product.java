package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id ;

    private Category category;

    private String name;
    private double price;
    private String describle;
    private int quantity;
    private String image;

    private List<ProductSize> productSizes= new ArrayList<>();

    public Product() {

    }

    public Product(int id,Category category ,String name, double price, String describle, int quantity, String image ) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.describle = describle;
        this.quantity = quantity;
        this.image = image;
    }
    public Product(int id ,String name, double price, String describle, int quantity, String image,Category category ) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.describle = describle;
        this.quantity = quantity;
        this.image = image;
    }

    public Product(int id, String product_name, double product_price, String product_describe, int quantity, String img) {
        this.id = id;
        this.name = product_name;
        this.price = product_price;
        this.describle = product_describe;
        this.quantity = quantity;
        this.image = img;
    }

    public Product(int product_id, String product_name, String img) {
        this.id = product_id;
        this.name = product_name;
        this.image = img;
    }

    public Product(Category category, String name, double price, String describle, int quantity, String image) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.describle = describle;
        this.quantity = quantity;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }
}
