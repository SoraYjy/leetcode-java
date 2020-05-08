package tree;

import tree.model.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInABST {

    private int n = 0;

    private int res = 0;
    /**
     * 中序遍历即为有序的数组
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        kthSmallest(root.left, k);
        ++n;
        // 保留第 k 大的值作为最终解
        if (n == k) {
            res = root.val;
        }
        kthSmallest(root.right, k);
        return res;

    }
}
