package ua.java2016;

/**
 * Created by SLiM on 20.07.2016.
 */
public class Money implements ExpressionMy{
    protected int amount;
    private String currency;

    public Money(int amount, String currency) {
        this.amount=amount;
        this.currency=currency;
    }

    static Money dollar(int amount) {
        return new Money(amount,"USD");
    }
    static Money frank(int amount) {
        return new Money(amount,"CHF");
    }

    public ExpressionMy times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }


    @Override
    public ExpressionMy plus(ExpressionMy addend) {
        return new Sum(this,addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate=bank.rate(currency(),to);
        return new Money(amount/rate, to);
    }

    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object o)  {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount &&
                currency().equals(money.currency());
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
