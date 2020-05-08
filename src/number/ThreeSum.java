package number;

import utils.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 15. 3Sum
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    /**
     * 先排序，再用双指针从头尾开始遍历查找解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int left, right;
        int length = nums.length;
        if (length < 3) {
            return res;
        }
        Sort.quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < length - 2; ++i) {
            // 如果当前数大于 0，则后续的不用遍历了
            if (nums[i] > 0) {
                break;
            }
            // 如果当前数和前一个数重复，则跳过，避免结果集中出现重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(nums[i]);
                    solution.add(nums[left]);
                    solution.add(nums[right]);
                    res.add(solution);

                    // 如果 left 与 right 的指针与下一个重复，则跳过，这样可过滤掉重复解
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    // 如果太大，则左移右指针
                    // 这里过滤不过滤无所谓，反正相等的也构不成解
                    --right;
                } else {
                    // 同上
                    ++left;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
//        int[] a = {-1, 1, 0, 2, 3, -5, 10, -13};
        int[] a = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(a);
        System.out.println(res);


    }
}
