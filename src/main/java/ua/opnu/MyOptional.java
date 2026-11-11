package ua.opnu;

/**
 * Simplified analogue of {@link java.util.Optional}: holds either a value of type {@code T} or nothing.
 *
 * @param <T> type of the stored value
 */
public class MyOptional<T> {

    private T value;
    private boolean present;

    /**
     * Creates an empty optional.
     */
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    /**
     * Creates an optional holding the given value.
     *
     * @param value non-null value to store
     * @throws IllegalArgumentException if {@code value} is {@code null}
     */
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    /**
     * @return {@code true} if a value is present
     */
    public boolean isPresent() {
        return present;
    }

    /**
     * @return {@code true} if no value is present
     */
    public boolean isEmpty() {
        return !isPresent();
    }

    /**
     * Returns the stored value.
     *
     * @return the value
     * @throws IllegalStateException if the optional is empty
     */
    public T get() {
        if (!present) {
            throw new IllegalStateException("Значення відсутнє");
        }
        return value;
    }

    /**
     * Returns the stored value or the given default.
     *
     * @param defaultValue value returned when the optional is empty
     * @return the stored value if present, otherwise {@code defaultValue}
     */
    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    /**
     * @return {@code MyOptional[value=...]} or {@code MyOptional[empty]}
     */
    @Override
    public String toString() {
        return present ? "MyOptional[value=" + value + "]" : "MyOptional[empty]";
    }
}
