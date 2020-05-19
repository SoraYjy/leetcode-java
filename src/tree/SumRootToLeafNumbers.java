package tree;

import tree.model.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
    private int sum = 0;

    /**
     * 先序遍历树构造数字
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        firstOrder(0, root);
        return sum;
    }

    private void firstOrder(int preNumber, TreeNode node) {
        int curNum = preNumber * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += curNum;
        }
        if (node.left != null) {
            firstOrder(curNum, node.left);
        }
        if (node.right != null) {
            firstOrder(curNum, node.right);
        }
    }
}
