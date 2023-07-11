package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class LengthOfLongestSubstring {
    // 滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }


    /**
     * 硬遍历
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            System.out.println(s);
            return s.length();
        }
        int maxLength = 0;
        String subString = s.substring(0, 1);

        int cursor = 0;
        int end = 1;
        while (end < s.length()) {
            int dup = checkDup(s, cursor, end);
            if (dup < end) {
                // calculate current max length and sub string
                if (end - cursor > maxLength) {
                    maxLength = end - cursor;
                    subString = s.substring(cursor, end);
                }
                // duplicated, move cursor
                cursor = dup + 1;
            }
            // not duplicated, move end
            ++end;
        }
        // handle string end
        if (end - cursor > maxLength) {
            maxLength = end - cursor;
            subString = s.substring(cursor, end);
        }
        System.out.println(subString);
        return maxLength;
    }

    private int checkDup(String s, int cursor, int end) {
        while (cursor < end) {
            if (s.charAt(cursor) == s.charAt(end)) {
                return cursor;
            }
            cursor ++;
        }
        return end;
    }

    /**
     * use DP
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        if (s.length() <= 1) {
            System.out.println(s);
            return s.length();
        }
        int maxLength = 0;
        String subString = s.substring(0, 1);
        int cursor = 0;
        int end = 1;
        int[] dp = new int[256];
        for (int i = 0; i < 256; ++i) {
            dp[i] = -1;
        }
        dp[s.charAt(0)] = cursor;

        while (end < s.length()) {
            int exist = dp[s.charAt(end)];
            // 更新 end 位置的字符最近出现的位置
            dp[s.charAt(end)] = end;
            // 出现过该字符串的位置在 cursor 之后，说明当前子串中有重复
            if (exist >= cursor) {
                // calculate current max length and sub string
                if (end - cursor > maxLength) {
                    maxLength = end - cursor;
                    subString = s.substring(cursor, end);
                }
                // duplicated, move cursor
                cursor = exist + 1;
            }
            // not duplicated, move end
            ++end;
        }
        // handle string end
        if (end - cursor > maxLength) {
            maxLength = end - cursor;
            subString = s.substring(cursor, end);
        }
        System.out.println(subString);
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";
        String input4 = "au";
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(input1));
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(input2));
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(input3));
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(input4));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringOptimized(input1));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringOptimized(input2));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringOptimized(input3));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringOptimized(input4));
    }
}
