package leetcode.string;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupString {
    public List<List<String>> groupStrings(String[] strings) {
        return Arrays.stream(strings)
                .collect(Collectors.groupingBy(this::normalize))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    private List<Integer> normalize(String s) {
        return s.chars()
                .mapToObj(
                        c -> (c - s.charAt(0) + 26) % 26
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        GroupString g = new GroupString();
        args = new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        g.subdomainVisits(args);
        for (String res : g.subdomainVisits(args)) {
            System.out.println(res);
        }
    }

    private List<String> subdomainVisits(String[] cpdomains) {
        return Arrays.stream(cpdomains)
                .map(record -> record.split(" "))
                .map(countToDomain -> domainNameToMap(countToDomain))
                .flatMap(domainToCount -> domainToCount.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }

    private Map<String, Integer> domainNameToMap(String[] countToDomain) {
        Map<String, Integer> map = new HashMap<>();
        int count = Integer.valueOf(countToDomain[0]);
        String wholeDomain = countToDomain[1];
        int dotIndex = wholeDomain.indexOf(".");
        while(dotIndex != -1) {
            map.put(wholeDomain, count);
            wholeDomain = wholeDomain.substring(dotIndex + 1);
            dotIndex = wholeDomain.indexOf(".");
        }
        map.put(wholeDomain, count);
        return map;
    }


}
