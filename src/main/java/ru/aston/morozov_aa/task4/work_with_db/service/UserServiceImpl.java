package ru.aston.morozov_aa.task4.work_with_db.service;

import ru.aston.morozov_aa.task4.work_with_db.dao.UserDao;
import ru.aston.morozov_aa.task4.work_with_db.dto.UserJoinOrderDTO;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.User;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(String id) throws UserNotFoundException {
        return userDao.findUserById(id);
    }

    @Override
    public boolean deleteUserById(String id) throws UserNotFoundException {
        return userDao.delete(id);
    }

    @Override
    public boolean createUser(User user) throws UserAlreadyExistException {
        boolean hasId = !user.getId().equals(null) && !user.getId().isEmpty() && !user.getId().isBlank();

        if(hasId){
            return userDao.create(user);
        }

        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());

        return userDao.create(user);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        return userDao.update(user);
    }

    @Override
    public List<UserJoinOrderDTO> getInfoAboutUsersJoinOrders() {
        return userDao.findInfoAboutUsersJoinOrders();
    }
}
