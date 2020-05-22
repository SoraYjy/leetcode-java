package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. Majority Element II
 * https://leetcode-cn.com/problems/majority-element-ii/
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> exist = new HashMap<>();
        int maxTimes = nums.length / 3;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            Integer times = exist.get(num);
            if (times == null) {
                times = 0;
            }
            ++times;
            if (times > maxTimes && !res.contains(num)) {
                res.add(num);
            }
            exist.put(num, times);
        }
        return res;
    }

    /**
     * Boyer-Moore Majority Vote
     * @param nums
     * @return
     */
    public List<Integer> majorityElementOptimized(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length < 3) {
            for (int i = 0; i < nums.length; ++i) {
                if (!res.contains(nums[i])) {
                    res.add(nums[i]);
                }
            }
            return res;
        }
        int count1 = 0, candidate1 = 0, count2 = 0, candidate2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num == candidate1) {
                ++count1;
                continue;
            }
            if (num == candidate2) {
                ++count2;
                continue;
            }
            if (count1 == 0) {
                // 1 的票数没了， 更换候选人
                candidate1 = num;
                count1 = 1;
                continue;
            }
            if (count2 == 0) {
                // 2 的票数没了， 更换候选人
                candidate2 = num;
                count2 = 1;
                continue;
            }
            --count1;
            --count2;
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == candidate1) {
                ++count1;
            } else if (nums[i] == candidate2) {
                ++count2;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
