package com.xueyu.otheralgorithm;

import org.junit.Test;

/**
 * Author: xueyu
 * Date: 2016/9/24
 * Time: 11:18
 */
public class MergeSort {
    @Test
    public void test(){
        int[] array = {7,4,6,2,3,8,5,9};
        mergeHelper(array, array.length);
        for( int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
    public void mergeHelper(int arr[], int n){
        int[] sorted = new int[n];
        mergeSort(arr, sorted, 0, n);
    }
    public void mergeSort(int[] unsorted, int[] sorted, int first, int last){
      if( first+1 < last){
           int mid = (last+first)/2;
           mergeSort(unsorted, sorted, first, mid);
           mergeSort(unsorted, sorted, mid, last);
           merge(unsorted, sorted, first, mid, last);
       }
    }
    /**
     *将有序表sorted[first : mid-1]和有序表sorted[mid : last-1] 归并到表unsorted[first : last-1]中
     */
    public void merge(int unsorted[], int sorted[], int first, int mid, int last){
        int i = first, j = mid, k = 0;
        while(i < mid && j < last){
            if (unsorted[i] <= unsorted[j]) {
                sorted[k++] = unsorted[i++];
            } else {
                sorted[k++] = unsorted[j++];
            }
        }
        while( i < mid){
            sorted[k++] = unsorted[i++];
        }
        while(j < last){
            sorted[k++] = unsorted[j++];
        }
        for(int l = 0; l < k; ++l){
            unsorted[first + l] = sorted[l];
        }
    }
}