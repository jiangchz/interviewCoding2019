package leetcode.dfs;

public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return isMatchHelper(memo, visited, s, 0, p, 0);
    }
    private boolean isMatchHelper(boolean[][] memo,
                                  boolean[][] visited,
                                  String s,
                                  int sIndex,
                                  String p,
                                  int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        if (sIndex == s.length()) {
            return allEmpty(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        boolean match = false;

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);

        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            match = isMatchHelper(memo, visited, s, sIndex, p, pIndex + 2) || (charMatch(sChar, pChar) && isMatchHelper(memo, visited, s, sIndex + 1, p, pIndex));
        } else {
            match = charMatch(sChar, pChar) && isMatchHelper(memo, visited, s, sIndex + 1, p, pIndex + 1);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private boolean allEmpty(String p, int pIndex) {
        while (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            pIndex += 2;
        }
        return pIndex == p.length();
    }
    private boolean charMatch(char charS, char charP) {
        return charS == charP || charP == '.';
    }
}
