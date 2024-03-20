package leetcode.dfs;

public class WildcardMatching {
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
            return allStart(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char charS = s.charAt(sIndex);
        char charP = p.charAt(pIndex);
        boolean match = false;
        if (charP == '*') {
            match = isMatchHelper(memo, visited, s, sIndex, p, pIndex + 1) || isMatchHelper(memo, visited, s, sIndex + 1, p, pIndex);
        } else {
            match = charMatch(charS, charP) && isMatchHelper(memo, visited, s, sIndex + 1, p, pIndex + 1);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private boolean allStart(String p, int pIndex) {
        while (pIndex < p.length()) {
            if (p.charAt(pIndex++) != '*') {
                return false;
            }
        }
        return true;
    }
    private boolean charMatch(char charS, char charP) {
        return charS == charP || charP == '?';
    }
}
