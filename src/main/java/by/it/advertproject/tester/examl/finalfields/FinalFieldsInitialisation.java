package by.it.advertproject.tester.examl.finalfields;

public class FinalFieldsInitialisation {

    public static void main(String[] args) {
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
