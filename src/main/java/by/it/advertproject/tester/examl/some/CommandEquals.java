package by.it.advertproject.tester.examl.some;

public class CommandEquals {
    public static void main(String[] args) {
        String adm = "to_admin_profile";
        String comAdm = "TO_ADMIN_PROFILE";
        if (adm.equalsIgnoreCase(comAdm)){
            System.out.println("equals");
        }else {
            System.out.println("not equals");
        }
    }
}
