package tree;

import tree.model.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    /**
     * 递归遍历
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left) + 1;
        int rightHeight = maxDepth(root.right) + 1;
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}
