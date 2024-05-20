package com.ash.leetcode.editor.cn;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1740 👎 0

import java.util.*;

/**
 * P0049.字母异位词分组
 *
 * @author ash
 * @since 2023-11-29 15:19:29
 */
public class P0049_GroupAnagrams{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int sum=0;
        List<List<String>> ans=new ArrayList<>();
        Map<String,Integer> hash=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s=String.valueOf(c);
            if(hash.containsKey(s)){
                ans.get(hash.get(s)).add(strs[i]);
            }else{
                hash.put(s,sum);
                List<String> add=new ArrayList<>();
                add.add(strs[i]);
                ans.add(add);
                sum++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0049_GroupAnagrams().new Solution();
    }
}
