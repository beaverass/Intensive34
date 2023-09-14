package ru.aston.morozov_aa.task4.work_with_db.dao;

import ru.aston.morozov_aa.task4.work_with_db.exception.OrderAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();
    Order findOrderById(String id) throws OrderNotFoundException;
    boolean delete(String id) throws OrderNotFoundException;
    boolean create(Order order) throws OrderAlreadyExistException;
    Order update(Order order) throws OrderNotFoundException;


}
