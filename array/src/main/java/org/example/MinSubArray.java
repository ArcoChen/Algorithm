package org.example;

import com.alibaba.fastjson2.JSONObject;

/**
 * leetcode 209 长度最小的子数组
 *
 * @author huangjiachang
 * @date 2023/7/8
 */
public class MinSubArray {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
     * 如果不存在符合条件的子数组，返回 0 。
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */

    /**
     * 思考
     * <p>
     * 暴力解法，双重for循环，时间复杂度为O(n^2)
     * <p>
     * 滑动窗口
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        //System.out.println(getMinSubArrayLength(nums, 7));
        System.out.println(getMinSubArrayLength1(nums, 7));
    }


    /**
     * 暴力解法，双层for循环
     */
    public static int getMinSubArrayLength(int[] nums, int target) {
        // 最终结果
        int result = Integer.MAX_VALUE;
        // 子数组的和
        int sum = 0;
        // 数组长度
        int size = nums.length;
        // 子数组的长度
        int subLength = 0;

        for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = i; j < size; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break;
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 滑动窗口
     */

    public static int getMinSubArrayLength1(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        // 滑动窗口的数之和
        int sum = 0;
        // 滑动窗口的起始位置
        int i = 0;
        // 滑动窗口的长度
        int subLength = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 每次更新更新i的位置（起始位置），并不断比较子数组是否符合条件
            while (sum >= target) {
                // 获取子数组长度
                subLength = j - i + 1;
                result = Math.min(result, subLength);
                sum -= nums[i];
                // 滑动窗口精髓，不断变更i(子数组的初始位置)
                i++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
