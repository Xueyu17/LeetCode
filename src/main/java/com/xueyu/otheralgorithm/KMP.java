package com.xueyu.otheralgorithm;

import org.junit.Test;

/**
 * Author: xueyu
 * Date: 2016/10/12
 * Time: 19:39
 * 查找模式串p在字符串s中的索引位置，没有则返回-1
 */
public class KMP {
    @Test
    public void test(){
        String s = "abacababc", p = "abab";
        System.out.println(kmpSearch(s, p));
    }
    public int kmpSearch(String s, String p){
        int i = 0, j = 0, index = -1;
        int s_len = s.length(), p_len = p.length();
        int[] next = new int[p_len];
        getNext(p, next);
        while( i < s_len && j < p_len){
            if( j == -1 || s.charAt(i) == p.charAt(j)){
                ++i;
                ++j;
            }else {
                j = next[j];
            }
        }
        if( j == p_len){
            index = i - j;
        }
        return index;
    }
    /**
     * 构建next数组，next[j]存放的是next[0……j-1]中相同前缀和后缀的长度信息（next[0]=-1）
     */
    public void getNext(String p, int[] next){
        next[0] = -1;
        int k = -1, j = 0;
        while( j < p.length()-1){
            if( k == -1 || p.charAt(k) == p.charAt(j)){
                ++k;
                ++j;
                if( p.charAt(k) != p.charAt(j)){
                    next[j] = k;
                }else{//优化，防止出现p[j] = p[next[j]]（s[i]!=p[j]时会出现无效匹配）
                    // 因此继续递归 k = next[k] = next[next[k]]
                    next[j] = next[k];
                }
            }else {//寻找长度更短的相同前缀和后缀
                k = next[k];
            }
        }
    }
}
