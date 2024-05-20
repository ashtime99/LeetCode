---
title: LeetCode-P0289
date: 2024-05-20 15:26:51
updated: 2024-05-20 15:26:51
categories: LeetCode
tags:
  - LeetCode
---
## 题目

>[289. 生命游戏](https://leetcode.cn/problems/game-of-life/)

## 思路

这题主要是逻辑：

细胞的存活或死亡有两个规则

1. 活细胞周围有两个到三个不会死，超过或少于会死亡
2. 死细胞周围有三个活细胞，会复活

```java
class Solution {
    /**
     * 规则：活细胞周围有两个到三个不会死，超过或少于会死亡
     * 规则：死细胞周围有三个活细胞，会复活
     */
    public void gameOfLife(int[][] board) {
        int[] ner = new int[]{-1,0,1};

        int rows=board.length;
        int cols=board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 统计活细胞数量
                int sum=0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(ner[i] == 0 && ner[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + ner[i]);
                            int c = (col + ner[j]);
                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                sum += 1;
                            }
                        }
                    }
                }
                board[row][col]=isSurvival(board[row][col],sum);

            }
        }

        // 把结果恢复为1、0
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col]>0){
                    board[row][col]=1;
                }else {
                    board[row][col]=0;
                }
            }
        }

    }

    public int isSurvival(int old,int sum){
        if (old==1 && (sum!=2 && sum!=3)){
            // 原来活的现在死了
            return -1;
        }
        if (old==0 && sum==3){
            // 原来死的现在活了
            return 2;
        }
        return old;
    }
}
```