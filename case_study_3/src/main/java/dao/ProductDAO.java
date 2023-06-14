package dao;

import context.DBContext;
import model.Category;
import model.Product;
import model.ProductSize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DBContext {
    Connection conn = null;
    PreparedStatement pre = null;
    private static final String SELECT_ALL = "select  p.id , p.name, p.price, p.describle, p.quantity,p.image,c.name as type from product p join category c on p.category_id = c.id;";
    private static final String INSERT_PRODUCT ="insert into product (category_id,name,price,descrilbe,quantity,image) values(?,?,?,?,?,?);";
    private static final String INSERT_PRODUCT_SIZE = "insert into product_size values(?,?);";
    private static final String DELETE_SIZE = "delete from product_size where id=?";

    private static final String DELETE_PRODUCT = "delete from product where id=?";

    private static final String UPDATE_PRODUCT = "update product set category_id=? ,name=? ,price=? ,describle=? ,quantity=? ,image=? where id=?;";
    private static final String SELECT_PRODUCT_SIZE = "select * from product_size";
    private static final String SELECT_CATEGORY = "select * from category";
    ResultSet rs = null;
    public List<Product> getProduct() throws Exception {
        List<Product> list =new ArrayList<>();
        conn = new DBContext().getConnection();
        pre =conn.prepareStatement(SELECT_ALL);
        rs = pre.executeQuery();
        while(rs.next()){
            Category category = new Category();
            category.setName(rs.getString(7));
            list.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(5),rs.getString(6),category));
        }
        return list;
    }
    public void insertProduct(Product product) throws Exception {
        conn = new DBContext().getConnection();
        pre=conn.prepareStatement(INSERT_PRODUCT);
        pre.setInt(1,product.getCategory().getId());
        pre.setString(2,product.getName());
        pre.setDouble(3,product.getPrice());
        pre.setString(4,product.getDescrible());
        pre.setFloat(5,product.getQuantity());
        pre.setString(6,product.getImage());

        //them size cho bang ProductSize
        conn=new DBContext().getConnection();
        for(ProductSize i : product.getProductSizes()){
            pre=conn.prepareStatement(INSERT_PRODUCT_SIZE);
            pre.setInt(1,i.getProduct_id());
            pre.setString(2,i.getSize());
            pre.executeUpdate();
        }
    }

    public void DeleteProduct(int id) throws Exception {
        // xoa trong bang product_size
        conn = new DBContext().getConnection();
        pre=conn.prepareStatement(DELETE_SIZE);
        pre.setInt(1,id);
        pre.executeUpdate();

        // xoa trong bang product
        conn = new DBContext().getConnection();
        pre=conn.prepareStatement(DELETE_PRODUCT);
        pre.setInt(1,id);
        pre.executeUpdate();
    }

    public void UpdateProduct(Product product) throws Exception {
        //xoa trong bang product_size truoc
        conn = new DBContext().getConnection();
        pre=conn.prepareStatement(DELETE_SIZE);
        pre.setInt(1,product.getId());
        pre.executeUpdate();

        //ghi lai size vao bang size
        conn=new DBContext().getConnection();
        for(ProductSize i : product.getProductSizes()) {
            pre = conn.prepareStatement(INSERT_PRODUCT_SIZE);
            pre.setInt(1, i.getProduct_id());
            pre.setString(2, i.getSize());
            pre.executeUpdate();
        }

        //update bang product
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(UPDATE_PRODUCT);
            pre.setInt(1, product.getCategory().getId());
            pre.setString(2, product.getName());
            pre.setDouble(3, product.getPrice());
            pre.setString(4, product.getDescrible());
            pre.setInt(5, product.getQuantity());
            pre.setString(6, product.getImage());
            pre.setInt(7, product.getId());
            pre.executeUpdate();


    }

        public List<ProductSize> getSize() throws Exception {
            List<ProductSize> list = new ArrayList<>();
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(SELECT_PRODUCT_SIZE);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new ProductSize(rs.getInt(1), rs.getString(2)));
            }
            return list;
        }

    public List<Category> getCategory() throws Exception {
        List<Category> list = new ArrayList<>();
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(SELECT_CATEGORY);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        return list;
    }

    public Category getCategoryByName(String name) {
        String sql = "select * from category where category_name = ?;";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertCategory(String name) {
        String sql = " insert into category (category_name) values(?);";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}