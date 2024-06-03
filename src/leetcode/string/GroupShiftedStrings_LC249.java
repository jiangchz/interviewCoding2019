package leetcode.string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupShiftedStrings_LC249 {
    public List<List<String>> groupStrings_v1(String[] strings) {
        return Arrays.stream(strings)
                .collect(Collectors.groupingBy(this::normalize))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public List<List<String>> groupStrings_v2(String[] strings) {
        Map<List<Integer>, List<String>> mapping = new HashMap<>();
        for (String s : strings) {
            List<Integer> index = normalize(s);
            List<String> valueStrings = mapping.getOrDefault(index, new ArrayList<>());
            valueStrings.add(s);
            mapping.put(index, valueStrings);
        }

        return new ArrayList<List<String>>(mapping.values());
    }

    private List<Integer> normalize(String s) {
        return s.chars()
                .mapToObj(c -> (c - s.charAt(0) + 26) % 26)
                .collect(Collectors.toList());
    }

}
