package ua.java2016;

/**
 * Created by SLiM on 20.07.2016.
 */
public class Sum implements ExpressionMy {
    public ExpressionMy augend;
    public ExpressionMy addend;

    public Sum(ExpressionMy augend, ExpressionMy addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount
                + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public ExpressionMy plus(ExpressionMy addend) {
        return null;
    }
}
