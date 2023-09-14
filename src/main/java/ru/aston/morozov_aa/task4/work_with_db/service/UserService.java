package ru.aston.morozov_aa.task4.work_with_db.service;

import ru.aston.morozov_aa.task4.work_with_db.dto.UserJoinOrderDTO;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id) throws UserNotFoundException;
    boolean deleteUserById(String id) throws UserNotFoundException;
    boolean createUser(User user) throws UserAlreadyExistException;
    User updateUser(User user) throws UserNotFoundException;

    List<UserJoinOrderDTO> getInfoAboutUsersJoinOrders();
}
