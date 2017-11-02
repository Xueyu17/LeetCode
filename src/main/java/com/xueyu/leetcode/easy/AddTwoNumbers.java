package com.xueyu.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lixueyu@meituan.com
 * Date: 17/11/2
 * Time: 下午6:55
 * https://leetcode.com/problems/add-two-numbers/discuss/
 */
public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tmpHead = null;
        ListNode tail = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (p!=null && q!=null){
            int sum = p.val + q.val + carry;
            carry = sum/10;
            int number = sum%10;
            if(head == null){
                head = new ListNode(number);
                tmpHead = head;
                head.next = tail;
            }else {
                tail.val = number;
                tail.next = new ListNode(-1);
                tmpHead = tail;
                tail = tmpHead.next;
            }
            p=p.next;
            q=q.next;
        }
        while(p!= null){
            int sum = p.val + carry;
            carry = sum/10;
            int number = sum%10;
            tail.val = number;
            tail.next = new ListNode(-1);
            tmpHead = tail;
            tail = tmpHead.next;
            p = p.next;
        }
        while(q!= null){
            int sum = q.val + carry;
            carry = sum/10;
            int number = sum%10;
            tail.val = number;
            tail.next = new ListNode(-1);
            tmpHead = tail;
            tail = tmpHead.next;
            q=q.next;
        }
        if(carry>0){
            tail.val=carry;
        }else {
            tmpHead.next = null;
        }
        return head;
    }
}
