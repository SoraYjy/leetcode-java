package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> existMap = new HashMap<>();
        int maxTimes = 0, maxKey = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            Integer times = existMap.get(num);
            if (times == null) {
                times = 0;
            }
            ++times;
            if (times >= maxTimes) {
                maxTimes = times;
                maxKey = num;
            }
            existMap.put(num, times);
        }
        return maxKey;
    }

    /**
     * Boyer-Moore Majority Vote
     */
    public int majorityElementOptmize(int[] nums) {
        int cardNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == cardNum) {
                ++count;
            } else if (count <= 0) {
                cardNum = nums[i];
                count = 1;
            } else {
                --count;
            }
        }
        return cardNum;
    }
}
