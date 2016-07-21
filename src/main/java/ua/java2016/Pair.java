package ua.java2016;

/**
 * Created by SLiM on 21.07.2016.
 */
public class Pair {
    private String from;
    private String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        Pair pair = (Pair) o;
        return from.equals(pair.from)&& to.equals(pair.to);

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
