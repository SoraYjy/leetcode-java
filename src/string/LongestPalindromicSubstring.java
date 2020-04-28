package string;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 */
public class LongestPalindromicSubstring {
    /**
     * Use dp.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int left = 0, right = 0;
        for (int i = length - 2; i >= 0; --i) {
            for (int j = i; j < length; ++j) {
                // 相等时才进入前一个解是否为回文的判断
                if (s.charAt(i) == s.charAt(j)) {
                    // 如果子串长度为 1 或者 2，直接可以确定是否为回文
                    // 大于 2 时才去判断之前的解
                    if (j - i + 1 <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        // 最长时，替代之前的记录
                        if (j - i > right - left) {
                            left = i;
                            right = j;
                        }
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String a = "a";
        System.out.println(a.substring(0, 0));
        System.out.println(a.substring(0, 1));
    }
}
