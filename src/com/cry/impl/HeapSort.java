package com.cry.impl;

import com.cry.SortInterface;

/**
 * 选择排序
 * 选择排序的基本思想：
 * 每一趟 (例如第i趟，i = 0,1,…)在后面第n-i个待排序元素中选出最小元素作为有序序列的第i个元素，直到第n-1趟结束后，所有元素有序。
 * 在这里，我们介绍两种具体的选择排序算法：
 * 直接选择排序与堆排序。
 * <p>
 * 堆排序的核心是堆调整算法。
 * 首先根据初始输入数据，利用堆调整算法shiftDown()形成初始堆；
 * 然后，将堆顶元素与堆尾元素交换，缩小堆的范围并重新调整为堆，如此往复。
 * 堆排序是一种不稳定的排序算法，其实现如下：
 * <p>
 * Title: 堆排序(选择排序)，升序排序(最大堆)，依赖于初始序列
 * Description: 现将给定序列调整为最大堆，然后每次将堆顶元素与堆尾元素交换并缩小堆的范围，直到将堆缩小至1
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(1)
 * 稳 定 性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 */
public class HeapSort implements SortInterface {
    @Override
    public void sort(int[] o_arr) {
        if (o_arr != null && o_arr.length > 1) {
            int pos = (o_arr.length - 2) / 2;
            while (pos >= 0) {
                shiftDown2(o_arr, pos, o_arr.length - 1);
                pos--;
            }

            //堆排序
            for (int i = o_arr.length - 1; i > 0; i--) {
                //全部和0互换
                int temp = o_arr[i];
                o_arr[i] = o_arr[0];
                o_arr[0] = temp;
                shiftDown2(o_arr, 0, i - 1);
            }
        }
    }

    public static int[] heapSort(int[] target) {
        if (target != null && target.length > 1) {

            // 调整为最大堆
            int pos = (target.length - 2) / 2;
            while (pos >= 0) {
                shiftDown(target, pos, target.length - 1);
                pos--;
            }

            // 堆排序
            for (int i = target.length - 1; i > 0; i--) {
                int temp = target[i];
                target[i] = target[0];
                target[0] = temp;
                shiftDown(target, 0, i - 1);
            }
            return target;
        }
        return target;
    }

    private void shiftDown2(int[] target, int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = target[i];

        while (j <= end) {
            if (j < end && target[j + 1] > target[j]) {    //找出较大的子女
                j = j + 1;
            }
            if (target[j] <= temp) {   //父亲大于子女
                break;
            } else {
                //重置
                target[i] = target[j];
                i = j;
                j = 2 * j + 1;
            }
        }
        target[i] = temp;
    }


    /**
     * @param target
     * @param start
     * @param end
     * @description 自上而下调整为最大堆
     * @author rico
     * @created 2017年5月25日 上午9:45:40
     */
    private static void shiftDown(int[] target, int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = target[i];
        while (j <= end) {   // 迭代条件
            if (j < end && target[j + 1] > target[j]) {  //找出较大子女
                j = j + 1;
            }
            if (target[j] <= temp) {  // 父亲大于子女
                break;
            } else {
                target[i] = target[j];
                i = j;
                j = 2 * j + 1;
            }
        }
        target[i] = temp;
    }
}
