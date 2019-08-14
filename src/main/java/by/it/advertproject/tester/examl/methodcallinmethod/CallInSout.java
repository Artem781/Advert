package by.it.advertproject.tester.examl.methodcallinmethod;

public class CallInSout {
    public static void main(String[] args) {
        String Str = new String("Добро пожаловать на ProgLang.su");
        System.out.println("Возвращаемое значение: " +Str.replaceAll("ProgLang.su",
                "сайт посвященный программированию!"));

        String Str1 = new String("Добро русские: ооо, английские: ooo пожаловать на ProgLang.su .su .su");

        System.out.print("Возвращаемое значение: " );
        System.out.println(Str1.replace('s', 'b'));

        System.out.print("Возвращаемое значение: " );
        System.out.println(Str1.replace('о', 'а'));
    }
}
