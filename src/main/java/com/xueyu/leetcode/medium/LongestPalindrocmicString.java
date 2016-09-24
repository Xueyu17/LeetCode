package com.xueyu.leetcode.medium;

import org.junit.Test;

/**
 * Author: xinyu
 * Date: 16/9/7
 * Time: 上午9:57
 * 寻找字符串中的唯一最长回文字串
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrocmicString {
    @Test
    public void test(){
        String s = "abaabacdce";
        String substr = longestPalindrome(s);
        System.out.println(substr);
    }
    /**
     *中心扩展法
     */
    public String longestPalindrome(String s){
        if( s == null) return null;
        int n = s.length();
        int max = 0, len = 0;
        String rs = "";
        //i为回文串中心
        for( int i = 0; i < n; ++i){
            //回文长度为奇数
            for( int j = 0; (i-j) >=0 && (i+j) < n; ++j){
                if( s.charAt(i-j) != s.charAt(i+j)) break;
                len = 2*j + 1;
            }
            if( len > max){
                max = len;
                rs = s.substring(i-len/2, i+len/2+1);
            }
            //回文长度为偶数
            for( int j = 0; (i-j) >=0 && (i+j+1) < n; ++j){
                if( s.charAt(i-j) != s.charAt(i+j+1)) break;
                len = 2*j + 2;
            }
            if( len > max){
                max = len;
                rs = s.substring(i-len/2+1, i+len/2+1);
            }
        }
        return rs;
    }
}
