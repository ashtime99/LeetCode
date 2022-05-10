---
title: "剑指Offer11-旋转数组的最小数字"
date: 2022-05-09 14:04:29
updated: 2022-05-09 14:04:29
categories: ["LeetCode"]
tags: [""]
---

[[LeetCode目录]]

## ✏️ 题目

[剑指 Offer 11. 旋转数组的最小数字](https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

## 💡 解题报告

### 1. 思路分析

不用想复杂，直接找最小元素即可

### 2. 复杂度

时间复杂度：$O(n)$:只需要一次遍历，就能找到最小的数
空间复杂度：$O(1)$

### 3. 代码详解

步骤：

```java
class Solution {
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int num : numbers) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
}
```

## 🔑 总结

总结

## 🍎 回顾

回顾
