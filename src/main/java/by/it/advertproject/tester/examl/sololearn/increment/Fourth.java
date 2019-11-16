package by.it.advertproject.tester.examl.sololearn.increment;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.lang.*;
//import java.lang.System;
//import static java.lang.System.out;
//import static java.lang.System.out.println;

public class Fourth implements Serializable {
    //    static int[] a;
//    static {
//        a[0]=2;
//    }

    public static void main(String[] args) throws IOException {
///////////////////////////////////////////////////////////////////////////////////////////////
//        println("Java forever");
///////////////////////////////////////////////////////////////////////////////////////////////
//        String str1 = "Java";
//        String str2 = new String("Java");
//        if (str1.equals(str2.intern())) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//        if (str1 == str2) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
///////////////////////////////////////////////////////////////////////////////////////////////
//        int a = 13;
//        int b = (a % 3) * 6;
//        a = 3;
//        System.out.println(b / a);
//        double k = (1.0 / 0);
//        System.out.println(k);
///////////////////////////////////////////////////////////////////////////////////////////////
//        Object[] obj = {"one", "two", "three"};
//        Fourth fourth = new Fourth();
//        fourth.f(obj);
///////////////////////////////////////////////////////////////////////////////////////////////
//        String reg1 = "^a|b|c$";
//        String reg2 = "^(a|b|c)$";
//        String text = "textc";
//        System.out.println(Pattern.compile(reg1).matcher(text).find());
//        System.out.println(Pattern.compile(reg2).matcher(text).find());
///////////////////////////////////////////////////////////////////////////////////////////////
//        StringBuilder sb1 = new StringBuilder("java");
//        StringBuffer sb2 = new StringBuffer("java");
//        if (sb1.equals(sb2)){
//            System.out.println("A");
//        }else {
//            System.out.println("B");
//        }

//        int x = 5;
//        Fourth z = new Fourth();
//        z.z(x);
//        System.out.print(" main x = " + x);
//    }
//    void z(int x){
//        System.out.print("z x = " + x++);

///////////////////////////////////////////////////////////////////////////////////////////////
//        String fileName = "greetings.txt";
       // line 1 insert code here
//        FileOutputStream stream = new FileOutputStream(fileName);   //  ошибка

//        PrintWriter stream = new PrintWriter(fileName);       // без ошибки
//
//        FileWriter stream = new FileWriter(fileName);         // без ошибки
//
//        FileOutputStream fos = new FileOutputStream(fileName);    //  ошибка
//        InputStreamWriter stream = new InputStreamWriter(fos);

//        FileOutputStream fos = new FileOutputStream(fileName);      // без ошибки
//        OutputStreamWriter stream = new OutputStreamWriter(fos);
//

//        writeGreetings (stream);
//        stream.close();
///////////////////////////////////////////////////////////////////////////////////////////////
//        test(99.9);
///////////////////////////////////////////////////////////////////////////////////////////////
//        List<Object> list4 = new ArrayList<Doctor>();
//        List<MedicalStaff> list2 = new ArrayList<Doctor>();
//        List<Object> list5 = new ArrayList<Object>();
//        List<Doctor> list3 = new ArrayList<MedicalStaff>();
//        List<Doctor> list1 = new ArrayList<Doctor>();
///////////////////////////////////////////////////////////////////////////////////////////////
//        Fourth v = new Fourth();
//        System.out.println(v.var(4,5));
///////////////////////////////////////////////////////////////////////////////////////////////
//        A a = f(new A());
//        B b = f(new B());
///////////////////////////////////////////////////////////////////////////////////////////////
//        Fifth<Comparator> objectFifth = new Fifth<>();
///////////////////////////////////////////////////////////////////////////////////////////////
    }
//    static A f(A a){return a;}
//    static B f(B b){return b;}
//    class A{
//        void f(B b){
//            System.out.println("B");
//        }
//        void f(A a){
//            System.out.println("BA");
//        }
//    }
//    class B extends A{
//        void f(B b){
//            System.out.println("AB");
//        }
//        void f(A a){
//            System.out.println("A");
//        }
//    }

//    public String var(int[] vals) {
//        return "a";
//    }
//
//    public String var(int... vals) {
//        return "b";
//    }

    class MedicalStaff {
    }

    class Doctor extends MedicalStaff {
    }

    class Nurse extends MedicalStaff {
    }

    class HeadDoctor extends Doctor {
    }

    static void test(float x) {
        System.out.println("float");
    }

    static void test(double x) {
        System.out.println("double");
    }

    private static void writeGreetings(Writer writer) throws IOException {
        BufferedWriter bw = new BufferedWriter(writer);
    }


//    public void f(Object obj){};
//    public void f(String str){};
//    public void f(String ... str){};
//    public static void f(Object ... str){};
//    public static void f(Object [] ... str){};
//    public static void f(String [] ... str){};
}
