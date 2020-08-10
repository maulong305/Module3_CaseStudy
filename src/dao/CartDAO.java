package dao;

import model.Cart;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/module3_casestudy?useSSL=false&characterEncoding=UTF-8";
    private String jdbcUserName = "root";
    private String jdbcPassword = "280891";

    private static final String INSERT_cart_SQL = "insert into cart select * from product where  id =?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertCart(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_cart_SQL)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            new SQLException(e);
        }
    }

    @Override
    public Cart selectCart(int id) {
        Cart cart = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from cart where id = ?");

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String imgItem = rs.getString("imgItem");
                cart = new Cart(id, name, brand, price, imgItem);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public List<Cart> selectAllCart() {
        List<Cart> cartsList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from cart");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String imgItem = rs.getString("imgItem");
                Cart cart = new Cart(id, name, brand, price, imgItem);
                cartsList.add(cart);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return cartsList;
    }

    @Override
    public boolean deleteCart(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from cart where id = ?");
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
