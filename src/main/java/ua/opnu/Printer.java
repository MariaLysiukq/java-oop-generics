package ua.opnu;

public class Printer {

    public <T> void printArray(T[] array) {
        StringBuilder line = new StringBuilder();
        for (T element : array) {
            line.append(element).append(' ');
        }
        System.out.println(line.toString().trim());
    }
}
