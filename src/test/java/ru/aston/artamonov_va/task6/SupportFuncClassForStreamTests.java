package ru.aston.artamonov_va.task6;

import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupportFuncClassForStreamTests {
    public static int sumOfDigitsForEx23(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10; // Получаем последнюю цифру и добавляем к сумме
            number /= 10; // Удаляем последнюю цифру
        }
        return sum;
    }

    public static List<YearMonth> getAllMonthsOfYearForEx24(int year) {
        return Stream.of(Month.values())
                .map(month -> YearMonth.of(year, month))
                .collect(Collectors.toList());
    }

    public static int getDaysInMonthForEx24(YearMonth yearMonth) {
        return yearMonth.lengthOfMonth();
    }

    public static String getFileExtensionEx26(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex >= 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        } else {
            return "";
        }
    }
    public static List<User> createSampleUsersForEx26() {
        return Stream.of(
                new User("Москва"),
                new User("Санкт-Петербург"),
                new User("Москва"),
                new User("Санкт-Петербург"),
                new User("Екатеринбург"),
                new User("Москва")
        ).collect(Collectors.toList());
    }
    public static List<Product> createSampleProductsForEx27() {
        return Stream.of(
                new Product("Яблоко", "Фрукты", 1.5),
                new Product("Банан", "Фрукты", 2.0),
                new Product("Морковь", "Овощи", 1.0),
                new Product("Картофель", "Овощи", 0.8),
                new Product("Кола", "Напитки", 1.2),
                new Product("Чай", "Напитки", 0.5)
        ).collect(Collectors.toList());
    }
}