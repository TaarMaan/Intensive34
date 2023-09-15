package ru.aston.task1.task4.dao;

import ru.aston.task1.task4.connection.ConnectionConnector;
import ru.aston.task1.task4.domain.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements DaoDataEntityLayer<Order> {
    private static final String SQL_SELECT_ALL_ORDERS =
            "SELECT * FROM orders";
    private static final String SQL_SELECT_ORDER_ID =
            "SELECT * FROM orders WHERE id=?";
    private static final String SQL_DELETE_ORDER_ID =
            "DELETE FROM orders WHERE id=?";
    private static final String SQL_CREATE_ORDER =
            "INSERT INTO orders (name) VALUES (?)";
    private static final String SQL_UPDATE_ORDER =
            "UPDATE orders SET name = ? WHERE id = ?";

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ORDERS);
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    @Override
    public Order findEntityById(int id) {
        Order order = null;
        try (Connection connection = ConnectionConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ORDER_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = new Order(
                        resultSet.getInt(1),
                        resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        try (Connection connection = ConnectionConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ORDER_ID)) {
            statement.setLong(1, id);
            if (statement.executeUpdate() > 0) {
                isDelete = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    @Override
    public boolean create(Order order) {
        boolean isCreate = false;
        try (Connection connection = ConnectionConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_CREATE_ORDER)) {
            statement.setString(1, order.getName());
            if (statement.executeUpdate() > 0) {
                isCreate = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isCreate;
    }

    @Override
    public Order update(Order order) {
        Order resultOrder = null;
        try (Connection connection = ConnectionConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ORDER)) {
            statement.setString(1, order.getName());
            statement.setInt(2, order.getId());
            if (statement.executeUpdate() > 0) {
                resultOrder = findEntityById(order.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultOrder;
    }

}