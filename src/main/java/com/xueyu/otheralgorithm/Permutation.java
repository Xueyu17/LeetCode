package com.xueyu.otheralgorithm;

import java.util.Scanner;

/**
 * Author: xinyu
 * Date: 16/9/11
 * Time: 上午11:30
 * 全排列
 */
public class Permutation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] perm = s.toCharArray();
        Permutation permutation = new Permutation();
        permutation.calcAllPermutation(perm , 0, s.length());
    }
    public void calcAllPermutation(char[] perm, int start, int end){
        if(start == end){
            System.out.println(perm);
        }else{
            for( int i = start; i < end; ++i){
                swap(perm, i, start);
                calcAllPermutation(perm, start+1, end);
                swap(perm, i, start);
            }
        }
    }
    public void swap(char[] perm, int i, int j){
        char tmp = perm[i];
        perm[i] = perm[j];
        perm[j] = tmp;
    }
}
