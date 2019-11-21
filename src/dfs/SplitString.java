package dfs;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            results.add(result);
            return results;
        }
        helper(results, result, s, 0);
        return results;
    }
    private void helper(List<List<String>> results,
                        List<String> result,
                        String s,
                        int startIndex) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(result));
            return;
        }

        //option1:
        result.add(s.substring(startIndex, startIndex + 1));
        helper(results, result, s, startIndex + 1);
        result.remove(result.size() - 1);

        //option2
        if (startIndex < s.length() - 1) {
            result.add(s.substring(startIndex, startIndex + 2));//bug
            helper(results, result, s, startIndex + 2);
            result.remove(result.size() - 1);
        }
    }
}
/*

680. Split String
中文English
Give a string, you can choose to split the string after one character or two adjacent characters, and make the string to be composed of only one character or two characters. Output all possible results.

Example
Example1

Input: "123"
Output: [["1","2","3"],["12","3"],["1","23"]]

 */