package org.example;

/**
 * 剑指 Offer 05. 替换空格
 *
 * @author huangjiachang
 * @date 2023/7/10
 */
public class ReplaceBlankSpace {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */

    /**
     * 思考
     * <p>
     * 1. new一个StringBuffer,循环字符串s，当遇到空格，则append '%20'，否则append 原char
     * <p>
     * 2. 双指针法，遍历字符串s，得到s中包含的空格个数，再申请字符串s长度(k)+2*空格数的空间， 从字符串的最右边，对新的字符数组进行填充
     */

    public static void main(String[] args) {
        String s = " Hello world!";
        System.out.println(replaceBlankSpace2(s));
    }

    /**
     * 利用StringBuilder，当遇到空格，则append '%20'，否则，append 原char
     */
    public static String replaceBlankSpace(String s) {
        if (s.length() == 0) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char str : arr) {
            if (' ' == str) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(str);
            }
        }
        return new String(stringBuilder);
    }

    /**
     * 双指针
     */
    public static String replaceBlankSpace2(String s) {
        int replaceBlankSpaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                replaceBlankSpaceNum++;
            }
        }

        if (replaceBlankSpaceNum == 0) {
            return s;
        }

        char[] arr = new char[s.length() + 2 * replaceBlankSpaceNum];
        int slow = s.length() - 1;
        int fast = arr.length - 1;
        char[] origin = s.toCharArray();

        while (slow >= 0) {
            if (origin[slow] == ' ') {
                arr[fast--] = '0';
                arr[fast--] = '2';
                arr[fast] = '%';
            } else {
                arr[fast] = origin[slow];
            }
            slow--;
            fast--;
        }
        return new String(arr);
    }
}
