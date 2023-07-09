package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    boolean used[];
    int size;

    List<Integer> current = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute1(int[] nums) {
        size = nums.length;
        used = new boolean[size];

        dfs(nums, 0);
        return result;
    }

    public void dfs(int[] nums, int depth) {
        // 最深 存放结果
        if (depth == size) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < size; ++i) {
            // 如果未使用过
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                dfs(nums, ++depth);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

}
