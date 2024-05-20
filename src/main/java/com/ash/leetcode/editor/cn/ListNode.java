package com.ash.leetcode.editor.cn;

/**
 * @author xiayichao
 * @version 1.0
 */
public class ListNode {

      int val;
      ListNode next;
    ListNode() {}
      ListNode(int x) {
          val = x;
          next = null;
      }
     //ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }


}
