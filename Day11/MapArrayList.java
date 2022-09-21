package Day11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapArrayList {
    static Map<String, ArrayList<Double>> expends = new HashMap<>();
    public static void main(String[] args) {
        addExpend("Stationery", 200.0);
        addExpend("Stationery", 200.0);
        addExpend("Stationery", 200.0);
        addExpend("Stationery", 200.0);

        addExpend("Movies", 102.2);
        addExpend("Movies", 102.2);
        addExpend("Movies", 102.2);
        for(Map.Entry<String, ArrayList<Double>> mp : expends.entrySet()){
            for(Double d : mp.getValue()){
                System.out.println(d);
            }
        }
    }

    static void addExpend(String cat, Double amount){
//        ArrayList<Double> tr = expends.get(cat);
//
//        tr.add(amount);

        if(expends.containsKey(cat)){
            ArrayList<Double> costs = expends.get(cat);
            costs.add(amount);
        }else{
            ArrayList<Double> costs = new ArrayList<>();
            costs.add(amount);
            expends.put(cat, costs);
        }
    }
}
