package ru.aston.morozov_aa.task2.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.morozov_aa.task1.scooter_rental.models.User;

import java.util.*;

public class MapMethodsTest {
    private Map<Integer,String> map;
    private Map<Integer,String> map2 = new HashMap(30, 0.5f);// определяет, когда карта должна быть изменена в размере, чтобы вместить больше элементов

    @BeforeEach
    public void setUp() {
        map = new HashMap(30);
    }

    @Test
    public void mapPutMethodTest(){
        map.put(1, "Hello");

        Assertions.assertTrue(map.containsKey(1) && map.get(1).equals("Hello"));
    }

    @Test
    public void mapGetMethodTest(){
        map.put(1, "Hello");

        Assertions.assertEquals("Hello", map.get(1));
    }

    @Test
    public void mapSizeMethodTest(){
        map.put(1, "Hello");
        map.put(2, "pop");
        map.put(3, "uiu");

        Assertions.assertTrue(map.size() == 3);
    }

    @Test
    public void mapContainsKeyMethodTest(){
        map.put(1, "Hello");
        map.put(2, "Hello");
        Assertions.assertTrue(map.containsKey(1) && map.containsKey(2));
    }

    @Test
    public void mapIsEmptyMethodTest(){
        map.put(1, "Hello");
        map.put(2, "Hel");

        map.remove(1);
        map.remove(2);

        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    public void mapClearMethodTest(){
        map.put(1, "Hello");
        map.put(2, "Hel");
        map.clear();

        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    public void mapRemoveMethodTest(){
        map.put(1, "Hello");

        map.remove(1);

        Assertions.assertTrue(map.isEmpty());
    }






}
