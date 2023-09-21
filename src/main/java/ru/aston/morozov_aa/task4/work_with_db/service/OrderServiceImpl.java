package ru.aston.morozov_aa.task4.work_with_db.service;

import ru.aston.morozov_aa.task4.work_with_db.dao.OrderDao;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.Order;
import ru.aston.morozov_aa.task4.work_with_db.util.GeneratorId;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private final OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        return orderDao.findOrderById(id);
    }

    @Override
    public boolean deleteOrderById(String id) throws OrderNotFoundException {
        return orderDao.delete(id);
    }

    @Override
    public boolean createOrder(Order order) throws OrderAlreadyExistException {
        boolean hasId = !order.getId().equals(null) && !order.getId().isEmpty() && !order.getId().isBlank();

        if(hasId){
            return orderDao.create(order);
        }

        order.setId(GeneratorId.generateId());

        return orderDao.create(order);
    }

    @Override
    public Order updateOrder(Order order) throws OrderNotFoundException {
        return orderDao.update(order);
    }
}
