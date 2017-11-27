package com.cry;

import com.cry.impl.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        int[] original = {4, 2, 1, 7, 5, 3, 9, 6};
        Class[] sortClassPool = {QuickSort.class, MergeSort.class, ShellSort.class, HeapSort.class, BubbleSort.class};
        //创建动态代理
        int index = 4;
        proxySort(original, sortClassPool[index]);
    }

    @SuppressWarnings("unchecked")
    private static void proxySort(int[] orignal, Class t) {
        try {
            Constructor constructor = t.getConstructor();
            SortInterface o = (SortInterface) constructor.newInstance();
            SortInterface proxy = createProxy(t, o);
            proxy.sort(orignal);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class<T> tClass, T t) {
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), tClass.getInterfaces(), (Object proxy, Method method, Object[] args) -> {
            if (args.length == 1 && args[0] instanceof int[]) {
                int[] arg = (int[]) args[0];
                System.out.println("====before====" + Arrays.toString(arg));//定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
                Object result = method.invoke(t, args);
                System.out.println("====after====" + Arrays.toString(arg));
                return result;
            }
            return null;
        });
    }
}
