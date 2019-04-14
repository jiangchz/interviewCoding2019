package graphsAndSearch.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
    //version 1 will time out
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        List<String> results = new ArrayList<>();
        boolean[][] isInDict = preProcessing(s, wordDict);
        wordBreakHelper(results, result, s, isInDict, 0);
        return results;
    }

    private boolean[][] preProcessing(String s, List<String> wordDict) {
        int length = s.length();
        boolean[][] result = new boolean[length][length];
        Set<String> words = new HashSet<String>();
        for (String current : wordDict) {
            words.add(current);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (words.contains(s.substring(i, j + 1))) {
                    result[i][j] = true;
                }
            }
        }
        return result;
    }

    private void wordBreakHelper(List<String> results,
                                 List<String> result,
                                 String s,
                                 boolean[][] isInDict,
                                 int startIndex) {
        if (startIndex == s.length()) {
            results.add(combineSting(result));
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isInDict[startIndex][i]) {
                continue;
            }
            result.add(s.substring(startIndex, i + 1));
            wordBreakHelper(results, result, s, isInDict, i + 1);
            result.remove(result.size() - 1);
        }
    }
    private String combineSting(List<String> resultStrings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultStrings.size(); i++) {
            sb.append(resultStrings.get(i)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    //version 2
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s, dict, memo);
    }

    public ArrayList<String> wordBreakHelper(String s,
                                             Set<String> dict,
                                             Map<String, ArrayList<String>> memo){
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        ArrayList<String> results = new ArrayList<String>();

        if (s.length() == 0) {
            return results;
        }

        if (dict.contains(s)) {
            results.add(s);
        }

        for (int len = 1; len < s.length(); ++len){
            String word = s.substring(0, len);
            if (!dict.contains(word)) {
                continue;
            }

            String suffix = s.substring(len);
            ArrayList<String> segmentations = wordBreakHelper(suffix, dict, memo);

            for (String segmentation: segmentations){
                results.add(word + " " + segmentation);
            }
        }

        memo.put(s, results);
        return results;
    }
}
