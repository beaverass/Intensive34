package ru.aston.morozov_aa.task6.stream_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.*;
import java.util.stream.Collector;
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

    @DisplayName("числа в диапазоне от 1 до 50 с шагом 2")
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
    public void skipTenElemAndPrintEachTenthTest(){
        List<Integer> nums = Stream.iterate(0, n -> n + 1).limit(99).collect(Collectors.toList());

        Integer[] elems =
                nums.stream().skip(10).filter(n -> n % 10 == 0).toArray(Integer[]::new);


        Assertions.assertArrayEquals(new Integer[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, elems);
    }

    //Выведите на экран все числа в диапазоне от 1 до 100, которые делятся на 3.
    @Test
    public void printNumsFromOneToHundredWhichDivideOnThreeTest(){
        Stream<Integer> nums = Stream.iterate(1, n -> n + 1).limit(100);

        nums.filter(n -> n % 3 == 0).forEach(System.out::println);
    }

    //Выведите на экран только те элементы списка, которые больше заданного числа.
    @Test
    public void printNumsMoreThanInputNumTest(){
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

    //Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля age больше или равны 20.
    @Test
    public void filterObjectsByFieldTest(){
        Stream<Person> personStream = Stream.of(
                new Person("Petr", "Petrov", 20),
                new Person("Ivan", "Petrov", 10),
                new Person("Alex", "Petrov", 15),
                new Person("Rita", "Petrova", 25),
                new Person("Oleg", "Petrov", 30)
        );

        personStream.filter(p -> p.getAge() >= 20).forEach(System.out::println);

    }

    //Отфильтруйте элементы массива, которые не являются числами.
    @Test
    public void filterNotNumberTest(){

        Stream someStream = Stream.of(
                Double.valueOf(4.9),
                Integer.valueOf(9),
                "Pop",
                "UUUUUU",
                "Wow",
                Long.valueOf(88888888889l),
                Boolean.valueOf(false)
        );

        someStream.filter(p -> !(p instanceof Number)).forEach(System.out::println);
    }


    //Выведите на экран элементы списка, которые не входят в другой список.
    @Test
    public void printListElemWhichNotContainsInAntherListTest(){
        final List<Integer> list1 = List.of(1, 3, 5, 7, 9);
        List<Integer> list2 = List.of(1, 2, 4, 5, 6, 10);

        list2.stream().filter(e -> !list1.contains(e)).forEach(System.out::println);

    }


    //Собрать элементы Stream в карту, где ключом будет первая буква каждого слова, а значением — само слово. Отсортировать ключи в алфавитном порядке.
    @Test
    public void collectElemsToMapTest(){
        Stream<String> strs = Stream.of("drink", "eat", "fish", "meet", "apple", "banana", "coke");

        TreeMap<String, String> map = strs.collect(
                Collectors.toMap(
                        k -> k.substring(0, 1),
                        v -> v,
                        (e, r) -> e,
                        TreeMap::new));

        map.forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
    }

    //Собрать файлы в Stream в список, где каждый элемент — количество файлов с определенным расширением.
    @Test
    public void collectFilesToMapWithConditionTest(){
        List<File> files =
                List.of(new File("test.txt"),
                        new File("dog.png"),
                        new File("index.html"),
                        new File("two.txt"),
                        new File("config.xml"),
                        new File("conf.xml"));

        Map<String, Long> map = files.stream()
                .collect(Collectors.groupingBy(
                        f -> getFileExtension(f.getName()),
                        Collectors.counting()
                ));

        map.forEach((k, v) -> System.out.println("extension = " + k + " count = " + v));


//        Map<String, List<File>> map = new HashMap<>();
//
//        for(int i = 0; i < files.size(); i++){
//
//            String fileExtension = getFileExtension(files.get(i).getName());
//
//            if(map.containsKey(fileExtension)){
//                map.get(fileExtension).add(files.get(i));
//            }
//
//            if(!map.containsKey(fileExtension)) {
//                map.put(fileExtension, new ArrayList<>());
//                map.get(fileExtension).add(files.get(i));
//            }
//
//        }
//
//        map.forEach((e, v) -> System.out.println("extension = " + e + " count = " + v.size()));

    }

    private static String getFileExtension(String fileName) {
        int i = fileName.lastIndexOf(".") + 1;
        return fileName.substring(i);
    }

    //Собрать пользователей в Stream в список объектов, где каждый объект содержит информацию о городе проживания пользователя и количестве пользователей из этого города.
    @Test
    public void collectUsersToMapWithConditionTest(){
        Stream<User> personStream = Stream.of(
            new User("Anton", 20, City.BREST),
            new User("Tolik", 21, City.BREST),
            new User("Kirill", 22, City.BREST),
                new User("Oleg", 28, City.MINSK),
                new User("Nastya", 35, City.MINSK),
                new User("Egor", 27, City.MINSK),
                new User("Ira", 15, City.MINSK),
                new User("Veronika", 18, City.MOGILEV),
                new User("Dasha", 19, City.MOGILEV),
                new User("Danill", 19, City.GOMEL)
        );


        Map<String, Long> map = personStream.collect(Collectors.groupingBy(
                u -> u.getCity().getCityName(),
                Collectors.counting()
        ));

        map.forEach((k, v) -> System.out.println("city = " + k + " ---> count of users = " + v));


    }











}
