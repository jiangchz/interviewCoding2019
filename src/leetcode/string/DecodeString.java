package leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        Deque<String> prefixStack = new LinkedList<String>();
        Deque<Integer> counterStack = new LinkedList<Integer>();
        int index = 0;
        String result = "";
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '[' ) {
                prefixStack.push(result.toString());
                result = "";
                index++;
            } else if (Character.isDigit(c)) {
                int counter = 0;
                while (Character.isDigit(s.charAt(index))) {
                    counter = 10 * counter + (s.charAt(index) - '0');
                    index++;
                }
                counterStack.push(counter);
            } else if (Character.isLetter(c)) {
                result += c;
                index++;
            } else {
                StringBuilder temp = new StringBuilder(prefixStack.pop());
                int repeatTimes = counterStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(result);
                }
                result = temp.toString();
                index++;
            }
        }
        return result;
    }
}
/*
 1.使用两个栈，countStack存子串的重复次数，resStack存中间结果
  2.读取完一个数字，把数量入countStack栈
  3.读取到[时，把n[前面的结果计算出来并入resStack栈
  4.读取到]时，取出最近一次n[res]前面的中间计算结果，也就是resStack的栈顶，再append n次res，n为countStack的栈顶，res为最近一次[]中间的子串
  5.其他情况，将字符追加到res末尾

  比如:  3[a]2[b3[d]c]
 下面是读完各字符时的情况：
 *        读完:  3    [     a     ]     2    [    b      3       [      d       ]      c       ]
 * countStack: (3)  (3)   (3)    ()   (2)  (2)  (2)   (2 3)   (2 3)   (2 3)   (2)    (2)      ()
 *   resStack: ()   ("")  ("")   ()   ()  (aaa) (aaa) (aaa)  (aaa b) (aaa b)  (aaa) (aaa)     ()
 *        res: ""    ""    a     aaa  aaa   ""   b      b       ""     d      bddd  bdddc  aaabdddcbdddc
 */