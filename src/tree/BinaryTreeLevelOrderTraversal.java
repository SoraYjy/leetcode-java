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
}
