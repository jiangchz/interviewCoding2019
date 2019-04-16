package dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        List<String> result = new ArrayList<String>();
        helper(results, result, s, 0);
        return results;
    }
    private void helper(List<List<String>> results,
                        List<String> result,
                        String s,
                        int startIndex) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(result));
        }
        for (int i = startIndex + 1; i <= s.length(); i++) {
            String currentString = s.substring(startIndex, i);//bug substring
            if (isPalindrom(currentString)) {
                result.add(currentString);
                helper(results, result, s, i);
                result.remove(result.size() - 1);
            }
        }
    }

    //todo improve with dp
    private boolean isPalindrom(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
