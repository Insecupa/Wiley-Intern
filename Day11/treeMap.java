package Day11;

import java.util.Map;
import java.util.TreeMap;

public class treeMap {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("John", "Doe");
        map.put("John", "Doe");
        map.put("John", "Doe");
        map.put("Jnhn" , "Doe");
        map.put("Want", "Pit");


        System.out.println(map.toString());
        System.out.println(map.lastEntry().toString());
        for(String mp : map.descendingKeySet()){
            System.out.println(mp);
        }

        for(Map.Entry<String, String> mp : map.descendingMap().entrySet()){
            System.out.println(mp.getKey() + ":" + mp.getValue());
        }
    }
}
