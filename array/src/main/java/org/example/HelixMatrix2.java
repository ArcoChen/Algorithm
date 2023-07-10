package org.example;

import com.alibaba.fastjson2.JSONObject;
import java.util.Vector;

/**
 * leetcode 59 螺旋矩阵2
 *
 * @author huangjiachang
 * @date 2023/7/9
 */
public class HelixMatrix2 {

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     *
     * 输入：n = 1
     * 输出：[[1]]
     */

    /**
     * 思考
     * <p>
     * 要坚持循环不变量原则
     * <p>
     * 矩阵的四条边都要坚持一致的左闭右开或者左开右闭的原则
     * <p>
     * 在拐角处开始画一条新的边
     */

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(generateMatrix(4)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, index = 1;
        while (index <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = index;
                index++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = index;
                index++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = index;
                index++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = index;
                index++;
            }
            left++;
        }

        return matrix;
    }
}
