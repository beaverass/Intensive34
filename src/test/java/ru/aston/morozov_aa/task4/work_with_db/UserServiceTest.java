package ru.aston.morozov_aa.task4.work_with_db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.aston.morozov_aa.task4.work_with_db.dao.UserDao;
import ru.aston.morozov_aa.task4.work_with_db.dao.UserDaoImpl;
import ru.aston.morozov_aa.task4.work_with_db.dto.UserJoinOrderDTO;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exception.UserNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.model.User;
import ru.aston.morozov_aa.task4.work_with_db.service.UserService;
import ru.aston.morozov_aa.task4.work_with_db.service.UserServiceImpl;

import java.sql.Date;
import java.util.List;


public class UserServiceTest {
    private final UserDao mock = Mockito.mock(UserDaoImpl.class);
    private final UserService userService = new UserServiceImpl(mock);

    @Test
    public void getAllUsersTest(){

        Mockito.when(mock.findAll()).thenReturn(List.of(
                new User(), new User(), new User(), new User("1", "Alex", "89203334444", "alex@mail.ru", new Date(19990808), "8c095f68-324f-43d2-a228-e6bf60be933b")
        ));

        List<User> users = userService.getAllUsers();

        Mockito.verify(mock).findAll();

        Assertions.assertTrue(!users.isEmpty() && users.size() == 4);
        Assertions.assertEquals(List.of(new User(), new User(), new User(), new User("1", "Alex", "89203334444", "alex@mail.ru", new Date(19990808), "8c095f68-324f-43d2-a228-e6bf60be933b")), users);
    }

    @Test
    public void getUserByIdTest() throws UserNotFoundException {


        Mockito.when(mock.findUserById("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b")).thenReturn(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"));

        User userById = userService.getUserById("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b");

        Mockito.verify(mock).findUserById("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b");

        Assertions.assertEquals(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"), userById);
    }

    @Test
    public void userNotFoundExceptionTest() throws UserNotFoundException {


        Mockito.when(mock.findUserById("1")).thenThrow(UserNotFoundException.class);

        Assertions.assertThrows(
                UserNotFoundException.class,
                () -> userService.getUserById("1"));

        Mockito.verify(mock).findUserById("1");
    }

    @Test
    public void userAlreadyExistExceptionTest() throws UserAlreadyExistException {

        Mockito.when(mock.create(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"))).thenThrow(UserAlreadyExistException.class);

        Assertions.assertThrows(UserAlreadyExistException.class, () -> userService.createUser(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89")));

        Mockito.verify(mock).create(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"));

    }


    @Test
    public void deleteUserTest() throws UserNotFoundException {

        Mockito.when(mock.delete("3554942f-29b2-4c88-a8a9-bbd498d9b589")).thenReturn(true);

        Assertions.assertTrue(userService.deleteUserById("3554942f-29b2-4c88-a8a9-bbd498d9b589"));

        Mockito.verify(mock).delete("3554942f-29b2-4c88-a8a9-bbd498d9b589");
    }



    @Test
    public void createUserTest() throws UserAlreadyExistException, UserNotFoundException {

        Mockito.when(mock.create(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"))).thenReturn(true);
        Mockito.when(mock.findUserById("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b")).thenReturn(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"));

        Assertions.assertTrue(userService.createUser(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89")));
        Assertions.assertEquals(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"), userService.getUserById("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b"));

        Mockito.verify(mock).create(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"));
    }


    @Test
    public void updateUserTest() throws UserNotFoundException {

        Mockito.when(mock.update(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"))).thenReturn(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"));

        Assertions.assertEquals(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89") , userService.updateUser(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89")));

        Mockito.verify(mock).update(new User("e1141446-e9b9-4ca5-89d3-4a3ac9dbc09b", "Пушкин Олег Юрьевич", "89000998881", "pushkin@mail.ru", new Date(102, 9, 12) ,"55fc1777-107d-4a96-a093-0cf644082d89"));
    }


    @Test
    public void getInfoAboutUsersJoinOrdersTest(){

        Mockito.when(mock.findInfoAboutUsersJoinOrders()).thenReturn(
                List.of(
                        new UserJoinOrderDTO("9784e539-0c1c-4953-89fb-d4866ee88c50", "Georg", "georg@mail.ru", "book", "СДЭК"),
                        new UserJoinOrderDTO("45672732-0c1c-4953-89fb-d4866ee88c50", "Pop", "pop@mail.ru", "phone", "СДЭК")
                ));


        Assertions.assertEquals(List.of(
                new UserJoinOrderDTO("9784e539-0c1c-4953-89fb-d4866ee88c50", "Georg", "georg@mail.ru", "book", "СДЭК"),
                new UserJoinOrderDTO("45672732-0c1c-4953-89fb-d4866ee88c50", "Pop", "pop@mail.ru", "phone", "СДЭК")
        ), userService.getInfoAboutUsersJoinOrders());

        Mockito.verify(mock).findInfoAboutUsersJoinOrders();
    }

}
