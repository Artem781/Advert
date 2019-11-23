package by.it.advertproject.tester.examl.wordstatic.static1;

public class Test {
    public static String foo() {
        System.out.println("Test foo called");
        return "";
    }

    public static void main(String[] args) {
        Test obj = null;
        System.out.println("some word: " + obj.foo());
        System.out.println("end");

        if (obj instanceof Object){
            System.out.println("yes");
        }
    }
}

class ChildTest extends Test {

}

