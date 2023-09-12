package ru.aston.morozov_aa.task4.work_with_db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task4.work_with_db.dao.OrderDao;
import ru.aston.morozov_aa.task4.work_with_db.dao.OrderDaoImpl;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.models.Order;

import java.sql.Date;
import java.util.List;

public class OrderDaoTest {
    private OrderDao orderDao = new OrderDaoImpl();
    //todo write mocks

    @Test
    public void findAllOrderTest(){
        //mock this
        List<Order> orders = orderDao.findAll();

        Assertions.assertTrue(!orders.isEmpty());
    }

    @Test
    public void findOrderByIdTest() throws OrderNotFoundException {
        Order orderById = orderDao.findOrderById(5);

        Assertions.assertEquals(new Order(5, "smartphone", new Date(123, 4, 10), 2), orderById);
    }

    @Test
    public void orderNotFoundExceptionTest(){
        Assertions.assertThrows(
                OrderNotFoundException.class,
                () -> orderDao.findOrderById(1));
    }

    @Test
    public void deleteOrderTest() throws OrderNotFoundException {
        orderDao.create(new Order("pop", new Date(19890808), 2));

        Integer id = orderDao.findAll().get(orderDao.findAll().size() - 1).getId();

        orderDao.delete(id);
        Assertions.assertThrows(OrderNotFoundException.class,
                () -> orderDao.findOrderById(id));
    }

    @Test
    public void createOrderTest(){
        int sizeBefore = orderDao.findAll().size();

        orderDao.create(new Order("pop", new Date(19890808), 2));

        int sizeAfter = orderDao.findAll().size();


        Assertions.assertTrue(sizeBefore + 1 == sizeAfter);
    }

    @Test
    public void updateOrderTest() throws OrderNotFoundException {

        Order orderById = orderDao.findOrderById(20);
        Order updatedOrder = orderDao.update(new Order(20, "IOPOP", new Date(19890808), 2));

        Assertions.assertEquals(orderDao.findOrderById(20), updatedOrder);
    }




}
