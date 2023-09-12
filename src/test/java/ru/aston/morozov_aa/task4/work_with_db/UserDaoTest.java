package ru.aston.morozov_aa.task4.work_with_db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task4.work_with_db.dao.UserDao;
import ru.aston.morozov_aa.task4.work_with_db.dao.UserDaoImpl;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.UserNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.models.Order;
import ru.aston.morozov_aa.task4.work_with_db.models.User;

import java.sql.Date;
import java.util.List;

public class UserDaoTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void findAllUsersTest(){
        List<User> users = userDao.findAll();

        Assertions.assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserByIdTest() throws UserNotFoundException {
        User userById = userDao.findUserById(5);

        Assertions.assertEquals(new User(5, "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,7), userById);
    }

    @Test
    public void userNotFoundExceptionTest(){
        Assertions.assertThrows(
                UserNotFoundException.class,
                () -> userDao.findUserById(1));
    }

    @Test
    public void deleteUserTest() throws UserNotFoundException, UserAlreadyExistException {
        userDao.create(new User(40, "Peeeo", "8989889899889", "peeo@mail.ru", new Date(123, 10, 2), 5 ));

        userDao.delete(40);

        Assertions.assertThrows(UserNotFoundException.class,
                () -> userDao.findUserById(40));
    }

    @Test
    public void userAlreadyExistExceptionTest(){
        Assertions.assertThrows(UserAlreadyExistException.class,
                () -> userDao.create(new User(40, "Peeeo", "8989889899889", "peeo@mail.ru", new Date(123, 10, 2), 5 )));
    }

    @Test
    public void createUserTest() throws UserAlreadyExistException {
        int sizeBefore = userDao.findAll().size();

        userDao.create(new User(30, "Peeeo", "8989889899889", "peo@mail.ru", new Date(123, 10, 2), 5));

        int sizeAfter = userDao.findAll().size();


        Assertions.assertTrue(sizeBefore + 1 == sizeAfter);
    }

    @Test
    public void updateUserTest() throws UserNotFoundException {

        User userById = userDao.findUserById(30);
        User updatedUser = userDao.update(new User(30, "Niiii", "8989889899889", "peo@mail.ru", new Date(123, 10, 2), 5));

        Assertions.assertEquals(userDao.findUserById(30), updatedUser);
    }

}
