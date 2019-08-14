package by.it.advertproject.tester.examl.polomorfizm;

public class Parent {
    private int cnt = 0;

    public void a(){
        System.out.println("A PARENT");
    }
    public void b(){
        this.a();
        System.out.println("B PARENT");
    }
}
