package tree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 层序遍历并且记录每层的节点数
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        int layerSize;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> layerRes = new ArrayList<>();
            // 该层的节点数
            layerSize = queue.size();
            // 一次完整的 for 循环便是遍历完了一层
            for (int i = 0; i < layerSize; ++i) {
                TreeNode node = queue.poll();
                layerRes.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(layerRes);
        }
        return res;
    }

    /**
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
     * 来源：力扣（LeetCode）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderRecur(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }
}
