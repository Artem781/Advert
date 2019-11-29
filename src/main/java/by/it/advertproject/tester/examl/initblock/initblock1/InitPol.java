package by.it.advertproject.tester.examl.initblock.initblock1;

class Parent {
    static {
        System.out.println("static block Parent");
    }

    { System.out.println("init block Parent"); }

    Parent() {
        System.out.println("Parent constructor");
    }
}

public class InitPol extends Parent {
    static {
        System.out.println("static block InitPol");
    }

    {
        System.out.println("init block InitPol");
    }

    InitPol() {
        System.out.println("InitPol constructor");
    }

    public static void main(String[] args) {
//        new InitPol();
//        new InitPol();
        new Parent();
//        new Parent();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("psvm InitPol");
    }

}
