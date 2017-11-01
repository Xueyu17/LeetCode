package com.xueyu.leetcode.easy;

import org.junit.Test;

import java.util.*;

/**
 * Author: xueyu
 * Date: 17/11/1
 * Time: 下午8:54
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] tmp = new int[nums.length];
        for( int i=0; i<nums.length; i++){
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        int begin = 0;
        int end = nums.length - 1;
        while( begin < end ){
            int sum = tmp[begin] + tmp[end];
            if( sum == target){
                break;
            }else if(sum > target){
                end--;
            }else {
                begin++;
            }
        }
        int[] rs = {-1,-1};
        for( int i=0; i<nums.length; i++){
            if(rs[0] == -1 && nums[i]==tmp[begin]){
                rs[0] = i;
            }else if(rs[1] == -1 && nums[i]==tmp[end]){
                rs[1] = i;
            }
        }
        return rs;
    }

    public int[] twoSumBetter(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < nums.length; i ++){
            int tmp = target - nums[i];
            if( map.containsKey(tmp)){
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    @Test
    public void test(String[] args) {
        int nums[] = {3,2,4};
        int target = 6;
        int rs[] = twoSumBetter(nums, target);
        System.out.println(rs[0]+"\t"+rs[1]);
    }
}
