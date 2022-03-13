/*
 * 快速排序.java
 * Copyright (C) 2021 2021-09-22 12:12 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

public class 快速排序
{
    public static void main(String args[]) {
        int arr[] = {5, -1, 4, 2, 1};
        
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void quickSort(int arr[], int low, int high) {
        int pos = -1;
        if (low < high) {
            pos = findPos(arr, low, high);
            quickSort(arr, low, pos-1);
            quickSort(arr, pos+1, high);
        }
    }

    public static int findPos(int arr[], int low, int high) {
        int val = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= val)//所有小于val的被交换到左边
                high--;
            arr[low] = arr[high];

            while (low < high && arr[low] <= val)//所有大于val的被交换到右边
                low++;
            arr[high] = arr[low];
        }
        arr[low] = val;
        return low;
    }
}

