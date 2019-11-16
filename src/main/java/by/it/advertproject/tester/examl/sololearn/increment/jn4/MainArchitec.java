package by.it.advertproject.tester.examl.sololearn.increment.jn4;

public class MainArchitec {
    public static void main(String[] args) {
        Student student = new Student("Ivanov Andrei", "bsuir");
        Doctor doctor = new Doctor("Petrov Alieksei", "lode");
        testPrint(student);
        testPrint(doctor);
    }

    private static void testPrint(Human human) {
        System.out.println("name: " + human.getHumanName());

    }
}
abstract class Human{
    abstract String getHumanName();

}
class Student extends Human{
    private final String name;
    private final String uni;
    Student (String name, String uni){
        this.name = name;
        this.uni = uni;
    }

    @Override
    String getHumanName() {
        return this.name;
    }
}
class Doctor extends Human{
    private final String name;
    private final String hospital;
    Doctor (String name, String hospital){
        this.name = name;
        this.hospital = hospital;
    }

    @Override
    String getHumanName() {
        return this.name;
    }
}
