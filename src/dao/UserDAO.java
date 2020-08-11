package dao;

import model.Product;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

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
    public void insertUser(User user) throws SQLException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user (userName, email, password, phone) VALUES (?,?,?,?)");

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());

            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("userName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                user = new User(id, userName, email, password, phone);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User selectUserByName(String userName) {
        User user = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where userName= ?");

            preparedStatement.setString(1, userName);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
//                String userName = rs.getString("userName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                user = new User(userName, email, password, phone);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("userName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                User user = new User(id, userName, email, password, phone);
                userList.add(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return userList; }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update user set userName = ?, email = ?, password =?, phone = ? where id = ?;");

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setInt(5, user.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
