package com.ash.leetcode.editor.cn;

//给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。 
//
// 设计一个算法使得这 k 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], k = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], k = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], k = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= min(50, nums.length) 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 910 👎 0

import java.util.Arrays;

/**
 * P0410.分割数组的最大值
 *
 * @author ash
 * @since 2024-01-21 19:11:02
 */
public class P0410_SplitArrayLargestSum{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int k) {
        int n= nums.length;
        int[][]f=new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i],Integer.MAX_VALUE);
        }
        int[] sub=new int[n+1];
        for (int i = 0; i < n; i++) {
            sub[i+1]=sub[i]+nums[i];
        }
        f[0][0]=0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= Math.min(i,k); j++) {
                for (int l = 0; l < i; l++) {
                    f[i][j]=Math.min(f[i][j],Math.max(f[l][j-1],sub[i]-sub[l]));
                }
            }
        }
        return f[n][k];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0410_SplitArrayLargestSum().new Solution();
    }
}
