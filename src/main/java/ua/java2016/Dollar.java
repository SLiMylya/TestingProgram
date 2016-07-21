package ua.java2016;

/**
 * Created by SLiM on 20.07.2016.
 */
public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
