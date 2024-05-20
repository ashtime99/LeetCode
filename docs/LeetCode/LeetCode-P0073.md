---
title: LeetCode-P0073
date: 2024-04-18 15:08:04
categories: "LeetCode"
tags: ["LeetCode","矩阵"]
---

## 题目

> [73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/)

## 思路

用两个数组去存行列出现 0 的情况，再用遍历转 0

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i]=col[j]=true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}
```

