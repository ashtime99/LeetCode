package com.ash.leetcode.editor.cn;

//给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。 
//
// 
//
// 示例 1： 
//
// 
//输入：date = "2019-01-09"
//输出：9
//解释：给定日期是2019年的第九天。 
//
// 示例 2： 
//
// 
//输入：date = "2019-02-10"
//输出：41
// 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日 
// 
//
// Related Topics 数学 字符串 👍 135 👎 0

/**
 * P1154.一年中的第几天
 *
 * @author ash
 * @date 2023-12-31 19:40:32
 */
public class P1154_DayOfTheYear{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dayOfYear(String date) {
        int[] mouth={31,28,31,30,31,30,31,31,30,31,30,31};
        String[] split = date.split("-");
        int ans=0;
        for (int i=1;i<Integer.valueOf(split[1]);i++){
            ans+=mouth[i-1];
        }
        // 能被4整除，能被400整除的是闰年，加一天
        if ((Integer.valueOf(split[0])%4==0 && Integer.valueOf(split[0])%100!=0) || Integer.valueOf(split[0])%400==0){
            if (Integer.valueOf(split[1])>2){
                ans++;
            }
        }
        ans+=Integer.valueOf(split[2]);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P1154_DayOfTheYear().new Solution();
        System.out.println(solution.dayOfYear("2000-12-04"));
    }
}
