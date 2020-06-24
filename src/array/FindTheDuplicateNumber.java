package array;

/**
 * 287. Find the Duplicate Number
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 2) return nums[0];
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) {
                    return nums[j];
                }
            }
        }
        return nums[nums.length - 1];
    }
}
