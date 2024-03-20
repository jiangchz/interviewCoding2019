package leetcode.dynamicPrograming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
    //记忆化搜索
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = storeWords(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, dictSet, memo);
    }

    private List<String> wordBreakHelper(String s,
                                         Set<String> dict,
                                         Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> results = new ArrayList<>();

        if (s.length() == 0) {
            return results;
        }

        if (dict.contains(s)) {
            results.add(s);
        }

        for (int len = 1; len < s.length(); len++) {
            String word = s.substring(0, len);
            if (!dict.contains(word)) {
                continue;
            }

            String remains = s.substring(len);
            List<String> remainResults = wordBreakHelper(remains, dict, memo);
            for(String remainResult : remainResults) {
                results.add(word + " " + remainResult);
            }
        }
        memo.put(s, results);
        return results;

    }

    private Set<String> storeWords(List<String> wordDict) {
        Set<String> resultSet = new HashSet<>();
        for (String s : wordDict) {
            resultSet.add(s);
        }
        return resultSet;
    }
}
