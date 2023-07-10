package org.example;

import java.util.Arrays;

/**
 * leetcode 704 二分查找
 *
 * @author huangjiachang
 * @date 2023/7/8
 */
public class BinarySearch {

    /**
     * 问题：
     *
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target， 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 输入: nums = [-1,0,3,5,9,12], target = 9 输出: 4 解释: 9 出现在 nums 中并且下标为 4
     * <p>
     * 输入: nums = [-1,0,3,5,9,12], target = 2 输出: -1 解释: 2 不存在 nums 中因此返回 -1
     */

    /**
     * 思考
     * <p>
     * 二分查找，每次取中间的数mid
     * 如果mid>target,说明要查找的数据在mid的左边，只用查找左边的区间即可
     * 如果mid<target,说明要查找的数据在mid的右边，只用查找右边的区间即可
     * <p>
     * 二分法需要考虑清楚，在while循环中，用left<right,还是left<=right，这涉及到开闭区间的问题
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6, 7, 8};
        System.out.println(getBinarySearch(nums, 7));
        System.out.println(getBinarySearch1(nums, 7));
    }

    /**
     * 定义target在一个左闭右闭的区间，也就是［left,right]，这个搜索区间的定义非常重要。区间的
     * 定义决定了应该如何写二分法的代码。因为定义target在［left,right］区间,所以有如下两点:
     * <p>
     * 因为left与right相等的情况在［left,right］区间是有意义的,所以在while（left<=ght）中要使用<=
     * 如果num[mid]大于target，则更新搜索范围右下标right为mid-1，因为当前这个num[mid]一定不是target，
     * 所以接下来要查找的左区间结束下标的位置应该是mid-1
     */
    public static int getBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 防止溢出，等同于(left + right) / 2
            int mid = left + ((right - left) / 2);

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 定义target在一个左闭右开的区间，也就是［left,right)，这个搜索区间的定义非常重要。区间的
     * 定义决定了应该如何写二分法的代码。因为定义target在［left,right)区间,所以有如下两点:
     * <p>
     * while(left<right),这里使用<,是因为left==right的情况下，在[left,right)下没有意义
     * 如果nums[mid]大于target，则更新右下标right为mid。因为当前num[mid]不等于target，那么去左区间查找
     * 而区间是左闭右开的，所以right要更新为mid，即在下一次查询时，不会比较nums[mid]
     */
    public static int getBinarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }

        }

        return -1;
    }
}
