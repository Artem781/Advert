package by.it.advertproject.tester.examl.polimorfizm1;

public class B extends A {
    static {
        System.out.print("static-B, ");
    }
    {
        System.out.print("init-B, ");
    }
    public B(){
        System.out.print("Constructor-B, ");
    }
}
