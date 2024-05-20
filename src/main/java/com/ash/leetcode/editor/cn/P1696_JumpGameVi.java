package com.ash.leetcode.editor.cn;

//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, 
//i + k)] 包含 两个端点的任意位置。 
//
// 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。 
//
// 请你返回你能得到的 最大得分 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,-2,4,-7,3], k = 2
//输出：7
//解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,-5,-2,4,0,3], k = 3
//输出：17
//解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 队列 数组 动态规划 单调队列 堆（优先队列） 👍 186 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * P1696.跳跃游戏 VI
 *
 * @author ash
 * @since 2024-02-05 17:11:26
 */
public class P1696_JumpGameVi{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxResult(int[] nums, int k) {
        //动规五部曲：
        // 1.确定dp数组以及下标的含义：dp[n],最后一步的答案是dp[n-1]
        // 2.确定递推公式：dp[i] = MAX{dp[i-1]};
        // 3.dp数组如何初始化：dp[0] = nums[0]
        // 4.确定遍历顺序：从前往后
        // 5.举例推导dp数组 1、2、3、5、8、
        int n=nums.length;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1696_JumpGameVi().new Solution();
    }
}
