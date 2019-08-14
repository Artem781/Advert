package by.it.advertproject.tester.examl.methodcallinmethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("RESULT VALID = " + tryCatch("3"));
        System.out.println("RESULT VALID = " + tryCatch("RRR"));
    }
    private static Integer tryCatch(String str){
        try {
            System.out.println("INSIDE TRY");
            return Integer.parseInt(str);
        }catch (Exception ex){
            System.out.println("INSIDE CATCH");
            return -1;
        }finally {
            System.out.println("INSIDE FINALLY");
            return -2;
        }
    }
}
