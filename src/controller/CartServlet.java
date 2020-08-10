package controller;

import dao.CartDAO;
import dao.ICartDAO;
import dao.ProductDAO;
import model.Cart;
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

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartDAO cartDAO;

    public void init() {
        cartDAO = new CartDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "cart":
                    Cart(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {

                case "delete":
                    deleteCart(request, response);
                    break;
                case "show":
                    listCart(request, response);
                    break;
                case "cart":
                    Cart(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        CartDAO cartDAO = new CartDAO();
        cartDAO.insertCart(id);
        ProductDAO productDAO = new ProductDAO();
        int Id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/showdetail.jsp");
        request.setAttribute("product", product);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        cartDAO.deleteCart(id);

        List<Cart> listCart = cartDAO.selectAllCart();
        request.setAttribute("listC", listCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listCart(HttpServletRequest request, HttpServletResponse response) {
        List<Cart> listCart = cartDAO.selectAllCart();
        request.setAttribute("listCart", listCart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/cart.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
