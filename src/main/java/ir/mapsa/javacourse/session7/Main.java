package ir.mapsa.javacourse.session7;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max) {
                max = arrayList.get(i);
            }
        }
        System.out.println(max);
        System.out.println(arrayList.get(101));
        HashMap<String, String> map = new HashMap<>();
        map.put("Name", "Ali");
        System.out.println(map.get("family"));
    }
}
