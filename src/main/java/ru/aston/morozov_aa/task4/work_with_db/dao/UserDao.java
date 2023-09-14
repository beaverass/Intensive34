package ru.aston.morozov_aa.task4.work_with_db.dao;

import ru.aston.morozov_aa.task4.work_with_db.dto.UserJoinOrderDTO;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findUserById(String id) throws UserNotFoundException;
    boolean delete(String id) throws UserNotFoundException;
    boolean create(User user) throws UserAlreadyExistException;
    User update(User user) throws UserNotFoundException;

    List<UserJoinOrderDTO> findInfoAboutUsersJoinOrders();
}
