package array;

/**
 * 152. Maximum Product Subarray
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int product = nums[i];
            max = max > product ? max : product;
            for (int j = i + 1; j < nums.length; ++j) {
                product = product * nums[j];
                max = max > product ? max : product;
                if (product == 0) {
                    break;
                }
            }
        }
        return max;
    }

    public int maxProductDp(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int cur = nums[i];
            int curProductMax = dpMax[i - 1] * cur;
            int curProductMin = dpMin[i - 1] * cur;
            dpMax[i] = max(curProductMax, max(curProductMin, cur));
            dpMin[i] = min(curProductMin, min(curProductMax, cur));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dpMax.length; ++i) {
            max = max(max, dpMax[i]);
        }
        return max;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProductDp(arr));
    }
}

