package test;

import dao.ProductDAO;

import java.sql.SQLException;

public class TestProductDAO {
    public static void main(String[] args) throws SQLException {
        ProductDAO productDAO = new ProductDAO();

        boolean testDelete = productDAO.deleteProduct(0);
        System.out.print(testDelete);
    }
}
