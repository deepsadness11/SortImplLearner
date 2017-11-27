package com.cry.impl;

import com.cry.SortInterface;

/**
 * 插入排序的基本思想：
 * 每步将一个待排序元素，按其排序码大小插入到前面已经排好序的一组元素中，直到元素全部插入为止。
 * 在这里，我们介绍三种具体的插入排序算法：直接插入排序，希尔排序与折半插入排序。
 * <p>
 * 希尔排序的思想：
 * 设待排序序列共n个元素，首先取一个整数gap<n作为间隔，将全部元素分为间隔为gap的gap个子序列并对每一个子序列进行直接插入排序。
 * 然后，缩小间隔gap，重复上述操作，直至gap缩小为1，此时所有元素位于同一个序列且有序。
 * 由于刚开始时，gap较大，每个子序列元素较少，排序速度较快；
 * 待到排序后期，gap变小，每个子序列元素较多，但大部分元素基本有序，所以排序速度仍较快。
 * 一般地，gap取 （gap/3 + 1）。希尔排序是一种不稳定的排序方法，
 * 其实现如下：
 * <p>
 * Title: 插入排序中的希尔排序，依赖于初始序列
 * Description: 分别对间隔为gap的gap个子序列进行直接插入排序，不断缩小gap,直至为 1
 * <p>
 * 刚开始时，gap较大，每个子序列元素较少，排序速度较快；
 * 待到排序后期，gap变小，每个子序列元素较多，但大部分元素基本有序，所以排序速度仍较快。
 * <p>
 * 时间复杂度：O(n) ~ O(n^2)
 * 空间复杂度：O(1)
 * 稳    定   性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 */
public class ShellSort implements SortInterface {
    @Override
    public void sort(int[] o_arr) {

        if (o_arr != null && o_arr.length != 1) {
            int length = o_arr.length;
            //先定义gap
            int gap = length;
            while (gap > 1) {
                gap = gap / 3 + 1;
                //开始遍历
                for (int i = gap; i < length; i++) {
                    //以gap的距离进行缩短
                    int j = i - gap;
                    while (j >= 0) {
                        if (o_arr[j + gap] < o_arr[j]) {
                            //交换
                            int temp = o_arr[j + gap];
                            o_arr[j + gap] = o_arr[j];
                            o_arr[j] = temp;
                            //以gap的距离进行缩短
                            j -= gap;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}
