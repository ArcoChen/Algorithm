package org.example;

/**
 * @author huangjiachang
 * @date 2023/7/8
 */
public class ToThePowerOfX {

    /**
     * 求x的n次方
     */

    public static void main(String[] args) {
        System.out.println(getPower(2, 3));
        System.out.println(getPowerRecursion(2, 3));
        System.out.println(getPowerRecursion1(2,3));
    }

    /**
     * 首先能想到的for循环，每次都乘以x，该方案的时间复杂度为O(n)
     */
    public static int getPower(int x, int n) {
        int result = 1;

        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * 通过迭代的方式 该方式，时间复杂度也是O(n)
     */
    public static int getPowerRecursion(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return getPowerRecursion(x, n - 1) * x;
    }

    public static int getPowerRecursion1(int x, int n) {
        if (n == 0) {
            return 1;
        }

        // 相对于getPowerRecursion，把递归抽取了出来
        int t = getPowerRecursion1(x, n / 2);
        if (n % 2 == 1) {
            return t * t * x;
        }

        return t * t;
    }
}
