package by.it.advertproject.tester.examl.innerclasses;
class InhBase {
    InhBase(){
        System.out.println("InhBase");
    }
}
public class Inh1 {
    public static void main(String[] args) {
        new InhBase();
        new Inh1();
    }
}
