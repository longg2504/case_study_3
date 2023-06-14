package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/productServlet")

public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                showCreateProduct(request, response);
                break;
            case "editProduct":
                showEditProduct(request, response);
                break;
            case "deleteProduct":
                showDeleteProduct(request, response);
                break;
            default:
                try {
                    showProduct(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(idProduct);
        request.setAttribute("product", product);
        List<Category> categories = categoryDAO.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/deleteProduct.jsp").forward(request, response);
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.findById(idProduct);
        request.setAttribute("product", product);
        List<Category> categories = categoryDAO.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/editProduct.jsp").forward(request, response);
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDAO.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/createProduct.jsp").forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Product> products = productDAO.getProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/listProduct.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                CreateProduct(request, response);
                break;
            case "editProduct":
                showEditProduct(request, response);
                break;
            case "deleteProduct":
                showDeleteProduct(request, response);
                break;
            default:
                try {
                    showProduct(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void CreateProduct(HttpServletRequest request, HttpServletResponse response) {

    }
}
