package com.xueyu.leetcode.medium;

import org.junit.Test;

/**
 * Author: xueyu
 * Date: 2016/10/8
 * Time: 13:48
 * 最长公共子串,动态规划
 */
public class LongestCommonSubstring {
    @Test
    public void test(){
        String s = "abcdfghijk", t = "rabcfdfghikjn";
        System.out.println(longestCommonSubstring(s, t));
    }
    public String longestCommonSubstring(String s, String t){
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1][len2];
        int maxLen = 0;
        String rs = "";
        for(int i = 0; i < len1; ++i){
            for(int j = 0; j < len2; ++j){
                if( s.charAt(i) == t.charAt(j)){
                    if( i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    int curLen = dp[i][j];
                    if(curLen > maxLen){
                        maxLen = curLen;
                        rs = s.substring(i-curLen+1,i);
                    }
                }
            }
        }
        return rs;
    }
}
