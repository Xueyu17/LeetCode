package com.xueyu.otheralgorithm;

import java.util.Scanner;

/**
 * Author: xinyu
 * Date: 16/9/11
 * Time: 上午10:17
 * 假定一种编码的编码范围是a~y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组，如下：
 * a,aa,aaa,aaaa,aaab,aaac,...,b,ba,baa,baaa,baab,baac,....,yyyw,yyyx,yyyy
 * 其中a的idnex为0,aa的index为1,aaa的index为2，以此类推。编写一个函数，输入是任意一个编码，输出这个编码对应的 index，如：
 * 输入:baca
 * 输出:16331
 */
public class TecentTest {
    /**
     * 打表式 16276 = 25^3 + 25^2 + 25 + 1
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int len = s.length();
        if(len > 4 ){
            System.out.println("length error");
            return;
        }
        for( int i = 0; i < len; ++ i){
            if( s.charAt(i) < 'a' || s.charAt(i) > 'c'){
                System.out.println("input error");
                return;
            }
        }
        long rs = 0l;
        switch (len){
            case 1:
                rs = (s.charAt(0)-'a')*16276;
                break;
            case 2:
                rs = (s.charAt(0)-'a')*16276 + 1 + (s.charAt(1)-'a')*651;
                break;
            case 3:
                rs = (s.charAt(0)-'a')*16276 + 1 + (s.charAt(1)-'a')*651 + 1 + (s.charAt(2)-'a')*26 ;
                break;
            case 4:
                rs = (s.charAt(0)-'a')*16276 + 1 + (s.charAt(1)-'a')*651 + 1 + (s.charAt(2)-'a')*26 + 1 + (s.charAt(3)-'a');
        }
        System.out.println(rs);
    }
}
