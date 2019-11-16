package by.it.advertproject.tester.examl.sololearn.increment.enumvanilia;

public enum IceCream {
    VANILLA("white"),
    STRAWBERRY("PINK"),
    WALNUT("b"),
    CHOCOLATE("dark");
    String color;

    IceCream(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        System.out.println(VANILLA);
        System.out.println(CHOCOLATE);
    }
}
