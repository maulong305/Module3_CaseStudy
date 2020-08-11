package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/module3_casestudy?useSSL=false&characterEncoding=UTF-8";
    private String jdbcUserName = "root";
    private String jdbcPassword = "280891";

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
    public void insertProduct(Product product) throws SQLException {

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product (name, brand, price, imgItem) VALUES (?,?,?,?)");

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setString(4, product.getImgItem());

            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from product where id = ?");

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String imgItem = rs.getString("imgItem");
                product = new Product(id, name, brand, price, imgItem);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from product");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String imgItem = rs.getString("imgItem");
                Product product = new Product(id, name, brand, price, imgItem);
                productList.add(product);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update product set name = ?, brand= ?, price =?, imgItem = ? where id = ?;");

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setString(4, product.getImgItem());
            preparedStatement.setInt(5, product.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
