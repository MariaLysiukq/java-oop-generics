package ua.opnu;

public class GenericThreeTuple<T, V, S> {

    public final GenericTwoTuple<T, V> two;
    public final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.two = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    @Override
    public String toString() {
        return "(" + two.first + "," + two.second + "," + three + ")";
    }
}
