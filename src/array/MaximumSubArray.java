package array;

/**
 * 53. Maximum Subarray
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class MaximumSubArray {
  public int maxSubArray(int[] nums) {
    // 每一项表示以 i 结尾的子序列，最大的和是多少
    // 无后效性
    int[] dp = new int[nums.length];
    dp[0] = nums[0];

    // 状态转移
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i - 1] > 0) {
        dp[i] = dp[i - 1] + nums[i];
      } else {
        dp[i] = nums[i];
      }
    }

    int max = dp[0];
    for (int i = 1; i < nums.length; ++i) {
      max = max >= dp[i] ? max : dp[i];
    }

    return max;
  }
}
