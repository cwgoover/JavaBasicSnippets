package com.cwgoover.main;

/**
 * Find two numbers which only appear once in an array which other elements
 * appear twice.
 *
 */
public class BitwiseFindOnce {
    public static final void main(String[] args) {
        int[] a = new int[] {13, 2333, 12, 421, 455, 23, 12, 455, 2333, 421};
        System.out.printf("The digital is: " + getNumsAppearOnce(a));
    }

    /**
     * The core method
     * @param array an array contains two number appearing exactly once,
     *              while others appearing exactly twice.
     * @return num1 - the first number appearing once in array
     *         num2 - the second number appearing once in array
     */
    private static String getNumsAppearOnce(int[] array) {
        // XXX: remember check exception!!!!
        if (array == null || array.length < 2) {
            return "";
        }

        // get num1 ^ num2
        int resExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resExclusiveOR ^= array[i];
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
        StringBuilder result = new StringBuilder();
        result.append(num1);
        result.append(", ");
        result.append(num2);
        return result.toString();
    }

    /**
     * Find the index of the first bit which is 1 in number
     * @param number  assuming not 0
     * @return
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
     * @param num
     * @param index
     * @return
     */
    private static boolean isBit1(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}
