package com.ash.leetcode.editor.cn;

//根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞
// （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡； 
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活； 
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡； 
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活； 
// 
//
// 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返
//回下一个状态。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// 
//
// 示例 2： 
// 
// 
//输入：board = [[1,1],[1,0]]
//输出：[[1,1],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 25 
// board[i][j] 为 0 或 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 605 👎 0

/**
 * P0289.生命游戏
 *
 * @author ash
 * @since 2024-05-17 16:22:01
 */
public class P0289_GameOfLife{
    
    public static void main(String[] args) {
        Solution solution = new P0289_GameOfLife().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)

}
