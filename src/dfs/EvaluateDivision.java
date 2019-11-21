package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //create rateMap
        Map<String, Map<String, Double>> rateMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String from = equations[i][0];
            String to = equations[i][1];
            double rate = values[i];
            if (!rateMap.containsKey(from)) {
                rateMap.put(from, new HashMap<>());
            }
            rateMap.get(from).put(to, rate);

            if (!rateMap.containsKey(to)) {
                rateMap.put(to, new HashMap<>());
            }
            rateMap.get(to).put(from, 1.0 / rate);
        }

        double[] result = new double[queries.length];
        int index = 0;
        for (String[] query: queries) {
            result[index] = dfs(rateMap, query[0], query[1], new HashSet<>());
            index++;
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> rateMap,
                       String from,
                       String to,
                       Set<String> visited) {
        if (!rateMap.containsKey(from)) {
            return -1.0;
        }
        if (from.equals(to)) {
            return 1;
        }

        visited.add(from);
        Map<String, Double> neighborRates = rateMap.get(from);
        for (String neighbor : neighborRates.keySet()) {
            if (visited.contains(neighbor)) {
                continue;
            }
            double current = neighborRates.get(neighbor);
            double childRate = dfs(rateMap, neighbor, to, visited);
            if (childRate > 0) {
                return current * childRate;
            }
        }
        visited.remove(from);
        return -1.0;
    }
}
