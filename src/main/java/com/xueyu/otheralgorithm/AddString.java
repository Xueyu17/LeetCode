package com.xueyu.otheralgorithm;

import java.util.Scanner;

/**
 * Author: xinyu
 * Date: 16/9/11
 * Time: 下午2:45
 *
 * 对两个用字符串存储的整数进行相加操作，对非法输入返回“error”
 * 输入为一行，包含两个字符串，逗号分割，字符串的长度在［1，100],输出为一行
 * 如输入
 * 123 123
 * 输出
 * 246
 * 输入
 * abc 123
 * 输出error
 */
public class AddString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.next().split(",");
        if(strings.length != 2){
            System.out.println("error");
            return;
        }
        AddString addString = new AddString();
        addString.addString(strings[0], strings[1]);
    }

    /**
     * 字符串相加
     * 不考虑最高为有正负符号的情况
     * @param s
     * @param t
     */
    public void addString(String s, String t){
        int len1 = s.length()-1;
        int len2 = t.length()-1;
        int carry = 0;//进位
        String rs = "";
        while( len1 >= 0 && len2 >= 0){
            if(Character.isDigit(s.charAt(len1)) && Character.isDigit(t.charAt(len2))){
                int addRs = carry + s.charAt(len1)-'0' + t.charAt(len2) -'0';
                carry = addRs / 10;
                int remain = addRs % 10;//余数
                rs = remain + rs;
                --len1;
                --len2;
            }else {
                System.out.println("error");
                return;
            }
        }
        while(len1 >= 0){
            if(Character.isDigit(s.charAt(len1))){
                rs = s.charAt(len1) + rs;
                --len1;
            }else{
                System.out.println("error");
                return;
            }
        }
        while(len2 >= 0){
            if(Character.isDigit(t.charAt(len2))){
                rs = t.charAt(len2) + rs;
                --len2;
            }else{
                System.out.println("error");
                return;
            }
        }
        //处理高位为零的情况
        int index = this.getFirstNoZeroIndex(rs);
        rs = rs.substring(index+1, rs.length());

        System.out.println(rs);
    }

    /**
     * 省去结果中高位的零
     * @param s
     * @return
     */
    public int getFirstNoZeroIndex( String s){
        int index = 0;
        while(index < s.length()){
            if( s.charAt(index)=='0' && s.charAt(index+1)=='0'){
                index++;
            }else {
                break;
            }
        }
        return index;
    }
}
