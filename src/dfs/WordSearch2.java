package dfs;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    //暴力解法 DFS backtracking
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (inBoard(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean inBoard(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder path = new StringBuilder();
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(dfsSearch(board, word, 0, i, j, visited)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean dfsSearch(char[][] board, String target, int index, int x, int y, boolean[][] visited) {
        //找到了结果，应该放在查越界前面
        if (index == target.length()) {
            return true;
        }

        //bug, 越界处理应该放在最前面
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (visited[x][y] == true) {
            return false;
        }

        if (board[x][y] != target.charAt(index)) {
            return false;
        }

        int[] diff = new int[] {1, 0 , -1, 0, 1};
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (dfsSearch(board, target, index + 1, x + diff[i], y + diff[i + 1], visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    //Trie tree + dfs backtracking
    public List<String> findWords2(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode treeRoot = createTrieTree(words);

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfsSearch(board, i, j, treeRoot, sb, result, visited);
            }
        }
        return result;

    }

    private void dfsSearch(char[][] board,
                           int x,
                           int y,
                           TrieNode root,
                           StringBuilder sb,
                           List<String> result,
                           boolean[][] visited) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) {
            return;
        }
        char currentChar = board[x][y];
        if (root.children[currentChar - 'a'] == null) {
            return;
        }

        root = root.children[currentChar - 'a'];
        sb.append(currentChar);
        if (root.isWord) {
            result.add(sb.toString());
            root.isWord = false;
        }

        visited[x][y] = true;
        int[] diff = new int[] {1, 0, -1, 0 ,1};
        for (int i = 0; i < 4; i++) {
            dfsSearch(board, x + diff[i], y + diff[i + 1], root, sb, result, visited);
        }
        visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private TrieNode createTrieTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode child = current.children[word.charAt(i) - 'a'];
                if (child == null) {
                    child = new TrieNode();
                    current.children[word.charAt(i) - 'a'] = child;
                }
                current = child;
            }
            current.isWord = true;
        }
        return root;
    }

    class TrieNode {
        public TrieNode[] children;
        public boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
