package com.ash.leetcode.editor.cn;

// 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
// 返回其根节点。
//
// 
//
// 示例 1: 
// 
// 
// 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// 输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
// 输入: preorder = [-1], inorder = [-1]
// 输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2232 👎 0

import java.util.Arrays;

/**
 * P0105.从前序与中序遍历序列构造二叉树
 *
 * @author ash
 * @since 2024-02-20 17:08:23
 */
public class P0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            // 根据前序数组第一个元素，就可以确定根节点
            TreeNode root = new TreeNode(preorder[0]);
            for (int i = 0; i < inorder.length; i++) {
                // 去中序数组找根结点的位置
                if (preorder[0] == inorder[i]) {
                    // 前面的数组为左子树结点的前序
                    int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                    // 后面的数组为右子树结点的前序
                    int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                    // 中序数组分，前面的数组为左子树结点的中序
                    int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                    // 中序数组分，后面的数组为右子树结点的中序
                    int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                    root.left = buildTree(pre_left, in_left);
                    root.right = buildTree(pre_right, in_right);
                    break;
                }
            }
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P0105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
}
