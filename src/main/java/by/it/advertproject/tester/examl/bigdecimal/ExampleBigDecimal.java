package by.it.advertproject.tester.examl.bigdecimal;

import java.math.BigDecimal;

public class ExampleBigDecimal {
    public static void main(String[] args) {
        BigDecimal bigDecimalInt = new BigDecimal(0.15);
        BigDecimal bigDecimalString = new BigDecimal("0.15");
        System.out.println(bigDecimalInt);
        System.out.println(bigDecimalString);
    }
}
