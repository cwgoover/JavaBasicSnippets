package com.cwgoover.main.util;

/**
 * Bitwise operation utility class
 */
public class BitwiseUtil {

    /**
     * Transform digit's sign bit.
     * Negative to positive, or positive to negative
     */
    public static int transformSignBit(int digit) {
        return ~digit + 1;
    }

    /**
     * Find two numbers which only appear once in an array which other elements
     * appear twice.
     *
     * @param array an array contains two number appearing exactly once,
     *              while others appearing exactly twice.
     * @return num1 - the first number appearing once in array
     *         num2 - the second number appearing once in array
     */
    public static String getNumsAppearOnce(int[] array) {
        // XXX: remember check exception!!!!
        if (array == null || array.length < 2) {
            return "";
        }

        // get num1 ^ num2
        int resExclusiveOR = 0;
        for (int anArray : array) {
            resExclusiveOR ^= anArray;
        }

        // get index of the first bit, which is 1 in resExclusiveOR
        int indexOf1 = findFirstBitIs1(resExclusiveOR);

        int num1 = 0, num2 = 0;
        for (int i = 0; i < array.length; i++) {
            // divide the numbers in array into two groups,
            // the indexOf1 bit of number in the first group is 1,
            // while in the second group is 0
            if (isBit1(array[i], indexOf1)) {
                num1 ^= array[i];
            } else {
                num2 ^= array[i];
            }
        }

        // Prepare string to show the number
        return String.valueOf(num1) + ", " + num2;
    }

    /**
     * Find the index of the first bit which is 1 in number
     * @param number  assuming not 0
     *
     */
    private static int findFirstBitIs1(int number) {
        int indexBit = 0;
        while ((number & 1) == 0 && indexBit < 32) {
            number = number >> 1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * Is the indexBit bit of num 1?
     */
    private static boolean isBit1(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}
