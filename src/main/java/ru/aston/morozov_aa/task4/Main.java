package ru.aston.morozov_aa.task4;

import ru.aston.morozov_aa.task4.work_with_db.dao.OrderDao;
import ru.aston.morozov_aa.task4.work_with_db.dao.OrderDaoImpl;
import ru.aston.morozov_aa.task4.work_with_db.dao.UserDao;
import ru.aston.morozov_aa.task4.work_with_db.dao.UserDaoImpl;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.Order;
import ru.aston.morozov_aa.task4.work_with_db.model.User;

import java.sql.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws OrderNotFoundException, UserNotFoundException, UserAlreadyExistException, OrderAlreadyExistException {
//        UserDao userDao = new UserDaoImpl();
//        System.out.println(userDao.findInfoAboutUsersJoinOrders());
//
//        System.out.println(userDao.findAll());
//        System.out.println(userDao.findUserById("3232dd53-45ea-41f6-aa92-5d5b5a0f7319"));
//        System.out.println(userDao.update(new User("3232dd53-45ea-41f6-aa92-5d5b5a0f7319", "Ken", "89009998881", "invanov@mail.ru", new Date(123, 5, 5), "d87c7050-d596-4a07-a3d3-99b9ae613722")));
//        System.out.println(userDao.findUserById("3232dd53-45ea-41f6-aa92-5d5b5a0f7319"));
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        System.out.println(id);
//        OrderDao orderDao = new OrderDaoImpl();
//        System.out.println(orderDao.findOrderById("d87c7050-d596-4a07-a3d3-99b9ae613722"));

//        System.out.println(userDao.create(new User(id, "ibrahim", "89999999999", "ibrahim@mail.ru", new Date(100, 7, 7), "01f7bee8-13f0-40e5-9a7b-53c1d59d9500")));
//        System.out.println(userDao.findUserById("5e66e762-29a7-4da8-b5f2-ce4939aca68e"));
//        System.out.println(userDao.delete("5e66e762-29a7-4da8-b5f2-ce4939aca68e"));
//        System.out.println(userDao.findUserById("5e66e762-29a7-4da8-b5f2-ce4939aca68e"));

//
//
//        System.out.println(orderDao.create(new Order(29, "YUYU", new Date(123, 8,8), 3)));
//        System.out.println(orderDao.findAll());

//        System.out.println(orderDao.findAll());
//        System.out.println(orderDao.findOrderById("d87c7050-d596-4a07-a3d3-99b9ae613722"));
//        System.out.println(orderDao.update(new Order("d87c7050-d596-4a07-a3d3-99b9ae613722", "LIPton", new Date(123, 7, 7), "1c4d8ee5-f861-458c-981b-5f12b08a9e04")));
//
//        System.out.println(orderDao.create(new Order("d87c7050-d596-4a07-a3d3-99b9ae613722", "Popa", new Date(123, 7, 7), "1c4d8ee5-f861-458c-981b-5f12b08a9e04")));
//        System.out.println(orderDao.findOrderById(id));
//        System.out.println(orderDao.delete(id));
//        System.out.println(orderDao.findOrderById(id));
//
//        System.out.println(id);

//        System.out.println(orderDao.findOrderById(29));
//        System.out.println(orderDao.update(new Order(29, "YUYU", new Date(123, 8,8), 3)));
//        System.out.println(orderDao.delete(29));
//        System.out.println(orderDao.findAll());





    }
}
