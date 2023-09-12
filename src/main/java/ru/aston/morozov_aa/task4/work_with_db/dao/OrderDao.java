package ru.aston.morozov_aa.task4.work_with_db.dao;

import ru.aston.morozov_aa.task4.work_with_db.exceptions.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.models.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();
    Order findOrderById(int id) throws OrderNotFoundException;
    boolean delete(int id) throws OrderNotFoundException;
    boolean create(Order order);
    Order update(Order order) throws OrderNotFoundException;


}
