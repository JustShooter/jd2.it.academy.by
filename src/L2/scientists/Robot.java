package L2.scientists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Robot {
    public static Integer robotsQuantity(List<Parts> robotsParts){
        Map<Parts, Integer> scientistParts = new HashMap<>();
        for (Parts parts: robotsParts) {
            if (scientistParts.containsKey(parts)) {
                scientistParts.put(parts, scientistParts.get(parts) + 1);
            } else {
                scientistParts.put(parts, 1);
            }
        }
            List<Map.Entry<Parts, Integer>> value = scientistParts.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());
        return value.get(0).getValue();
    }
}
