package tree;

import tree.model.TreeNode;

import java.util.LinkedList;

/**
 * 662. Maximum Width of Binary Tree
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfBinaryTree {
    /**
     * Get in-order of the tree with non-node
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if (root == null) {
            return maxWidth;
        }
        LinkedList<TreeNode> inOrderQueue = new LinkedList<>();
        inOrderQueue.offer(root);
        int levelSize;
        boolean hasNextLevel = true;
        while (hasNextLevel) {
            hasNextLevel = false;
            levelSize = inOrderQueue.size();
            // non-nodes' head and tail of each level
            int head = -1, tail = -1;
            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = inOrderQueue.poll();
                if (node != null) {
                    hasNextLevel = true;
                    if (head == -1) {
                        // first non-node
                        head = i;
                        tail = i;
                    } else {
                        // update tail
                        tail = i;
                    }
                    inOrderQueue.offer(node.left);
                    inOrderQueue.offer(node.right);
                } else {
                    // dummy node
                    inOrderQueue.offer(null);
                    inOrderQueue.offer(null);
                }
            }
            int curWidth = tail - head + 1;
            maxWidth = curWidth > maxWidth ? curWidth : maxWidth;
        }
        return maxWidth;
    }

    /**
     * Get in-order of the tree with marking every node's position
     * @param root
     * @return
     */
    public int widthOfBinaryTreeMarkedPosition(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 1;
        LinkedList<TreeNodeWrapper> inOrderQueue = new LinkedList<>();
        inOrderQueue.offer(new TreeNodeWrapper(root, 1));
        int levelSize;
        while (inOrderQueue.size() > 0) {
            levelSize = inOrderQueue.size();
            int left = 0, right = 0;
            for (int i = 0; i < levelSize; ++i) {
                TreeNodeWrapper wrapper = inOrderQueue.poll();
                if (left == 0) {
                    left = wrapper.position;
                } else {
                    right = wrapper.position;
                }
                if (wrapper.node.left != null) {
                    inOrderQueue.offer(new TreeNodeWrapper(wrapper.node.left, wrapper.position * 2));
                }
                if (wrapper.node.right != null) {
                    inOrderQueue.offer(new TreeNodeWrapper(wrapper.node.right, wrapper.position * 2 + 1));
                }
                if (left > 0 && right - left + 1 > maxWidth) {
                    maxWidth = right - left + 1;
                }
            }
        }
        return maxWidth;
    }

    class TreeNodeWrapper {
        int position;
        TreeNode node;
        TreeNodeWrapper(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }
}
