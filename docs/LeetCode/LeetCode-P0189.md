---
title: LeetCode-P0189
date: 2024-04-18 15:08:04
categories: "LeetCode"
tags: ["LeetCode","数组"]
---

## 题目

> [189. 轮转数组](https://leetcode.cn/problems/rotate-array/)
>
> 给定一个整数数组 `nums`，将数组中的元素向右轮转 `k` 个位置，其中 `k` 是非负数。
>
>  
>
> **示例 1:**
>
>  ```
>输入: nums = [1,2,3,4,5,6,7], k = 3
> 输出: [5,6,7,1,2,3,4]
>解释:
> 向右轮转 1 步: [7,1,2,3,4,5,6]
> 向右轮转 2 步: [6,7,1,2,3,4,5]
> 向右轮转 3 步: [5,6,7,1,2,3,4]
> ```
> 
> **示例 2:**
>
> ```
>输入：nums = [-1,-100,3,99], k = 2
> 输出：[3,99,-1,-100]
> 解释: 
> 向右轮转 1 步: [99,-1,-100,3]
> 向右轮转 2 步: [3,99,-1,-100]
> ```
> 
> 
> 
>**提示：**
> 
> - `1 <= nums.length <= 105`
> - `-231 <= nums[i] <= 231 - 1`
> - `0 <= k <= 105`

## 思路

1. 把需要转动的数组，用另一个数组接收，
2. 再把旧数组往右迁移，
3. 最后把转动的数组赋值到旧数组的前面

注意 `k>数组长度` 的情况

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[k];
        int m = 0;
        if (k > n) {
            k = k % n;
        }
        for (int i = n - k; i < n; i++) {
	        arr[m] = nums[i];
            m++;
        }
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
	            nums[i] = arr[i];
        }
    }
}
```

