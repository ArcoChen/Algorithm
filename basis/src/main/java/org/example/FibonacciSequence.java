package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangjiachang
 * @date 2023/7/8
 */
public class FibonacciSequence {

    public static void main(String[] args) {

    }

    public static int getFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return getFibonacci(n - 1) * getFibonacci(n - 2);
    }
}
