package org.example;

import com.alibaba.fastjson2.JSONObject;

/**
 * leetcode 27 移除元素
 *
 * @author huangjiachang
 * @date 2023/7/8
 */
public class removeElement {

    /**
     * 问题：
     *
     * 给你一个数组 nums 和一个值 val，你需要 原地移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */

    /**
     * 思考
     * <p>
     * 数组中的元素无法真正移除，只能靠后一个元素覆盖前一个元素，返回移除后的数组没有意义
     * <p>
     * 暴力解法，两层for循环，第一层遍历数组元素，第二层循环更新元素
     * <p>
     * 双指针法，用快慢指针
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 7};
        System.out.println(removeElement(nums, 2));
        System.out.println(removeElementTwoPoint(nums, 2));
    }

    /**
     * 暴力解法，两层for循环
     */
    public static int removeElement(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == target) {
                // 发现需要移除的元素，将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }

                // 因为下标i以后得值，都向前移动了一位，所以i也要向前移动一位
                i--;
                // 此时数组长度-1
                size--;
            }
        }
        return size;
    }

    /**
     * 通过一个个快指针和一个慢指针，在一个for循环内完成两个1br循环的工作
     */
    public static int removeElementTwoPoint(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != target) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
