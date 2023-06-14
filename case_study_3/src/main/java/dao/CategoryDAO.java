package dao;

import context.DBContext;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBContext {
    public static final String FIND_ALL_CATEGORY = "SELECT * FROM shop_case_study.category;";
    public static final String FIND_BY_ID_CATEGORY = "SELECT * FROM shop_case_study.category WHERE (`id`=?)";



    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public Category findById(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                return category;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
