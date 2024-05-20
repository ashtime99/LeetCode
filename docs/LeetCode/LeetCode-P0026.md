---
title: LeetCode-P0026
date: 2024-04-18 15:08:04
categories: "LeetCode"
tags: ["LeetCode","数组","双指针"]
---

## 题目

> [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)
>
> 给你一个 **非严格递增排列** 的数组 `nums` ，请你**[ 原地](http://baike.baidu.com/item/原地算法)** 删除重复出现的元素，使每个元素 **只出现一次** ，返回删除后数组的新长度。元素的 **相对顺序** 应该保持 **一致** 。然后返回 `nums` 中唯一元素的个数。
>
> 考虑 `nums` 的唯一元素的数量为 `k` ，你需要做以下事情确保你的题解可以被通过：
>
> - 更改数组 `nums` ，使 `nums` 的前 `k` 个元素包含唯一元素，并按照它们最初在 `nums` 中出现的顺序排列。`nums` 的其余元素与 `nums` 的大小不重要。
> - 返回 `k` 。
>
> **判题标准:**
>
> 系统会用下面的代码来测试你的题解:
>
> ```
> int[] nums = [...]; // 输入数组
> int[] expectedNums = [...]; // 长度正确的期望答案
> 
> int k = removeDuplicates(nums); // 调用
> 
> assert k == expectedNums.length;
> for (int i = 0; i < k; i++) {
>     assert nums[i] == expectedNums[i];
> }
> ```
>
> 如果所有断言都通过，那么您的题解将被 **通过**。
>
>  
>
> **示例 1：**
>
> ```
> 输入：nums = [1,1,2]
> 输出：2, nums = [1,2,_]
> 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
> ```
>
> **示例 2：**
>
> ```
> 输入：nums = [0,0,1,1,1,2,2,3,3,4]
> 输出：5, nums = [0,1,2,3,4]
> 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
> ```
>
>  
>
> **提示：**
>
> - `1 <= nums.length <= 3 * 104`
> - `-104 <= nums[i] <= 104`
> - `nums` 已按 **非严格递增** 排列

## 思路

`非严格递增：序列中的元素从小到大排列，但允许元素之间存在重复`

看题，我们只要把重复的元素往后移，保证前面的数顺序不重复即可。

这题用快慢指针去解决问题：

慢指针：符合条件元素最后的值

快指针：去找不重复的值

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0;
        int fast=1;
        while (fast<nums.length){
            if (nums[fast]!=nums[slow]){
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow+1;
    }
}
```

