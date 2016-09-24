package com.xueyu.otheralgorithm;

import org.junit.Test;

/**
 * Author: xueyu
 * Date: 2016/9/24
 * Time: 15:10
 */
public class QuickSort {
    @Test
    public void test(){
        int[] array = {7,4,6,2,3,8,5,9};
        QSort(array, 0, array.length-1);
        for( int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
    public void QSort(int[] arr, int low, int high){
        int part;
        if( low < high){
            part = partition( arr, low, high);
            QSort(arr, low, part-1);
            QSort(arr, part+1, high);
        }
    }
    public int partition(int[] arr, int low, int high){
        int qivot = arr[low];//取第一个元素为基准
        while( low < high){
            while ( low < high && arr[high] >= qivot)
                --high;
            if ( low < high)
                arr[low] = arr[high];
            while ( low < high && arr[low] <= qivot)
                ++low;
            if ( low < high)
                arr[high] = arr[low];
        }
        arr[low] = qivot;
        return low;
    }
}
