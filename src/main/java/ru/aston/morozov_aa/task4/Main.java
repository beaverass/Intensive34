package ru.aston.morozov_aa.task4;

import ru.aston.morozov_aa.task4.work_with_db.dao.UserDaoImpl;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.OrderNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.UserNotFoundException;

public class Main {

    public static void main(String[] args) throws OrderNotFoundException, UserNotFoundException, UserAlreadyExistException {
        System.out.println(new UserDaoImpl().findUserById(5));



    }
}
