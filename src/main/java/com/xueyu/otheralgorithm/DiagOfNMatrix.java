package com.xueyu.otheralgorithm;

import org.junit.Test;

/**
 * Author: xueyu
 * Date: 2016/9/27
 * Time: 11:10
 * 以对角线方式打印N方正中的元素
 */
public class DiagOfNMatrix {
    @Test
    public void test(){
        //输出：1, 2 6, 3 7 11, 4 8 12 16, 5 9 13 17 21, 10 14 18 22, 15 19 23,20 24, 25
        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        diagOfNMatrix(arr, 5);
    }
    public void diagOfNMatrix( int[][] arr, int n){
        for( int j = 0; j < n; ++j){
            int i = 0, l = j;
            while( l >= 0){
                System.out.print(arr[i][l] + " ");
                ++i;
                --l;
            }
            System.out.println();
        }
        for( int i = 1; i < n; ++i){
            int j = n-1, l = i;
            while( l < n){
                System.out.print(arr[l][j] + " ");
                ++l;
                --j;
            }
            System.out.println();
        }
    }
}
