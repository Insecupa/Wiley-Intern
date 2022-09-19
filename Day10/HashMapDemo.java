package Day10;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("John", 2000);
        map.put("Adam", 1520);
        map.put("Wiley", 2233);
        map.put("Shirley", 231);

        System.out.println(map);

        System.out.println(map.get("Shirley"));
        System.out.println(map.getOrDefault("Doe", 220));
        System.out.println(map);

        for(Map.Entry<String, Integer> mp : map.entrySet()){
            System.out.println(mp.getKey() + " " + mp.getValue());
        }
    }
}
