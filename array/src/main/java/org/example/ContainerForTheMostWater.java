package org.example;

/**
 * leetcode 11 盛最多水的容器
 *
 * @author huangjiachang
 * @date 2023/7/10
 */
public class ContainerForTheMostWater {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7] 输出：49
     * <p>
     * 输入：height = [1,1] 输出：1
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2};
        System.out.println(maxArea(nums));
    }

    /**
     * 双指针法
     */
    public static int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
