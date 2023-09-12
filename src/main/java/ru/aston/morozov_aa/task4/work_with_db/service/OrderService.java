package ru.aston.morozov_aa.task4.work_with_db.service;

import ru.aston.morozov_aa.task4.work_with_db.exception.OrderAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(String id) throws OrderNotFoundException;
    boolean deleteOrderById(String id) throws OrderNotFoundException;
    boolean createOrder(Order order) throws OrderAlreadyExistException;
    Order updateOrder(Order order) throws OrderNotFoundException;
}
