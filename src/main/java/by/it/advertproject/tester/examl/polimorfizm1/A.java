package by.it.advertproject.tester.examl.polimorfizm1;

public class A {
    static {
        System.out.print("static-A, ");
    }
    {
        System.out.print("init-A, ");
    }
    public A() {
        System.out.print("constructor-A, ");
    }
}
