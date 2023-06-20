package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 *
 */
public class MinimumWindow {
  public String minWindow(String s, String t) {
    Map<Character, Integer> window = new HashMap<>();
    Map<Character, Integer> needs = new HashMap<>();

    for (int i = 0; i < t.length(); ++i) {
      needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
    }

    // 左开右闭的窗口
    int left = 0, right = 0;
    // 需要满足的字符个数
    int valid = 0;
    int start = 0;
    int len = Integer.MAX_VALUE;

    while (right < s.length()) {
      ++right;
      char c = s.charAt(right);

      // 窗口变大，进行 map 变化
      if (needs.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c).equals(needs.get(c))) {
          ++valid;
        }
      }

      // 判断是否需要收缩
      while (valid == needs.size()) {
        // 只有 valid 合理是更新结果
        if (right - left < len) {
          len = right - left;
          start = left;
        }

        // 缩小窗口
        char pre = s.charAt(left);
        ++left;

        // 如果缩小时删掉的是需要的
        if (needs.containsKey(pre)) {
          // 如果某个字母数是目前符合状态
          if (window.get(pre).equals(needs.get(pre))) {
            --valid;
          }
          window.put(pre, window.get(pre) - 1);
        }
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

  }

}
