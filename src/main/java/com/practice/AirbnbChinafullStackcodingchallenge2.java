package com.topic.interview;

import java.util.*;

/**
 * 2018.07.14
 * <p>
 * Host Crowding
 * <p>
 * HackerRank Challenge OA 2
 * <p>
 * num = N, records = M : O(M/N * M) number of page multiply length of records
 */
public class AirbnbChinafullStackcodingchallenge2 {

    public static void paging(int num, String[] content) {

        int total = content.length;

        int page = total / num + 1;

        List<String> ret = new ArrayList<>();

        LinkedList<String> record = new LinkedList(Arrays.asList(content));

        Map<String, LinkedList<String>> host2record = new LinkedHashMap<>();

        Iterator<String> itor = record.iterator();

        while (itor.hasNext()) { // map with key: host , value: record linked list

            String e = itor.next();

            String host = e.split(",")[0];

            LinkedList<String> value = host2record.get(host);

            if (value == null) {
                value = new LinkedList<>();
            }

            value.addLast(e);

            host2record.put(host, value);
        }

        PriorityQueue<String> pg = new PriorityQueue<>((o1, o2) -> o1.split(",")[2].compareTo(o2.split(",")[2]));

        Iterator<Map.Entry<String, LinkedList<String>>> it = host2record.entrySet().iterator();

        boolean followOrigin = false;

        while (!host2record.isEmpty()) {

            for (String key : host2record.keySet()) {

                LinkedList<String> value = host2record.get(key);

                if (value.size() == 0) {
                    host2record.remove(key);
                    continue;
                }

                String e = value.removeFirst();

                pg.add(e);
            }

            if (pg.size() < num) {
                int delta = num - pg.size();

                if (host2record.isEmpty()) {
                    while (!pg.isEmpty()) {
                        ret.add(pg.poll());
                    }
                    ret.add("");
                } else {
                    LinkedList<String> value;
                    for (String key : host2record.keySet()) {

                        value = host2record.get(key);

                        break;
                    }
                    while (delta != 0) {
                        delta--;

                    }
                }


            }

            if (pg.size() >= num) {
                int count = num;
                while (count != 0) {
                    count--;
                    ret.add(pg.poll());
                }
                ret.add("");
            }


        }


        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }

    }


    public static void main(String[] args) {
        String[] content = {
                "1, 28, 300.6, San Francisco",
                "4, 5, 209.1, San Francisco",
                "20, 7, 203.4, Oakland",
                "6, 8, 202.9, San Francisco",
                "6, 10, 199.8, San Francisco",
                "1, 16, 190.5, San Francisco",
                "6, 29, 185.3, San Francisco",
                "7, 20, 180.0, Oakland",
                "6, 21, 162.2, San Francisco",
                "2, 18, 161.7, San Jose",
                "2, 30, 149.8, San Jose",
                "3, 76, 146.7, San Francisco",
                "2, 14, 141.8, San Jose"
        };

        paging(5, content);
    }

}
