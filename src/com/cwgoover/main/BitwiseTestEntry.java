package com.cwgoover.main;

import com.cwgoover.main.util.BitwiseUtil;

/**
 * Test BitwiseUtil's entry
 */
public class BitwiseTestEntry {
    private static final String CONSTANT_VALUE = "XXXXXXAWWEE";

    public static void main(String[] args) {
        // 对一个数变换符号
        int n = 100;
        System.out.println(n);
        int m = BitwiseUtil.transformSignBit(n);
        System.out.println(m);

        // Find two numbers which only appear once in an array which other elements
        // appear twice.
        int[] a = new int[] {13, 2333, 12, 421, 455, 23, 12, 455, 2333, 421};
        System.out.printf("The digital is: " + BitwiseUtil.getNumsAppearOnce(a));

    }


}
