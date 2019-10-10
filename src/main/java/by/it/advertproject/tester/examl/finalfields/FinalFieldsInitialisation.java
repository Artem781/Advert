package by.it.advertproject.tester.examl.finalfields;

public class FinalFieldsInitialisation {

    public static void main(String[] args) {
        ClassBB classBB = new ClassBB(4,5);
        System.out.println(classBB);

        class B {
          final int x, y;

            public B(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        System.out.println("ok");
    }
}
