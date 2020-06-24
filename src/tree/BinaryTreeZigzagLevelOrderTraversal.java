package tree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean positiveOrder = true;
        queue.offer(root);
        int levelSize = queue.size();
        while (levelSize > 0) {
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (positiveOrder) {
                    level.offer(node.val);
                } else {
                    level.addFirst(node.val);
                }
            }
            levelSize = queue.size();
            positiveOrder = !positiveOrder;
            res.add(level);
        }
        return res;
    }
}
