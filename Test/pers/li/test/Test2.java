package pers.li.test;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectSort(new int[]{49, 38, 65, 97, 76, 13, 27, 49})));
    }

    public static int[] selectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i; j < length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
