package com.ash.leetcode.editor.cn;

//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 734 👎 0

import java.util.HashMap;

/**
 * P0387.字符串中的第一个唯一字符
 *
 * @author ash
 * @since 2024-04-21 16:21:44
 */
public class P0387_FirstUniqueCharacterInAString{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }

        for (int i = 0; i < n; i++) {
            char ch=s.charAt(i);
            if (map.get(ch)==1){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0387_FirstUniqueCharacterInAString().new Solution();
    }
}
