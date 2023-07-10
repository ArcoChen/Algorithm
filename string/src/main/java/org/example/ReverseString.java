package org.example;

/**
 * leetcode 344 反转字符串
 *
 * @author huangjiachang
 * @date 2023/7/10
 */
public class ReverseString {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * <p>
     * 输入：s = ["h","e","l","l","o"] 输出：["o","l","l","e","h"]
     * <p>
     * 输入：s = ["H","a","n","n","a","h"] 输出：["h","a","n","n","a","H"]
     */

    /**
     * 思考
     * <p>
     * 双指针法，定义一个头部指针left,定义一个尾部指针right,每次交换这两个指针对应位置的元素
     * 交换完成后，left向后移动一位，right向前移动一位，直至两个指针相遇
     */

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        reverseString(arr);
        for (char str :
            arr) {
            System.out.println(str);
        }
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
