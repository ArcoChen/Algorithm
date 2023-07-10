package org.example;

/**
 *
 * leetcode 541 反转字符串2
 *
 * @author huangjiachang
 * @date 2023/7/10
 */
public class reverseString2 {
    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
     *
     * 输入：s = "abcd", k = 2
     * 输出："bacd"
     */

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",3));
    }

    public static String reverseStr(String s, int k) {
        int index = s.length();
        char[] arr= s.toCharArray();
        for(int i = 0; i < index; i += 2 * k){
            reverse(arr, i, Math.min(i+k, index) - 1);
        }
        return new String(arr);
    }

    public static void reverse(char[] arr,int left,int right){
        if(arr.length == 0){
            return;
        }

        while(left < right){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
