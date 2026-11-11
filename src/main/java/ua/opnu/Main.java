package ua.opnu;

/**
 * Entry point demonstrating Laboratory Work 8 tasks.
 */
public class Main {

    /**
     * Runs demonstrations of all tasks.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        task1();
    }

    /**
     * Task 1: demonstrates {@link MyOptional}.
     */
    private static void task1() {
        System.out.println("=== Task 1: MyOptional ===");
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
}
