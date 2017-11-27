package com.cry.impl;

import com.cry.SortInterface;

import java.util.Arrays;

public class BubbleSort implements SortInterface {
    @Override
    public void sort(int[] o_arr) {
        int length = o_arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (o_arr[j] > o_arr[j + 1]) {
                    temp = o_arr[j];
                    o_arr[j] = o_arr[j + 1];
                    o_arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * @description 朴素冒泡排序(共进行n-1次比较)
     * @author rico
     */
    private int[] bubbleSort(int[] target) {
        int n = target.length;
        if (target != null && n != 1) {
            // 最多需要进行n-1躺，每一趟将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
            for (int i = 0; i < n - 1; i++) {
                for (int j = n - 1; j > i; j--) {
                    if (target[j] < target[j - 1]) {
                        int temp = target[j];
                        target[j] = target[j - 1];
                        target[j - 1] = temp;
                    }
                }
                System.out.println(Arrays.toString(target));
            }
        }
        return target;
    }

    /**
     * @description 优化冒泡排序
     * @author rico
     */
    private int[] optimizeBubbleSort(int[] target) {
        int n = target.length;
        if (target != null && n != 1) {
            // 最多需要进行n-1躺，每一趟将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
            for (int i = 0; i < n - 1; i++) {
                boolean exchange = false;
                for (int j = n - 1; j > i; j--) {
                    if (target[j] < target[j - 1]) {
                        int temp = target[j];
                        target[j] = target[j - 1];
                        target[j - 1] = temp;
                        exchange = true;
                    }
                }
                System.out.println(Arrays.toString(target));
                if (!exchange) {    // 若 i 到 n-1 这部分元素已经有序，则直接返回
                    return target;
                }
            }
        }
        return target;
    }
}
