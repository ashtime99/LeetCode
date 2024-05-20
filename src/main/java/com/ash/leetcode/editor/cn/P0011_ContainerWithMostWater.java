package com.ash.leetcode.editor.cn;

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4706 👎 0

/**
 * P0011.盛最多水的容器
 *
 * 双指针
 *
 * @author ash
 * @since 2023-11-28 16:59:22
 */
public class P0011_ContainerWithMostWater{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            int max=Math.min(height[left], height[right])*(right-left);
            if (max>ans){
                ans=max;
            }else {
                if (height[left]>height[right]){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new P0011_ContainerWithMostWater().new Solution();
    }
}
