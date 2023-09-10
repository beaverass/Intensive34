package ru.aston.morozov_aa.task2.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task1.scooter_rental.models.User;

import java.util.*;

public class ListMethodsTest {
    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(20);
    }

    @Test
    public void arrayListGetMethodTest(){
        list.add("Some");
        list.add("Yo");
        list.add("pop");

        Assertions.assertTrue(list.get(1).equals("Yo"));
    }

    @Test
    public void arrayListAddMethodTest(){
        list.add("Hello");
        Assertions.assertTrue(list.contains("Hello"));
    }

    @Test
    public void arrayListDeleteMethodTest(){
        list.add("Some");
        list.add("Yo");
        list.remove("Some");

        Assertions.assertTrue(!list.contains("Some"));
    }

    @Test
    public void arrayListSizeMethodTest(){
        list.add("Some");
        list.add("Yo");
        list.add("pop");

        Assertions.assertTrue(list.size() == 3);
    }

    @Test
    public void arrayListContainsMethodTest(){
        list.add("Some");
        list.add("Yo");
        list.add("pop");
        Assertions.assertTrue(list.contains("pop"));
    }

    @Test
    public void arrayListIsEmptyMethodTest(){
        list.add("Some");
        list.add("Yo");
        list.add("pop");

        list.removeAll(List.of("Some", "Yo", "pop"));


        Assertions.assertEquals(true, list.isEmpty());
    }

    @Test
    public void arrayListClearMethodTest(){
        list.add("Some");
        list.add("Yo");
        list.add("pop");
        list.clear();

        Assertions.assertEquals(true, list.isEmpty());
    }

    @Test
    public void collectionsSortMethodTest(){
        list.add("b");
        list.add("a");
        list.add("c");
        list.add("f");
        list.add("p");
        Collections.sort(list);

        Assertions.assertEquals(List.of("a", "b", "c", "f", "p"), list);
    }

}
