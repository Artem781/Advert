package by.it.advertproject.tester.examl.mapentryset;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class MapEntrySet {
    public static void main(String[] args) {
        Map<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("first", "valueFirst");
        stringStringHashMap.put("second", "valueSecond");
        stringStringHashMap.put("third", "valueThird");
        stringStringHashMap.put("fourth", "valueFourth");
        stringStringHashMap.put("fifth", "valueFifth");
        stringStringHashMap.put("state", "valueState");

        for (Map.Entry<String, String> element : stringStringHashMap.entrySet()) {
            String key = element.getKey();
            String value = element.getValue();
            System.out.printf(Locale.ENGLISH, "%1$s%2$s\n", key, value);
        }
    }
}
