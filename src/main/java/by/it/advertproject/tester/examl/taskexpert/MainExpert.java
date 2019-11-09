package by.it.advertproject.tester.examl.taskexpert;

import org.apache.logging.log4j.core.util.ArrayUtils;

import java.util.*;
import java.util.stream.Stream;

public class MainExpert {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(3);
        a1.add(5);
        ArrayList<Integer> b1 = new ArrayList<>();
        b1.add(2);
        b1.add(6);
        b1.add(8);
//        mainExpert.merge(a1, b1);
//        mainExpert.streamMethod(a1);
//        Merge testMerge = new Merge();
//        int [] result = testMerge.sortArray(new int[]{2,3,1,4});
        MainExpert mainExpert = new MainExpert();
//        mainExpert.massiveLength();

        int[] ints = new int[]{2, 3, 1, 4, 9};
        System.out.printf("ints.length: %d\n", ints.length);

//        int [] result = mainExpert.sortArray(new int[]{2,3,1,4});
        int[] result = mainExpert.sortArray(ints);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
//    System.arrayCopy(from, fromIndex, to, toIndex, count);
//    from - массив, который копируем
//    to - массив в которой копируем
//    fromIndex - индекс в массиве from начиная с которого берем элементы для копирования
//    toIndex - индекс в массиве to начиная с которого вставляем элементы
//    count - количество элементов которые берем из массива from и вставляем в массив to
//    Массив to должен иметь достаточный размер, чтобы в нем уместились все копируемые элементы.

    void mergeSort(ArrayList<Integer> a, ArrayList<Integer> b) {

    }

    void massiveLength() {
        String[] name = {"tom", "dick", "harry"};
        System.out.println("name.length: " + name.length);      //name.length: 3
        System.out.println("name[0]: " + name[0]);              //name[0]: tom
        System.out.println("name[1]: " + name[1]);              //name[1]: dick
        System.out.println("name[2]: " + name[2]);              //name[2]: harry
        // дальше бросате исключение ArrayIndexOutOfBoundsException
        System.out.println("name[3]: " + name[3]);              //java.lang.ArrayIndexOutOfBoundsException: 3
    }

    public int[] sortArray(int[] arrayA) { // сортировка Массива который передается в функцию
        System.out.printf("arrayA.length: %d =\t", arrayA.length);
        for (int i = 0; i < arrayA.length; i++) {
            System.out.printf("arrayA[%d]: %d\t", i, arrayA[i]);
        }
        System.out.println();
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            System.out.println("arrayA == null");
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            System.out.println("arrayA.length < 2 \t return arrayA");
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }

        int masLeftLength = arrayA.length/2;
        System.out.println("masLeftLength: " + masLeftLength);
        int masRightLength = arrayA.length - arrayA.length/2;
        System.out.println("masRightLength: " + masRightLength);


        // копируем левую часть от начала до середины
        int[] arrayLeft = new int[arrayA.length / 2];
//        System.arraycopy(arrayA, 0, arrayLeft, 0, arrayA.length / 2);
        System.arraycopy(arrayA, 0, arrayLeft, 0, masLeftLength);
        System.out.printf("arrayLeft.length: %d =\t", arrayLeft.length);
        for (int i = 0; i < arrayLeft.length; i++) {
            System.out.printf("arrayLeft[%d]: %d \t", i, arrayLeft[i]);
        }
        System.out.println();

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int[] arrayRight = new int[masRightLength];
        System.out.printf("arrayRight.length: %d =\t", arrayRight.length);
//        System.arraycopy(arrayA, arrayA.length / 2, arrayRight, 0, arrayA.length - arrayA.length / 2);
        System.arraycopy(arrayA, arrayA.length / 2, arrayRight, 0, masRightLength);
        for (int i = 0; i < arrayRight.length; i++) {
            System.out.printf("arrayRight[%1$d]: %2$d\t", i, arrayRight[i]);
        }
        System.out.println("\narrayLeft = sortArray(arrayLeft)");

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayLeft = sortArray(arrayLeft); // левая часть возврат из рекурсии строкой return arrayA;
        System.out.println("\narrayRight = sortArray(arrayRight)");
        arrayRight = sortArray(arrayRight); // правая часть возврат из рекурсии строкой return arrayA;
        System.out.println("return mergeArray(arrayLeft, arrayRight)");
        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayLeft, arrayRight);
    }

    public int[] mergeArray(int[] arrayА, int[] arrayB) {

//        int [] arrayC = int[arrayA.length + arrayB.length];
        int[] arrayC = new int[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayА.length) {
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayА[i - positionA];
                positionA++;
            } else if (arrayА[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayА[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }

    void streamMethod(ArrayList<Integer> list) {
        System.out.println("Iterator");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.printf("%3d", next);
        }
        System.out.println("\nCycle for each");
        for (Integer element : list) {
            System.out.printf("%3d", element);
        }
        System.out.println("\nStream");
        Stream<Integer> stream = list.stream();
        stream.forEach(x -> System.out.printf("%1$3d", x));
//        stream.forEach(System.out::println);
        System.out.println();


    }

    void merge(ArrayList<Integer> aMerge, ArrayList<Integer> bMerge) {
        boolean addMas = aMerge.addAll(bMerge);
        Object[] objects = aMerge.toArray();
        int[] ia = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            ia[i] = (int) objects[i];
        }
        ia = Arrays.stream(ia).
                boxed().
                sorted((a, b) -> b.compareTo(a)).
                mapToInt(i -> i).
                toArray();
        for (int element : ia) {
            System.out.println(element);
        }
        aMerge.clear();
        List<int[]> ints = Arrays.asList(ia);
    }
}
