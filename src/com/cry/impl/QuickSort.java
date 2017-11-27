package com.cry.impl;

import com.cry.SortInterface;

import java.util.Arrays;

/**
 * 四. 交换排序-快速排序
 * <p>
 * 交换排序的基本思想：根据序列中两个元素的比较结果来对换这两个记录在序列中的位置，也就是说，将键值较大的记录向序列的尾部移动，键值较小的记录向序列的前部移动。
 * <p>
 * 快速排序的思想：
 * 通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小(划分过程)，
 * 然后再按此方法对这两部分数据分别进行快速排序(快速排序过程)，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * <p>
 * 快速排序是一种不稳定的排序算法。
 * <p>
 * <p>
 * <p>
 * Title: 交换排序中的快速排序，目前应用最为广泛的排序算法，是一个递归算法，依赖于初始序列
 * Description:快速排序包括两个过程：划分 和 快排
 * <p>
 * "划分"是指将原序列按基准元素划分两个子序列
 * "快排"是指分别对子序列进行快排
 * <p>
 * 就平均计算时间而言，快速排序是所有内部排序方法中最好的一个
 * <p>
 * 对大规模数据排序时，快排是快的；对小规模数据排序时，快排是慢的，甚至慢于简单选择排序等简单排序方法
 * <p>
 * 快速排序依赖于原始序列，因此其时间复杂度从O(nlgn)到O(n^2)不等
 * 时间复杂度：最好情形O(nlgn)，平均情形O(nlgn)，最差情形O(n^2)
 * <p>
 * 递归所消耗的栈空间
 * 空间复杂度：O(lgn)
 * <p>
 * 可选任一元素作为基准元素
 * 稳 定 性：不稳定
 * <p>
 * <p>
 * 内部排序(在排序过程中数据元素完全在内存)
 */
public class QuickSort implements SortInterface {

    public void sort(int[] orginal) {
        if (orginal == null || orginal.length == 0) {
            throw new NullPointerException("arr length is null or zero");
        }
        quickSortTotal(orginal, 0, orginal.length - 1);
    }

    /**
     * 快排分区
     *
     * @return 返回之后的基准点
     */
    private int repartition(int[] target, int left, int right) {
        //记录初始值的基准点左边
        int base_index = left;
        //先取到基准点
        int base = target[base_index];
        //遍历排序
        for (int i = left + 1; i <= right; i++) {  //从下一个元素开始
            //基准元素不会改变，一直是和基准来比
            if (target[i] < base) {   //若小于基准元素
                base_index++;
                if (base_index != i) { //偏移之后，如果坐标不同，则需要交换
                    System.out.println("swap base_index=" + base_index + "  i = " + i);
                    System.out.println("swap in base_index=" + target[base_index] + "  in i = " + target[i]);
                    int temp = target[base_index];
                    target[base_index] = target[i];
                    target[i] = temp;
                }
            }
        }
        System.out.println("outer swap base_index=" + base_index + "  left = " + left);
        System.out.println("outer swap in base_index=" + target[base_index] + "  in left = " + target[left]);
        System.out.println(Arrays.toString(target));
        //将基础元素就位
        target[left] = target[base_index];
        target[base_index] = base;
        System.out.println(Arrays.toString(target));
        return base_index;
    }

    private int[] quickSortTotal(int[] target, int left, int right) {
        if (left < right) {
            int repartition = repartition(target, left, right);
            quickSortTotal(target, left, repartition - 1);  //进行快速排序，去掉基准点！！
            quickSortTotal(target, repartition + 1, right);  //进行快速排序，去掉基准点！！
        }
        return target;
    }
}
