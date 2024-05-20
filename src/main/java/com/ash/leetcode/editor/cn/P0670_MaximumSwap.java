package com.ash.leetcode.editor.cn;

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 451 👎 0

/**
 * P0670.最大交换
 *
 * @author ash
 * @since 2024-01-22 18:29:12
 */
public class P0670_MaximumSwap{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n=chars.length;
        int max=num;
        for (int i = 0; i < n; i++) {
            for (int j=i+1; j < n; j++) {
                // 换
                swap(chars,i,j);
                max=Math.max(max,Integer.parseInt(new String(chars)));
                // 换回来
                swap(chars,i,j);
            }
        }
        return max;
    }

    public void swap(char[] chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0670_MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(100000000));
    }
}
