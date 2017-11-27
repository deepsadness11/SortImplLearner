package com.cry.impl;

import com.cry.SortInterface;

import java.util.Arrays;

/**
 * Title: 归并排序 ，概念上最为简单的排序算法，是一个递归算法
 * Description:归并排序包括两个过程：归 和 并
 * "归"是指将原序列分成半子序列，分别对子序列进行递归排序
 * "并"是指将排好序的各子序列合并成原序列
 * <p>
 * 归并排序的主要问题是：需要一个与原待排序数组一样大的辅助数组空间
 * <p>
 * 归并排序不依赖于原始序列，因此其最好情形、平均情形和最差情形时间复杂度都一样 时间复杂度：最好情形O(nlog2n)，平均情形O(nlog2n)，最差情形O(n^2)
 * 空间复杂度：O(n) 稳 定 性：稳定 内部排序(在排序过程中数据元素完全在内存)
 */
public class MergeSort implements SortInterface {
    @Override
    public void sort(int[] o_arr) {
        //归并排序需要复制一个数组
        int length = o_arr.length;
        int[] copyArr = Arrays.copyOf(o_arr, length);
        merge(o_arr, copyArr, 0, length - 1);
    }

    public static void mergeSort(int[] target) {
        int[] copy = Arrays.copyOf(target, target.length);    // 空间复杂度O(n)
        mergeSort(target, copy, 0, target.length - 1);
    }

    public static void mergeSort(int[] target, int[] copy, int left, int right) {
        if (right > left) { // 递归终止条件
            int mid = (left + right) / 2;   //取中点
            mergeSort(target, copy, left, mid); // 归并排序第一个子序列
            mergeSort(target, copy, mid + 1, right); // 归并排序第二个子序列
            merge(target, copy, left, mid, right); // 合并子序列成原序列
        }
    }

    /**
     * @param target 用于存储归并结果
     * @param left   第一个有序表的第一个元素所在位置
     * @param mid    第一个有序表的最后一个元素所在位置
     * @param right  第二个有序表的最后一个元素所在位置
     * @description 两路归并算法
     */
    public static void merge(int[] target, int[] copy, int left, int mid,
                             int right) {

        // s1,s2是检查指针，index 是存放指针
        int s1 = left;
        int s2 = mid + 1;
        int index = left;

        // 两个表都未检查完，两两比较
        while (s1 <= mid && s2 <= right) {
            if (copy[s1] <= copy[s2]) { // 稳定性
                target[index++] = copy[s1++];
            } else {
                target[index++] = copy[s2++];
            }
        }

        // 若第一个表未检查完，复制
        while (s1 <= mid) {
            target[index++] = copy[s1++];
        }

        // 若第二个表未检查完，复制
        while (s2 <= right) {
            target[index++] = copy[s2++];
        }

        // 更新辅助数组 copy
        for (int i = left; i <= right; i++) {
            copy[i] = target[i];
        }

    }

    private void merge(int[] o_arr, int[] copyArr, int left, int right) {
        if (left < right) {    //终止条件
            //取重点
            int mid = (left + right) / 2;
            //递归
            merge(o_arr, copyArr, left, mid);//包含
            merge(o_arr, copyArr, mid + 1, right);  //不包含
            //两路合并算法
            mergeFromTwoSide(o_arr, copyArr, left, mid, right);
        }
    }

    /**
     * @param o_arr 用于存储归并结果
     * @param left  第一个有序表的第一个元素所在位置
     * @param mid   第一个有序表的最后一个元素所在位置
     * @param right 第二个有序表的最后一个元素所在位置
     * @description 两路归并算法
     */
    private void mergeFromTwoSide(int[] o_arr, int[] copyArr, int left, int mid, int right) {
        //先创建两个检查指针
        int s1 = left;
        int s2 = mid + 1;
        int index = left;
        //先进行两边各自的检查
        System.out.println("start left="+left+";mid="+mid+";right="+right);
        while (s1 <= mid && s2 <= right) {
            System.out.println("s1="+s1+";s2="+s2+";index="+index);
            //进行比较
            if (copyArr[s1] <= copyArr[s2]) {   //稳定性
                //照搬复制
                o_arr[index++] = copyArr[s1++];
            } else {
                //否则反过来取
                o_arr[index++] = copyArr[s2++];
            }
        }

        //若第一个表还未检查完
        while (s1<=mid){
            o_arr[index++] = copyArr[s1++];
        }
        //若第二个表还未检查完
        while (s2<=right){
            o_arr[index++] = copyArr[s2++];
        }

        // 最后，全部更新辅助数组 copy
        System.arraycopy(o_arr, left, copyArr, left, right + 1 - left);

    }
}
