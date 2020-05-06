package tree;

import tree.model.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Created by yujingyi on 2020-05-06.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * 从根节点遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode commonNode = root, pNode = root, qNode = root;
        while (pNode.val != p.val && qNode.val != q.val) {
            pNode = p.val > pNode.val ? pNode.right : pNode.left;
            qNode = q.val > qNode.val ? qNode.right : qNode.left;
            if (pNode.val == qNode.val) {
                commonNode = pNode;
            }
        }
        return commonNode;
    }
}
