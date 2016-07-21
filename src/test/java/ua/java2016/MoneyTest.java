package ua.java2016;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SLiM on 20.07.2016.
 */
public class MoneyTest {

    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10),five.times(2));
        assertEquals(Money.dollar(15),five.times(3));
    }

    @Test
    public void testCurrency() throws Exception {
        assertEquals("USD",Money.dollar(1).currency());
        assertEquals("CHF",Money.frank(1).currency());

    }

    @Test
    public void testSimpleAddition() throws Exception {
        Money five=Money.dollar(5);
        ExpressionMy sum=five.plus(five);
        Bank bank=new Bank();
        Money reduced=bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10),reduced);
    }

    @Test
    public void testPlusReturnSum() throws Exception {
        Money five = Money.dollar(5);
        ExpressionMy result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);

    }

    @Test
    public void testReduceMoney() throws Exception {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1),result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() throws Exception {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.frank(2), "USD");
        assertEquals(Money.dollar(1),result);

    }

    @Test
    public void testIdentityRate() throws Exception {
        assertEquals(1,new Bank().rate("USD","USD"));

    }

    @Test
    public void testReduceSum() throws Exception {
        ExpressionMy sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testDifferentClassEquality() throws Exception {
        assertTrue(new Money(10,"CHF").equals(new Franc(10,"CHF")));
    }

    @Test
    public void testEquality() throws Exception {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.frank(5)));
    }

    @Test
    public void testMixedAddition() throws Exception {
        ExpressionMy fiveBucks=Money.dollar(5);
        ExpressionMy tenFrank=Money.frank(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(fiveBucks.plus(tenFrank), "USD");
        assertEquals(Money.dollar(10),result);
    }

}
