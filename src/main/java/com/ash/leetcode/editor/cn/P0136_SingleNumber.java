package com.ash.leetcode.editor.cn;

// 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
// 输入：nums = [2,2,1]
// 输出：1
// 
//
// 示例 2 ： 
//
// 
// 输入：nums = [4,1,2,1,2]
// 输出：4
// 
//
// 示例 3 ： 
//
// 
// 输入：nums = [1]
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// Related Topics 位运算 数组 👍 3066 👎 0

/**
 * P0136.只出现一次的数字
 *
 * @author ash
 * @since 2023-12-14 16:13:31
 */
public class P0136_SingleNumber {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // public int singleNumber(int[] nums) {
        //     int[] n1 = new int[30005];
        //     int[] n2 = new int[30005];
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] < 0) {
        //             n2[Math.abs(nums[i])]++;
        //         } else {
        //             n1[nums[i]]++;
        //         }
        //
        //     }
        //     for (int i = 0; i < n1.length; i++) {
        //         if (n1[i] == 1) {
        //             return i;
        //         }
        //         if (n2[i] == 1) {
        //             return -i;
        //         }
        //     }
        //     return -1;
        // }

        public int singleNumber(int[] nums) {
            int ans = nums[0];
            if (nums.length > 1) {
                // 异或可以排除偶数重复，所以全部异或时只会留下唯一
                for (int i = 1; i < nums.length; i++) {
                    ans = ans ^ nums[i];
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new P0136_SingleNumber().new Solution();
    }
}
