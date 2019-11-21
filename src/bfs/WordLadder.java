package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        if(start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        return bfs(start, end, dict);
    }

    private int bfs(String start, String end, Set<String> dict) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        int length = 1;
        while (queue.size() != 0) {
            length++;
            int size = queue.size();
            //order level bfs
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {		//枚举替换位置
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

}
