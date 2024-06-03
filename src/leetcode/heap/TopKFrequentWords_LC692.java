package leetcode.heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords_LC692 {
    public List<String> topKFrequent(String[] words, int k) {

        //Step 1: count the word frequency with hashmap
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.putIfAbsent(word, 0);
            int currentCount = wordCount.get(word);
            wordCount.put(word, currentCount + 1);
        }

        //Step2: create a mean heap
        PriorityQueue<Word> minHeap = new PriorityQueue<Word>(k + 1, (w1, w2) -> {
            if (w1.count != w2.count) {
                return w1.count - w2.count;
            }
            return w2.content.compareTo(w1.content);
        });

        //step3: add words to the min head
        for (String word : wordCount.keySet()) {
            minHeap.add(new Word(word, wordCount.get(word)));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //step4: collect result
        LinkedList<String> result = new LinkedList<>();
        int size = k;
        while(size-- > 0) {
            result.addFirst(minHeap.poll().content);
        }

        return result;
    }

    private static class Word {
        public String content;
        public int count;
        public Word(String content, int count) {
            this.content = content;
            this.count = count;
        }
    }
}

/**
 *
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 */