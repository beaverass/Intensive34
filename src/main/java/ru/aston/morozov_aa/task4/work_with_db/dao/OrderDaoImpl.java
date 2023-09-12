package ru.aston.morozov_aa.task4.work_with_db.dao;

import ru.aston.morozov_aa.task4.work_with_db.config.DataSource;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.models.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao{

    private final Connection connection = DataSource.getInstance().getConnection();

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                orders.add(getOrderFromResultSet(resultSet));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return orders;
    }

    @Override
    public Order findOrderById(int id) throws OrderNotFoundException {
        Order order;
        String query = "SELECT * FROM orders WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                throw new OrderNotFoundException("Order with id = " + id + " not found");
            }

            order = getOrderFromResultSet(resultSet);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public boolean delete(int id) throws OrderNotFoundException {

        String query = "DELETE FROM orders WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if(!isOrderExist(id)){
                throw new OrderNotFoundException("Order with id = " + id + " not found");
            }

            preparedStatement.setInt(1, id);

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected > 0) {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }



    @Override
    public boolean create(Order order) {
        String query = "INSERT INTO orders(name, order_date, shipper_id) VALUES (?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, order.getName());
            preparedStatement.setDate(2, order.getOrderDate());
            preparedStatement.setInt(3, order.getShipperId());

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected > 0) {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;

    }

    @Override
    public Order update(Order order) throws OrderNotFoundException {
        Order updatedOrder;
        String query = "UPDATE orders SET name = ?, order_date = ?, shipper_id = ? WHERE id = ?;";


        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if(!isOrderExist(order.getId())){
                throw new OrderNotFoundException("Order with id = " + order.getId() + " not found");
            }

            preparedStatement.setString(1, order.getName());
            preparedStatement.setDate(2, order.getOrderDate());
            preparedStatement.setInt(3, order.getShipperId());
            preparedStatement.setInt(4, order.getId());

            preparedStatement.executeUpdate();

            updatedOrder = findOrderById(order.getId());;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return updatedOrder;
    }

    private boolean isOrderExist(int id) {
        try {
            findOrderById(id);
            return true;
        } catch (OrderNotFoundException e) {
            return false;
        }
    }


    private static Order getOrderFromResultSet(ResultSet resultSet) throws SQLException {

        Integer orderId = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Date orderDate = resultSet.getDate("order_date");
        Integer shipperId = resultSet.getInt("shipper_id");

        Order order = new Order();

        order.setId(orderId);
        order.setName(name);
        order.setOrderDate(orderDate);
        order.setShipperId(shipperId);

        return order;
    }
}
