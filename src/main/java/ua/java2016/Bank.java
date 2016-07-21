package ua.java2016;

import java.util.Hashtable;

/**
 * Created by SLiM on 20.07.2016.
 */
public class Bank {
    private Hashtable rates=new Hashtable();

    public Bank() {
//        rates.put(new Pair("USD","USD"),1);
//        rates.put(new Pair("CHF","USD"),2);
    }

    public Money reduce(ExpressionMy source, String to){
        return source.reduce(this,to);
    }

    int rate(String from,String to){
        if(from.equals(to)) return 1;
        Integer rate= (Integer) rates.get(new Pair(from,to));
        return rate.intValue();
    }


    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from,to),new Integer(rate));
    }
}
