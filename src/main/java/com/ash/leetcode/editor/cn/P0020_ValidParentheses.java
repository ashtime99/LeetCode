package com.ash.leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4426 👎 0

import java.util.*;

/**
 * P0020.有效的括号
 *
 * @author ash
 * @since 2024-04-18 14:11:15
 */
public class P0020_ValidParentheses{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 1.没数据或为奇数的直接返回空
        if (s.length()%2!=0){
            return false;
        }
        // 2.把各个字符的对应关系存起来
        Map<Character,Character> map=new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        // 3.用队列存数据
        Deque<Character> stack=new LinkedList<>();
        // 4.遍历字符串，遇到左括号入队，遇到右括号，判断栈首元素是否对应，对应即弹出队列
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty() || stack.peek()!=map.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0020_ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
    }
}
