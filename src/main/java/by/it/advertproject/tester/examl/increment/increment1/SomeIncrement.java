package by.it.advertproject.tester.examl.increment.increment1;

public class SomeIncrement {
    public static void main(String[] args) {
        int a = 20;
        a = --a - 1;
        System.out.println("a: " + a);      // 18
        System.out.println("a: " + a);      // 18
        int b = 20;
        b = b-- - 1;
        System.out.println("b: " + b);      // 19
        System.out.println("b: " + b);      // 19
        System.out.println("b: " + b);      // 19
    }
}
