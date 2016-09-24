package com.xueyu.otheralgorithm;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Author: xueyu
 * Date: 2016/9/24
 * Time: 17:39
 * 从给定数组中找出和为sum的所有组合
 */
public class SumOfkNumber {
    private static List<Integer> resultArray = new ArrayList<Integer>();
    private static int cnt = 0;
    @Test
    public void test(){
        int[] array = {7,4,6,2,3,8,5,9};
        Arrays.sort(array);
        sumOfkNumber(array, 0, array.length, 15);
        System.out.println("total methods: "+cnt);
    }
    public void sumOfkNumber(int[] arr, int start, int n, int sum){
        if( sum == 0){//递归出口
            for( int i = 0; i < resultArray.size(); ++i){
                System.out.print(resultArray.get(i) + " ");
            }
            System.out.println();
        }else {
            for (int j = start; j < n; ++j) {
                resultArray.add(arr[j]);
                sumOfkNumber(arr, j + 1, n - 1, sum - arr[j]);
                resultArray.remove(resultArray.size()-1);
            }
        }
    }
}
