package grammer.collections;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

public class Main {

    private static Map<String, Integer> data;

    static {
        data = new HashMap<String, Integer>();
        data.put("1", 10);
        data.put("w", 23);
        data.put("x", 90);
        data.put("q", 2);
    }

    public static void main(String[] args) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(data.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(data);
    }
}
