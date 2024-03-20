package leetcode.dynamicPrograming;

import java.util.Arrays;
import java.util.HashSet;

public class DictionaryGame1 {
    public boolean isInDictionary(String[] dic, String target) {
        HashSet<String> dictionary = new HashSet<>(Arrays.asList(dic));

        int size = target.length();
        boolean[] inDictionary = new boolean[size + 1];

        inDictionary[0] = true;
        for (int i = 1; i <= target.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(inDictionary[j] && dictionary.contains(target.substring(j, i))) { //前j个数包含在字典里，
                    // 第j + 1个数到 i包含在字典里 注意 这里是第J+1个数
                    inDictionary[i] = true;
                }
            }
        }
        return inDictionary[size];
    }
}

/*
Given a word, can it composed by concatenating words from a given dictionary?
dp[i]: 前i个字母组成的string是否包含在字典里

 */