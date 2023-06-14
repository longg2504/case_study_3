package model;

import java.util.ArrayList;

public class Category {
    private int id;
    private String name;

    private ArrayList<Product> product = new ArrayList<>();

    public Category() {

    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String category_name) {
        this.name = category_name;
    }

    public Category(int category_id) {
        this.id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }
    
}
