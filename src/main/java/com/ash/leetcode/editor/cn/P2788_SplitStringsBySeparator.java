package com.ash.leetcode.editor.cn;

//给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。 
//
// 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。 
//
// 注意 
//
// 
// separator 用于决定拆分发生的位置，但它不包含在结果字符串中。 
// 拆分可能形成两个以上的字符串。 
// 结果字符串必须保持初始相同的先后顺序。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["one.two.three","four.five","six"], separator = "."
//输出：["one","two","three","four","five","six"]
//解释：在本示例中，我们进行下述拆分：
//
//"one.two.three" 拆分为 "one", "two", "three"
//"four.five" 拆分为 "four", "five"
//"six" 拆分为 "six" 
//
//因此，结果数组为 ["one","two","three","four","five","six"] 。 
//
// 示例 2： 
//
// 
//输入：words = ["$easy$","$problem$"], separator = "$"
//输出：["easy","problem"]
//解释：在本示例中，我们进行下述拆分：
//
//"$easy$" 拆分为 "easy"（不包括空字符串）
//"$problem$" 拆分为 "problem"（不包括空字符串）
//
//因此，结果数组为 ["easy","problem"] 。
// 
//
// 示例 3： 
//
// 
//输入：words = ["|||"], separator = "|"
//输出：[]
//解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号） 
// separator 是字符串 ".,|$#@" 中的某个字符（不包括引号） 
// 
//
// Related Topics 数组 字符串 👍 27 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * P2788.按分隔符拆分字符串
 *
 * @author ash
 * @since 2024-01-20 22:14:57
 */
public class P2788_SplitStringsBySeparator{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans=new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String s = String.valueOf(separator);
            if (separator== '.'){
                s="\\.";
            }
            if (separator== '$'){
                s="\\$";
            }
            if (separator== '|'){
                s="\\|";
            }
            if (separator== '*'){
                s="\\*";
            }
            String[] split = words.get(i).split(s);
            List<String> list = Arrays.asList(split);
            ans.addAll(list);
        }
        return ans.stream().filter(s -> s.length() > 0).collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P2788_SplitStringsBySeparator().new Solution();
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("one.two.three","four.five","six"), '.'));
    }
}