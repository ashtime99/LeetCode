package com.ash.leetcode.editor.cn;

// 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [1,2,3,4,5,6,7], k = 3
// 输出: [5,6,7,1,2,3,4]
// 解释:
// 向右轮转 1 步: [7,1,2,3,4,5,6]
// 向右轮转 2 步: [6,7,1,2,3,4,5]
// 向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
// 输入：nums = [-1,-100,3,99], k = 2
// 输出：[3,99,-1,-100]
// 解释:
// 向右轮转 1 步: [99,-1,-100,3]
// 向右轮转 2 步: [3,99,-1,-100]
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// Related Topics 数组 数学 双指针 👍 2157 👎 0

/**
 * P0189.轮转数组
 *
 * @author ash
 * @since 2024-05-13 16:38:02
 */
public class P0189_RotateArray {

    public static void main(String[] args) {
        Solution solution = new P0189_RotateArray().new Solution();
    }
// leetcode submit region end(Prohibit modification and deletion)

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] arr = new int[k];
            int m = 0;
            if (k > n) {
                k = k % n;
            }
            for (int i = n - k; i < n; i++) {
                arr[m] = nums[i];
                m++;
            }
            for (int i = n - 1; i >= k; i--) {
                nums[i] = nums[i - k];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = arr[i];
            }
        }
    }
}