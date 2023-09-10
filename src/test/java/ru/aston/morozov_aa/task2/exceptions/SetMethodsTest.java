package ru.aston.morozov_aa.task2.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task1.scooter_rental.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetMethodsTest {

    private Set<User> set;
    private Set<User> set2 = new TreeSet<>(User::compareTo);//для сортировки элементов внутри множества. User::compareTo означает использование метода compareTo класса User для сравнения элементов в множестве.

    @BeforeEach
    public void setUp(){
        set = new TreeSet<>();
    }

    @Test
    public void setAddMethodTest(){
        User user = new User(20, "Petrov", "Petr");
        set.add(user);

        Assertions.assertTrue(set.contains(user));
    }

    @Test
    public void setSizeMethodTest(){
        User user = new User(20, "Petrov", "Petr");
        User user2 = new User(21, "Petrov", "Petr");
        User user3 = new User(22, "Petrov", "Petr");
        set.add(user);
        set.add(user2);
        set.add(user3);

        Assertions.assertTrue(set.size() == 3);
    }

    @Test
    public void setCantContainsDuplicatesTest(){
        User user = new User(20, "Petrov", "Petr");
        User user1 = new User(21, "Petrov", "Petr");
        User user2 = new User(20, "Petrov", "Petr");
        User user3 = new User(20, "Petrov", "Petr");

        set.add(user);
        set.add(user1);
        set.add(user2);
        set.add(user3);

        Assertions.assertTrue(set.size() == 2);
    }

    @Test
    public void setContainsMethodTest(){
        User user = new User(20, "Petrov", "Petr");
        User user1 = new User(21, "Petrov", "Petr");

        set.add(user);
        set.add(user1);
        Assertions.assertTrue(set.contains(user) && set.contains(user1));
    }

    @Test
    public void setContainsAllMethodTest(){
        User user = new User(20, "Petrov", "Petr");
        User user1 = new User(21, "Petrov", "Petr");
        User user2 = new User(23, "Petrov", "Petr");
        User user3 = new User(24, "Petrov", "Petr");

        set.add(user);
        set.add(user1);
        set.add(user2);
        set.add(user3);

        List<User> users = new ArrayList<>();

        for (User u : set) {
            users.add(u);
        }

        Assertions.assertTrue(set.containsAll(users));

    }





}
