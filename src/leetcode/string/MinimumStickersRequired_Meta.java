package leetcode.string;

public class MinimumStickersRequired_Meta {
    public int minStickers(String sticker, String word) {
        int[] wordFreq = new int[26];
        for (char c : word.toCharArray()) {
            wordFreq[c - 'a']++;
        }

        int[] stickerFreq = new int[26];
        for (char c : sticker.toCharArray()) {
            stickerFreq[c - 'a']++;
        }

        int res = 0;

        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] == 0) {
                continue;
            }

            if (stickerFreq[i] == 0) {
                return -1;
            }
            int required = (int) Math.ceil(wordFreq[i]/stickerFreq[i]);
            res = Math.max(res, required);
        }
        return res;
    }
}

/**
 * Problem Description:
 * Given a string sticker that represents the set of characters available on a single sticker and a string word that represents the target word to spell out, return the minimum number of stickers that you need to spell out word. Each sticker can be used more than once, and you have an unlimited supply of stickers.
 * Meta version of https://leetcode.com/problems/stickers-to-spell-word/description/
 *
 * If the word cannot be spelled out using the letters on the sticker, return -1.
 *
 * Note:
 *
 * The sticker and word consist of lowercase English letters only.
 * The lengths of the sticker and word strings are both in the range [1, 1000].
 * Function Signature:
 *
 * public int minStickers(String sticker, String word) {
 * }
 * Example 1:
 * Input: sticker = "ban", word = "banana"
 * Output: 3
 * Explanation: We can use 3 stickers "bana" to spell out the word "banana". Each sticker provides one "b", one "a", and one "n". Three stickers provide all the letters needed to spell out "banana".
 *
 * Example 2:
 * Input: sticker = "abc", word = "def"
 * Output: -1
 * Explanation: The sticker does not contain any of the letters needed to spell out "def". Therefore, it is impossible to spell out the word.
 *
 * Constraints:
 * 1 <= sticker.length, word.length <= 1000
 * sticker and word consist of lowercase English letters.
 */
