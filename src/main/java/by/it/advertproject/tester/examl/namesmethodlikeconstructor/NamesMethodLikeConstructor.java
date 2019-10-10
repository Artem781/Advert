package by.it.advertproject.tester.examl.namesmethodlikeconstructor;

public class NamesMethodLikeConstructor {
    public static void main(String[] args) {
        class PointClass {
            int x, y;

            public PointClass(int x, int y) {
                this.x = x;
                this.y = y;
                System.out.println("from PointClass constructor");
            }

            void PointClass() {
                System.out.println("from PointClass method");
            }
        }
    }
}
