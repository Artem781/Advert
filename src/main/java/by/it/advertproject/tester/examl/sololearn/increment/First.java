package by.it.advertproject.tester.examl.sololearn.increment;

public class First {
    public static void main(String[] args) {
        int a = 5;
        int b = a++;
        int c = b * a;
        a = c % a;
        System.out.println(a);
    }
}
