package com.ash.leetcode.editor.cn;

//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1037 👎 0

import java.util.Deque;
import java.util.LinkedList;

/**
 * P0402.移掉 K 位数字
 *
 * @author ash
 * @since 2024-04-18 18:16:23
 */
public class P0402_RemoveKDigits{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if (n<=k){
            return "0";
        }
        // 1.栈
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // k有值，如果栈里有元素，且数字比当前数字大，就可以把出栈，丢掉
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k>0){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        // 移除k剩下的
        for (int i = 0; i < k; i++) {
            stack.poll();
        }
        // 拼接字符
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        // 去除前导0
        int i=0;
        while (i<sb.length()-1 && sb.charAt(i)=='0'){
            i++;
        }
        return sb.substring(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0402_RemoveKDigits().new Solution();
        System.out.println(solution.removeKdigits("1234567890", 9));
    }
}
