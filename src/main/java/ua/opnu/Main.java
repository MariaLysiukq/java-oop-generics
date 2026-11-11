package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    private static void task1() {
        System.out.println("Task 1: MyOptional");
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));
        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }
    }

    private static void task2() {
        System.out.println("Task 2: BookData");
        List<BookData> books = new ArrayList<>(List.of(
                new BookData("Kobzar", "Taras Shevchenko", 10, 45.0),
                new BookData("Dune", "Frank Herbert", 4, 18.0),
                new BookData("Clean Code", "Robert Martin", 2, 10.0),
                new BookData("Algorithms", "Robert Sedgwick", 5, 22.5),
                new BookData("New Book", "Unknown", 0, 0.0)));
        Collections.sort(books);
        for (BookData book : books) {
            System.out.println(book);
        }
        BookData a = new BookData("A", "X", 1, 5.0);
        BookData b = new BookData("B", "Y", 2, 10.0);
        System.out.println("A vs B (equal rating, by title): " + a.compareTo(b));
    }

    private static void task3() {
        System.out.println("Task 3: Printer");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }

    private static void task4() {
        System.out.println("Task 4: Filter");
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] even = Filter.filter(numbers, n -> n % 2 == 0);
        System.out.println("Even: " + Arrays.toString(even));
        String[] words = {"apple", "kiwi", "banana", "fig", "cherry"};
        String[] longWords = Filter.filter(words, w -> w.length() > 4);
        System.out.println("Longer than 4: " + Arrays.toString(longWords));
        String[] none = Filter.filter(words, w -> w.isEmpty());
        System.out.println("Empty words: " + Arrays.toString(none));
    }
}
