package Day11;

import java.util.HashMap;
import java.util.Map;

public class NestedMap {
    public static void main(String[] args) {
        Map<String, Map<String, Double>> employee = new HashMap<>();

        Map<String, Double> salaryMap = new HashMap<>();
        salaryMap.put("Basic", 11000.00);
        salaryMap.put("HRA", 5500.00);

        employee.put("Wiley", salaryMap);

        for(Map.Entry<String, Map<String, Double>> map : employee.entrySet()){
            System.out.println(map.getKey() + "'s Salary Breakdown: ");

            for(Map.Entry<String, Double> salMap : map.getValue().entrySet()){
                System.out.println("\t" + salMap.getKey() + ":" + salMap.getValue());
            }
        }
    }
}
