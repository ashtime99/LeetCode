package com.ash.leetcode.editor.cn;

//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 731 👎 0

/**
 * P0509.斐波那契数
 *
 * @author ash
 * @since 2024-01-11 19:46:10
 */
public class P0509_FibonacciNumber{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        //动规五部曲：
        // 1.确定dp数组以及下标的含义：dp[i],第i个数的斐波那契数值是dp[i]
        // 2.确定递推公式：dp[i] = dp[i - 1] + dp[i - 2];
        // 3.dp数组如何初始化：dp[0] = 0;dp[1] = 1;
        // 4.确定遍历顺序：从公式可以知道从前往后
        // 5.举例推导dp数组：0、1、1、2、3、5、8、13、21、34、55
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0509_FibonacciNumber().new Solution();
    }
}