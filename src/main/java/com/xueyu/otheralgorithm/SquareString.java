package com.xueyu.otheralgorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: xueyu
 * Date: 2016/9/24
 * Time: 上午1:07
 * 网易测试题：平方串
 * 如果一个字符串有完全相同的两段字符串组成，称其为平方串，如"aa","abcabc"
 * 求给定字符串（只包含大小写字母）的连续子串中有多少种平方串，其中相同的子串只统计一次种数
 * 如：输入aaabccabccCC，则输出4
 */
public class SquareString {
    @Test
    public void test(){
        String s = "aaabccabccCC";
        int count = countSquareString(s);
        System.out.println(count);
    }
    public int countSquareString(String s){
        int count = 0;
        Set<String>  hashset = new HashSet<String>();
        for(int i = 0; i < s.length()-1; ++i){
            for( int j = i+1; j < s.length(); ++j){
                int len = j-i+1;
                if( len % 2 != 0) continue;
                int mid = i + len / 2;
                String prefix = s.substring(i, mid);
                String suffix = s.substring(mid, j+1);
                if( prefix.equals(suffix) && !hashset.contains(prefix)){
                    ++count;
                    hashset.add(prefix);
                }
            }
        }
        return count;
    }
}
