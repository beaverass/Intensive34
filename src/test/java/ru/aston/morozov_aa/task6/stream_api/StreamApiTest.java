package ru.aston.morozov_aa.task6.stream_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {

    //Вывести все четные числа в диапазоне от 1 до 100,
    @Test
    public void printEvenNumsFromOneToHundredTest(){
        Stream<Integer> stream = Stream.iterate(1, n -> n + 1).limit(100);

        stream.filter(n -> n % 2 == 0).forEach(System.out::println);
    }


    //Умножить каждое число в массиве [1, 2, 3, 4, 5] на 2,
    @Test
    public void multiplyEachNumByTwoInArray(){
        Integer[] arr = {1, 2, 3, 4, 5};

        Integer[] nums = Arrays.stream(arr).map(n -> n * 2).toArray(Integer[]::new);

        Assertions.assertArrayEquals(new Integer[]{2, 4, 6, 8, 10}, nums);

    }

    //Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()
    @Test
    public void allNumsSumTest(){
        Integer[] arr = {1, 2, 3, 4, 5};

        Integer arrSum = Arrays.stream(arr).reduce(0, (a, e) -> a + e);

        System.out.println(arrSum);

        Assertions.assertEquals(15, arrSum);

    }

    //Вывести числа в диапазоне от 1 до 50 с шагом 2,
    @Test
    public void numsFromOneToFiftyByStepTwoTest(){
        Stream<Integer> stream = Stream.iterate(1, n -> n + 1).limit(50);//IntStream numbers = IntStream.rangeClosed(1, 50);

        Integer[] nums = stream.filter(n -> n % 2 != 0).toArray(Integer[]::new);

        Arrays.stream(nums).forEach(System.out::println);

        Assertions.assertArrayEquals(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49} , nums);

    }

    //Найти первый четный элемент в списке [1, 2, 3, 4, 5],
    @Test
    public void firstEvenElemInListTest(){
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        Integer num = nums.stream().filter(n -> n % 2 == 0).findFirst().get();

        System.out.println(num);

        Assertions.assertEquals(2, num);
    }

    //Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию,
    @Test
    public void sortArrTest(){
        Integer[] arr = {7, 1, 9, 3, 5};

        Integer[] sortedNums = Arrays.stream(arr).sorted((n1, n2) -> n1 - n2).toArray(Integer[]::new);

        Arrays.stream(sortedNums).forEach(System.out::println);

        Assertions.assertArrayEquals(new Integer[]{1, 3, 5, 7, 9}, sortedNums);
    }


    //Вывести первые 10 чисел в списке [0, 1, 2, … 99]
    @Test
    public void printFirstTenNumsInListTest(){
        List<Integer> nums = Stream.iterate(0, n -> n + 1).limit(99).collect(Collectors.toList());
        nums.stream().limit(10).forEach(System.out::println);
    }

    //Пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го элемента, выводя каждый 10-й элемент
    @Test
    public void skipTenElemAndPrintEachTenth(){
        List<Integer> nums = Stream.iterate(0, n -> n + 1).limit(99).collect(Collectors.toList());

        Integer[] elems =
                nums.stream().skip(10).filter(n -> n % 10 == 0).toArray(Integer[]::new);


        Assertions.assertArrayEquals(new Integer[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, elems);
    }

    //Выведите на экран все числа в диапазоне от 1 до 100, которые делятся на 3.
    @Test
    public void printNumsFromOneToHundredWhichDivideOnThree(){
        Stream<Integer> nums = Stream.iterate(1, n -> n + 1).limit(100);

        nums.filter(n -> n % 3 == 0).forEach(System.out::println);
    }

    //Выведите на экран только те элементы списка, которые больше заданного числа.
    @Test
    public void printNumsMoreThanInputNum(){
        Stream<Integer> nums = Stream.iterate(1, n -> n + 1).limit(100);

        final Integer inputNum = 15;

        nums.filter(n -> n > inputNum).forEach(System.out::println);

    }


    //Выведите на экран строки, которые начинаются с заданной подстроки.
    @Test
    public void printStringsWhichStartsWithTest(){

        final String inputSubstr = "dep";

        List<String> strings = List.of("depRandomString1", "popRandomString2", "nopRandomString3", "depRandomString4", "popRandomString5", "nopRandomString6", "depRandomString7", "popRandomString8", "nopRandomString9", "depRandomString10", "popRandomString11", "nopRandomString12", "depRandomString13", "popRandomString14", "nopRandomString15", "depRandomString16", "popRandomString17", "nopRandomString18", "depRandomString19", "popRandomString20", "nopRandomString21", "depRandomString22", "popRandomString23", "nopRandomString24", "depRandomString25", "popRandomString26", "nopRandomString27", "depRandomString28", "popRandomString29", "nopRandomString30", "depRandomString31", "popRandomString32", "nopRandomString33", "depRandomString34", "popRandomString35", "nopRandomString36", "depRandomString37", "popRandomString38", "nopRandomString39", "depRandomString40", "popRandomString41", "nopRandomString42", "depRandomString43", "popRandomString44", "nopRandomString45", "depRandomString46", "popRandomString47", "nopRandomString48", "depRandomString49", "popRandomString50");

        strings.stream().filter(s -> s.startsWith(inputSubstr)).forEach(System.out::println);

    }

    //Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля равно 1.
    @Test
    public void filterObjectsByField(){


    }







}
