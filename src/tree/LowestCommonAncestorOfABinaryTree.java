package tree;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {
    private List<TreeNode> pPath;
    private List<TreeNode> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        List<TreeNode> path = new ArrayList<>();
        find(root, path, p, q);
        int i = 0;
        while (i < pPath.size() && i < qPath.size() && pPath.get(i).val == qPath.get(i).val) {
            ++i;
        }
        return pPath.get(i - 1);
    }

    private void find(TreeNode node, List<TreeNode> path, TreeNode p, TreeNode q) {
        if (node == null) return;
        path.add(node);
        if (node.val == p.val) {
            pPath = clonePath(path);
        }
        if (node.val == q.val) {
            qPath = clonePath(path);
        }
        find(node.left, path, p, q);
        find(node.right, path, p, q);
        path.remove(path.size() - 1);
    }

    private List<TreeNode> clonePath(List<TreeNode> path) {
        List<TreeNode> newPath = new ArrayList<>();
        for (int i = 0; i < path.size(); ++i) {
            newPath.add(path.get(i));
        }
        return newPath;
    }

    /**
     * from:
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorLastOrderRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
