package by.it.advertproject.tester.examl.polimorfizmtask.polomorfizm;

public class Child extends Parent {
    private int cnt = 0;

    @Override
    public void a() {
        System.out.println("A CHILD");
    }

    @Override
    public void b() {
        System.out.println("B CHILD");
        super.b();
    }
}
