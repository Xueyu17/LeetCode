package com.xueyu.otheralgorithm;

import org.junit.Test;

/**
 * Author: xueyu
 * Date: 2016/9/24
 * Time: 14:11
 */
public class HeapSort {
    @Test
    public void test(){
        int[] array = {7,4,6,2,3,8,5,9};
        heapSort(array, array.length-1);
        for( int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
    public void heapSort(int[] arr, int last){
        for(int i = last/2; i >= 0; --i ){//创建堆
            heapShift(arr, i, last);
        }
        for( int i = last; i > 0; i--){
            //交换根节点与待排序区最后一个记录
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapShift(arr, 0, i-1);
        }
    }
    /**
     *将arr[i:last]调整为大根堆
     */
    public void heapShift(int[] arr, int i, int last){
        int j = 2*i+1;//左孩子
        int root = arr[i];
        while( j <= last){//从排序码较大的孩子节点向下调整
            if( j < last && arr[j] < arr[j+1])
                ++j;
            if( arr[j] < root) break;//子节点比root小，跳出
            arr[i] = arr[j];
            i = j;
            j = 2*i+1;
        }
        arr[i] = root;//找到根节点最后插入的位置
    }
}
