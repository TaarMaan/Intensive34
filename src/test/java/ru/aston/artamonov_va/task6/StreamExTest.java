package ru.aston.artamonov_va.task6;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ru.aston.artamonov_va.task6.SupportFuncClassForStreamTests.*;

class StreamExTest {

    @Test
    void Ex1() {
        //Вывести все четные числа в диапазоне от 1 до 100
        System.out.println("---Ex1---");
        IntStream.rangeClosed(1, 100)
                .filter(x -> x % 2 == 0).
                forEach(System.out::println);
    }

    @Test
    void Ex2() {
        //Умножить каждое число в массиве [1, 2, 3, 4, 5] на 2
        System.out.println("---Ex2---");
        int[] ex2 = {1, 2, 3, 4, 5};
        int[] result = Arrays.stream(ex2)
                .map(x -> x * 2)
                .toArray();
        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    void Ex3() {
        //Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()
        System.out.println("---Ex3---");
        int[] ex3 = {1, 2, 3, 4, 5};
        int result = Arrays.stream(ex3)
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + result);
    }

    @Test
    void Ex4() {
        //Вывести числа в диапазоне от 1 до 50 с шагом 2
        System.out.println("---Ex4---");
        int start = 1;
        int end = 50;
        int step = 2;
        IntStream.iterate(start, a -> a + step)
                .limit((end - start) / step + 1)
                .forEach(System.out::println);
    }

    @Test
    void Ex5() {
        //Найти первый четный элемент в списке [1, 2, 3, 4, 5]
        System.out.println("---Ex5---");
        Integer[] ex5 = {1, 2, 3, 4, 5};
        Optional<Integer> first = Arrays.stream(ex5)
                .filter(a -> a % 2 == 0)
                .findFirst();
        if (first.isPresent()) {
            System.out.println("First even elem: " + first);
        } else {
            System.out.println("Even elem doesn't exist");
        }
    }

    @Test
    void Ex6() {
        //Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию
        System.out.println("---Ex6---");
        int[] ex6 = {1, 3, 5, 7, 9};
        int[] sorted = Arrays.stream(ex6)
                .sorted()
                .toArray();
        for (int num : sorted) {
            System.out.println(num + " ");
        }
    }

    @Test
    void Ex7() {
        //Вывести первые 10 чисел в списке [0, 1, 2, … 99]
        System.out.println("---Ex7---");
        List<Integer> ex7 = IntStream.rangeClosed(1, 99)
                .boxed()
                .limit(10)
                .toList();
        ex7.forEach(System.out::println);
    }

    @Test
    void Ex8() {
        //Пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го элемента, выводя каждый 10-й элемент
        System.out.println("---Ex8---");
        List<Integer> ex8 = IntStream.rangeClosed(1, 99)
                .boxed()
                .skip(10)
                .toList();
        ex8.forEach(System.out::println);
    }

    @Test
    void Ex9() {
        //Выведите на экран все числа в диапазоне от 1 до 100, которые делятся на 3
        System.out.println("---Ex9---");
        IntStream.rangeClosed(1, 100)
                .filter(x -> x % 3 == 0).
                forEach(System.out::println);
    }

    @Test
    void Ex10() {
        //Выведите все нечетные числа в заданном массиве
        System.out.println("---Ex10---");
        int[] ex10 = {1, 2, 3, 4, 5};

        Arrays.stream(ex10)
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }

    @Test
    void Ex11() {
        //Выведите на экран только те элементы списка, которые больше заданного числа
        System.out.println("---Ex11---");
        List<Integer> ex11 = new ArrayList<>();
        ex11.add(1);
        ex11.add(2);
        ex11.add(3);
        ex11.add(4);
        ex11.add(5);
        int border = 2;

        ex11.stream()
                .filter(a -> a > border)
                .forEach(System.out::println);
    }

    @Test
    void Ex12() {
        //Отфильтруйте все элементы списка, которые меньше 0
        System.out.println("---Ex12---");
        List<Integer> ex12 = new ArrayList<>();
        ex12.add(-1);
        ex12.add(-2);
        ex12.add(3);
        ex12.add(4);
        ex12.add(5);

        ex12.stream()
                .filter(a -> a < 0)
                .forEach(System.out::println);
    }

    @Test
    void Ex13() {
        //Выведите на экран строки, которые начинаются с заданной подстроки
        System.out.println("---Ex13---");
        List<String> ex13 = new ArrayList<>();
        ex13.add("apple");
        ex13.add("banana");
        ex13.add("cherry");
        ex13.add("date");
        ex13.add("grape");

        String prefix = "c";

        List<String> result = ex13.stream()
                .filter(a -> a.startsWith(prefix))
                .toList();

        result.forEach(System.out::println);
    }

    @Test
    void Ex14() {
        //Выведите все числа в списке, которые не кратны 2
        System.out.println("---Ex14---");
        List<Integer> ex14 = new ArrayList<>();
        ex14.add(1);
        ex14.add(2);
        ex14.add(3);
        ex14.add(4);
        ex14.add(5);

        List<Integer> result = ex14.stream()
                .filter(a -> a % 2 != 0)
                .toList();
        result.forEach(System.out::println);
    }

    @Test
    void Ex15() {
        //Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля равно 1
        System.out.println("---Ex15---");
        List<TestDBForStreamTests> ex15 = List.of(
                new TestDBForStreamTests(1, 1),
                new TestDBForStreamTests(2, 2),
                new TestDBForStreamTests(3, 1),
                new TestDBForStreamTests(4, 3)
        );

        int targetValue = 1;

        List<TestDBForStreamTests> filteredRecords = ex15.stream()
                .filter(record -> record.getValue() == targetValue)
                .toList();

        filteredRecords.forEach(record -> System.out.println("ID: " + record.getId() + ", Value: " + record.getValue()));
    }

    @Test
    void Ex16() {
        //Выведите только те элементы коллекции, которые удовлетворяют
        //определенному условию, например, являются уникальными или имеют определенный формат
        System.out.println("---Ex16---");
        List<String> ex16 = new ArrayList<>();
        ex16.add("apple");
        ex16.add("banana");
        ex16.add("cherry");
        ex16.add("date");
        ex16.add("grape");

        String condition = "apple";

        List<String> filtered = ex16.stream()
                .filter(a -> a.equals(condition))
                .toList();
        filtered.forEach(System.out::println);
    }

    @Test
    void Ex17() {
        //Отфильтруйте элементы массива, которые не являются числами
        System.out.println("---Ex17---");
        Object[] ex17 = {1, "apple", 2, "banana", 3, "cherry"};

        List<Integer> numbers = Arrays.stream(ex17)
                .filter(element -> element instanceof Integer)
                .map(element -> (Integer) element)
                .toList();

        numbers.forEach(System.out::println);
    }

    @Test
    void Ex18() {
        //Выведите на экран элементы списка, которые не входят в другой список
        System.out.println("---Ex18---");
        List<String> ex18 = new ArrayList<>();
        ex18.add("apple");
        ex18.add("banana");
        ex18.add("cherry");
        ex18.add("grape");

        List<String> list = new ArrayList<>();
        list.add("cherry");
        list.add("grape");

        ex18.stream()
                .filter(element -> !list.contains(element))
                .forEach(System.out::println);
    }

    @Test
    void Ex19() {
        //Проверить, все ли числа в массиве [0, 1, …, 19] являются четными
        System.out.println("---Ex19---");
        boolean allEven = IntStream.rangeClosed(1, 19)
                .allMatch(n -> n % 2 == 0);

        if (allEven) {
            System.out.println("All numbers is even.");
        } else {
            System.out.println("Not all numbers are even.");
        }
    }

    @Test
    void Ex20() {
        //Проверить, есть ли четное число в списке [0, 1, 2, 3]
        System.out.println("---Ex20---");
        List<Integer> ex20 = new ArrayList<>();
        ex20.add(1);
        ex20.add(2);
        ex20.add(3);
        ex20.add(4);

        boolean hasEven = ex20.stream()
                .anyMatch(a -> a % 2 == 0);

        if (hasEven) {
            System.out.println("There is an even number in the list");
        } else {
            System.out.println("There are no even numbers in the list");
        }
    }

    @Test
    void Ex21() {
        //Собрать все уникальные элементы Stream в список и отсортировать их
        System.out.println("---Ex21---");
        Stream<Integer> ex21 = Stream.of(3, 1, 2, 3, 4, 2, 5, 1, 6);

        List<Integer> uniqueSortedNumbers = ex21
                .distinct()
                .sorted()
                .toList();

        uniqueSortedNumbers.forEach(System.out::println);
    }

    @Test
    void Ex22() {
        //Собрать элементы Stream в карту, где ключом будет первая буква каждого слова,
        //а значением — само слово. Отсортировать ключи в алфавитном порядке.
        System.out.println("---Ex22---");
        Stream<String> ex22 = Stream.of("apple", "banana", "cherry", "grape");

        Map<Character, String> result = ex22.collect(Collectors
                .toMap(a -> a.charAt(0), // первая буква как ключ в мапе
                        a -> a, // слово как значение в мапе
                        (exist, replace) -> exist, // если ключи совпадают, то остается одно
                        TreeMap::new // для сортировки ключей
                ));
        result.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    @Test
    void Ex23() {
        //Собрать числа в Stream в список сумм цифр каждого числа
        System.out.println("---Ex23---");
        Stream<Integer> numbersStream = Stream.of(123, 45, 678, 9);

        List<Integer> sumOfDigitsList = numbersStream
                .map(SupportFuncClassForStreamTests::sumOfDigitsForEx23)
                .toList();

        sumOfDigitsList.forEach(System.out::println);
    }

    @Test
    void Ex24() {
        //Собрать даты в Stream в список, где каждый элемент — это количество дат в каждом месяце года
        System.out.println("---Ex24---");
        Stream<Integer> ex24 = Stream.of(2023, 2024, 2025);

        List<Integer> daysInEachMonthList = ex24
                .flatMap(year -> getAllMonthsOfYearForEx24(year)
                        .stream())
                .map(SupportFuncClassForStreamTests::getDaysInMonthForEx24)
                .toList();

        daysInEachMonthList.forEach(System.out::println);
    }


    @Test
    void Ex25() {
        //Собрать файлы в Stream в список, где каждый элемент — количество файлов с определенным расширением
        System.out.println("---Ex25---");
        File[] files = new File("src/test/java/ru/aston/artamonov_va/task1/task6/ExtensionList").listFiles();

        if (files != null) {
            List<String> fileExtensions = Arrays.stream(files)
                    .map(file -> getFileExtensionEx26(file.getName()))
                    .toList();

            Map<String, Long> fileCountsByExtension = fileExtensions.stream()
                    .collect(Collectors.groupingBy(extension -> extension, Collectors.counting()));

            fileCountsByExtension.forEach((extension, count) ->
                    System.out.println(extension + ": " + count));
        }
    }

    @Test
    void Ex26() {
        //Собрать пользователей в Stream в список объектов, где каждый объект содержит
        //информацию о городе проживания пользователя и количестве пользователей из этого города.
        System.out.println("---Ex26---");
        List<User> users = createSampleUsersForEx26();

        Map<String, Long> cityUserCounts = users.stream()
                .collect(Collectors.groupingBy(User::getCity, Collectors.counting()));

        cityUserCounts.forEach((city, count) ->
                System.out.println("City: " + city + ", Count of users: " + count));
    }

    @Test
    void Ex27() {
        //Собрать продукты в Stream в таблицу, где каждая строка — это информация
        //о продукте (название, категория, стоимость), отсортированную по категории продукта.
        System.out.println("---Ex27---");
        List<Product> products = createSampleProductsForEx27();

        Map<String, List<Product>> productsByCategory = products
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        productsByCategory.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(product -> {
                System.out.println("Name: " + product.getName() +
                        ", cost: " + product.getPrice());
            });
        });
    }

    @Test
    void Ex28() {
        //Создайте Stream из массива чисел, выведите на экран числа, кратные 3 и 5 одновременно
        System.out.println("---Ex28---");
        int[] numbers = {1, 3, 5, 9, 15, 10, 30};

        Arrays.stream(numbers)
                .filter(a -> a % 3 == 0 && a % 5 == 0)
                .forEach(System.out::println);
    }

    @Test
    void Ex29() {
        //Создайте два Stream-а: один из массива чисел 1…5, второй из массива 5…10.
        //Объедините эти два Stream-а в один и выведите на экран.
        System.out.println("---Ex29---");
        IntStream stream1 = IntStream.rangeClosed(1, 5);
        IntStream stream2 = IntStream.rangeClosed(5, 10);

        IntStream mergeStreams = IntStream.concat(stream1,stream2);

        mergeStreams.forEach(System.out::println);
    }

    @Test
    void Ex30() {
        //Создайте Stream-у чисел от 1 до 20. Создайте новый Stream, который будет выводить на экран только четные числа
        //и числа, кратные 3. Затем объедините эти два Stream-a в один и выведите результирующий Stream.
        System.out.println("---Ex30---");
        Stream<Integer> ex30 = Stream.iterate(1, n -> n + 1).limit(20);

        Stream<Integer> evenAndDivisibleByThirdStream = ex30
                .filter(n -> n % 2 == 0 || n % 3 == 0);

        evenAndDivisibleByThirdStream.forEach(System.out::println);
    }

    @Test
    void Ex31() {
        //Создайте Stream чисел от 2 до 10. Умножьте их на 2 и выведите результат на экран, ограничьтесь первыми десятью результатами.
        System.out.println("---Ex31---");
        IntStream ex31 = IntStream.rangeClosed(2, 10);

        IntStream result = ex31.map(a -> a * 2);

        result.limit(10).forEach(System.out::println);
    }

    @Test
    void Ex32() {
        //Создайте три Stream-а из массивов чисел 1…10, 5…20 и 10…30 соответственно.
        //Объедините их в один Stream и выведите числа, которые кратны 3 или 5.
        System.out.println("---Ex32---");
        int[] arr1 = IntStream.rangeClosed(1, 10).toArray();
        int[] arr2 = IntStream.rangeClosed(5, 20).toArray();
        int[] arr3 = IntStream.rangeClosed(10, 30).toArray();

        Stream<Integer> stream1 = Arrays.stream(arr1).boxed();
        Stream<Integer> stream2 = Arrays.stream(arr2).boxed();
        Stream<Integer> stream3 = Arrays.stream(arr3).boxed();

        Stream<Integer> combinedStream = Stream.concat(Stream.concat(stream1, stream2), stream3);

        combinedStream
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .forEach(System.out::println);
    }

    @Test
    void Ex33() {
        //Создайте Stream, который выводит на экран четные числа от 2 до 30.
        System.out.println("---Ex33---");
        IntStream ex33 = IntStream.rangeClosed(2, 30)
                .filter(a -> a % 2 == 0);
        ex33.forEach(System.out::println);
    }

    @Test
    void Ex34() {
        //Создать стрим из массива чисел и вывести на экран только числа, которые больше 10 и меньше 20.
        System.out.println("---Ex34---");
        int[] ex34 = {5, 12, 15, 8, 18, 25, 7, 14};

        IntStream.of(ex34)
                .filter(n -> n > 10 && n < 20)
                .forEach(System.out::println);
    }

    @Test
    void Ex35() {
        //Создать два стрима: один из чисел от 0 до 10, другой из чисел от 10 до 20.
        //Объединить их в один стрим и вывести на экран числа больше 10.
        System.out.println("---Ex35---");
        IntStream stream1 = IntStream.rangeClosed(0, 10);
        IntStream stream2 = IntStream.rangeClosed(10, 20);

        IntStream combinedStream = IntStream.concat(stream1, stream2);

        combinedStream
                .filter(n -> n > 10)
                .forEach(System.out::println);
    }

}
