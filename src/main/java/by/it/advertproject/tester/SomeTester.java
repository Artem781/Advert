package by.it.advertproject.tester;

import java.util.*;

public class SomeTester {
    public static void main(String[] args) {

        Integer a = new Integer(2); Integer b = new Integer(2);
//        System.out.println(a.intValue() == b.intValue());
//        System.out.println(a.compareTo(b));
//        System.out.println(a.equals(b));
//        System.out.println(a == b);


//        Set products = new HashSet();
//        products.add(new Product("Hat", 3));
//        products.add(new Product("Hat", 3));
//
//        System.out.println(products);



        List arr =  new ArrayList();

        arr.add(new Product("Shirt", 3));
        arr.add(new Product("Hat", 3));
        arr.add(new Product("Hat", 2));
        arr.add(new Product("Shirt", 1));

        Collections.sort(arr, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                if(o1.title.compareTo(o2.title) != 0) {
                    return o1.title.compareTo(o2.title);
                }

                if(o1.size > o2.size) {
                    return 1;
                } else if (o1.size < o2.size) {
                    return -1;
                }

                return 0;
            }
        });

        System.out.println(arr);







    }
}
