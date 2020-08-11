package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request,response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request,response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;
                case "show":
                    showProduct(request, response);
                    break;
                case "view":
                    showProductDetail(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }



    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> listProduct = productDAO.selectAllProduct();
        request.setAttribute("listProduct", listProduct );
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        int price = Integer.parseInt(request.getParameter("price"));
        String imgItem = request.getParameter("imgItem");

        Product newProduct = new Product(name, brand, price, imgItem);
        productDAO.insertProduct(newProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
//        response.sendRedirect("/product");

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        int price  = Integer.parseInt(request.getParameter("price"));
        String imgItem = request.getParameter("imgItem");

        Product book = new Product(id, name, brand, price, imgItem);
        productDAO.updateProduct(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/product");

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);

        List<Product> listProduct = productDAO.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/product");
//        dispatcher.forward(request, response);
response.sendRedirect("/product");
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/show.jsp");
        request.setAttribute("product", product);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/showdetail.jsp");
        request.setAttribute("product", product);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }



}
