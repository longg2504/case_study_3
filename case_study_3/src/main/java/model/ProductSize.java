package model;

public class ProductSize {
    private int product_id;
    private String size;

    public ProductSize() {

    }

    public ProductSize(int product_id, String size) {
        this.product_id = product_id;
        this.size = size;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
