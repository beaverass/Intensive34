package ru.aston.morozov_aa.task4.work_with_db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.aston.morozov_aa.task4.work_with_db.dao.OrderDao;
import ru.aston.morozov_aa.task4.work_with_db.dao.OrderDaoImpl;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.Order;
import ru.aston.morozov_aa.task4.work_with_db.service.OrderService;
import ru.aston.morozov_aa.task4.work_with_db.service.OrderServiceImpl;

import java.sql.Date;
import java.util.List;

public class OrderServiceTest {
    private final OrderDao mock = Mockito.mock(OrderDaoImpl.class);
    private final OrderService orderService = new OrderServiceImpl(mock);


    @Test
    public void getAllOrdersTest(){

        Mockito.when(mock.findAll()).thenReturn(List.of(
                new Order(), new Order(), new Order(), new Order("book", new Date(123, 8, 8), "1c4d8ee5-f861-458c-981b-5f12b08a9e04")
        ));


        List<Order> orders = orderService.getAllOrders();

        Mockito.verify(mock).findAll();

        Assertions.assertTrue(!orders.isEmpty() && orders.size() == 4);
        Assertions.assertEquals(new Order("book", new Date(123, 8, 8), "1c4d8ee5-f861-458c-981b-5f12b08a9e04"), orders.get(3));
    }


    @Test
    public void getOrderByIdTest() throws OrderNotFoundException {

        Mockito.when(mock.findOrderById("d87c7050-d596-4a07-a3d3-99b9ae613722"))
                .thenReturn(new Order("d87c7050-d596-4a07-a3d3-99b9ae613722", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04"));

        Order orderById = orderService.getOrderById("d87c7050-d596-4a07-a3d3-99b9ae613722");

        Mockito.verify(mock).findOrderById("d87c7050-d596-4a07-a3d3-99b9ae613722");
        Assertions.assertEquals(new Order("d87c7050-d596-4a07-a3d3-99b9ae613722", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04"), orderById);
    }


    @Test
    public void orderNotFoundExceptionTest() throws OrderNotFoundException {

        Mockito.when(mock.findOrderById("1")).thenThrow(OrderNotFoundException.class);


        Assertions.assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById("1"));

        Mockito.verify(mock).findOrderById("1");
    }

    @Test
    public void orderAlreadyExistExceptionTest() throws OrderAlreadyExistException {

        Mockito.when(mock.create(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ))).thenThrow(OrderAlreadyExistException.class);


        Assertions.assertThrows(OrderAlreadyExistException.class, () -> orderService.createOrder(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" )));

        Mockito.verify(mock).create(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ));
    }

    @Test
    public void deleteOrderTest() throws OrderNotFoundException {

        Mockito.when(mock.delete("8c095f68-324f-43d2-a228-e6bf60be933b")).thenReturn(true);

        Assertions.assertTrue(orderService.deleteOrderById("8c095f68-324f-43d2-a228-e6bf60be933b"));

        Mockito.verify(mock).delete("8c095f68-324f-43d2-a228-e6bf60be933b");
    }



    @Test
    public void createOrderTest() throws OrderAlreadyExistException, OrderNotFoundException {


        Mockito.when(mock.create(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ))).thenReturn(true);
        Mockito.when(mock.findOrderById("1")).thenReturn(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04"));

        Assertions.assertTrue(orderService.createOrder(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" )));
        Assertions.assertEquals(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ), orderService.getOrderById("1"));

        Mockito.verify(mock).create(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ));
    }

    @Test
    public void updateOrderTest() throws OrderNotFoundException {

        Mockito.when(mock.update(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ))).thenReturn(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ));


        Assertions.assertEquals(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04"), orderService.updateOrder(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04")));

        Mockito.verify(mock).update(new Order("1", "LIPton", new Date(123, 6, 6), "1c4d8ee5-f861-458c-981b-5f12b08a9e04" ));
    }


}
