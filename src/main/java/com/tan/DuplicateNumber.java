package com.tan;

/**
 * Create by zhuojun.tian
 * on 2019/9/4
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 0, 2, 5, 3};
        int[] duplications = new int[1];
        findDuplicateNumber1(array, duplications);
        System.out.println(duplications[0]);
        int[] array2 = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findDuplicateNumber2(array2));
    }

    public static boolean findDuplicateNumber1(int[] array, int[] duplications) {
        if (array == null || array.length < 1) {
            return false;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < 0 || array[i] > len) {
                return false;
            }
        }
        for (int i = 0; i < len; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    duplications[0] = array[i];
                    return true;
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return false;
    }

    public static int findDuplicateNumber2(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int start = 1;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = countRange(array, start, mid); //统计范围内不同数字个数
            if (end == start) { //当只统计一个数字时，如果count>1就是重复数字
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] array, int start, int end) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= start && array[i] <= end) {
                count++;
            }
        }
        return count;
    }

}
