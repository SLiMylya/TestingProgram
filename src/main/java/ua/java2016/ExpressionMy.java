package ua.java2016;

/**
 * Created by SLiM on 20.07.2016.
 */
public interface ExpressionMy {
    Money reduce(Bank bank, String to);

    ExpressionMy plus(ExpressionMy addend);
}
