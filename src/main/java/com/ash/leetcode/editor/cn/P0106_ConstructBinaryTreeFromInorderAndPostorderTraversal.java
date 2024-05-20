package com.ash.leetcode.editor.cn;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1180 👎 0

import java.util.Arrays;

/**
 * P0106.从中序与后序遍历序列构造二叉树
 *
 * @author ash
 * @since 2024-02-21 10:16:40
 */
public class P0106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        // 根据后序数组最后一个元素，可以确定根节点
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for (int i = 0; i < inorder.length; i++) {
            // 去中序数组找根结点的位置
            if (postorder[postorder.length-1] == inorder[i]) {
                // 前面的数组为左子树结点的后序
                int[] post_left = Arrays.copyOfRange(postorder, 0, i );
                // 后面的数组为右子树结点的后序
                int[] post_right = Arrays.copyOfRange(postorder, i, postorder.length-1);
                // 中序数组分，前面的数组为左子树结点的中序
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                // 中序数组分，后面的数组为右子树结点的中序
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(in_left,post_left);
                root.right = buildTree(in_right,post_right);
                break;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        System.out.println(solution.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3}));
    }
}
