package org.example;

import com.alibaba.fastjson2.JSONObject;

/**
 * leetcode 27 加一
 *
 * @author huangjiachang
 * @date 2023/7/9
 */
public class PlusOne {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     *
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     *
     * 输入：digits = [0]
     * 输出：[1]
     */

    /**
     * 思考
     *
     * 需要判断数组的最后一个元素是否是9，如果是9，改数组的倒数第二个也要加1，同时也要判断这个数字是否是9，
     * 依次向前推
     *
     * 如果数组中的元素，都为9，则要增加数组长度，第一个元素职位1
     * @param args
     */

    public static void main(String[] args) {
        int[] nums=new int[]{0};
        System.out.println(JSONObject.toJSONString(plusOne(nums)));
    }



    public static int[] plusOne(int[] digits) {
        int index = digits.length;
        for(int i = index - 1; i > 0; i --){
            if(digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] result = new int[index + 1];
        result[0] = 1;
        return result;
    }
}
