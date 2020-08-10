package dao;

import model.Cart;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICartDAO {
    public void insertCart(int id) throws SQLException;

    public Cart selectCart(int id);

    public List<Cart> selectAllCart();

    public boolean deleteCart(int id) throws SQLException;

}
