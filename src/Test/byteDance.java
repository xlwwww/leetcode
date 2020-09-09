package Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cutiewang
 * @date 2020/9/2 15:09
 */

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){this.val = val;}
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
}
public class byteDance {
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //尾插法
    public ListNode reverse2(ListNode head){
        ListNode p=null,q = null;
        while(head!=null){
            p = head.next;
            head.next = q;
            q = head;
            head = p;
        }
        return q;
    }
    /* not finish*/
    public ListNode reversePart(ListNode head,int m,int n){
        ListNode pre = null,n_head = head;
        for(int i =1;i<m;i++){
            pre = head;
            head = head.next;
        }
        ListNode tail = head,pre_head = pre,next;
        for(int i = m;i<n;i++){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        pre_head.next = pre;
        tail.next = head;
        return n_head;
    }
    public ListNode reverseKGroup(ListNode head,int k){
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        for(int i =0;i<k;i++){
            if(tail!=null) tail = tail.next;
            else return head;
        }
        ListNode newHead = reverse(head,tail);
        head.next = reverseKGroup(tail,k);
        return newHead;
    }
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode next,pre= null;
        while(head!=tail){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return tail;
    }
    public ListNode MergeUpdate(ListNode node){
        ListNode tmp = node,ou = node.next;
        while(tmp!=null && tmp.next!=null){
            tmp.next = tmp.next.next;
            tmp = tmp.next.next;
        }
        while(ou!=null && ou.next!=null){
            ou.next = ou.next.next;
            ou= ou.next.next;
        }
        reverse(ou);
        return merge(tmp,ou);
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(head1!=null && head2!=null){
            if(head1.val>head2.val){
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }else if(head1.val<=head2.val){
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            }
        }
        if(head1!=null) cur.next = head1;
        if(head2!=null) cur.next = head2;
        return dummy.next;
    }

    /*
    * 回溯
    * bfs dfs
    */
    public void bfs(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            int n = queue.size();
            while(n>0){
                n--;
                Node tmp = queue.poll();
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }
        }
    }
    public int trap(int[] height){
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int a=0,b=0;
        int sum = 0;
        for(a =0;a<=maxIndex;a++){
            if(height[a]<height[b]){
                sum+=height[b]-height[a];
            }else{
                b=a;
            }
        }
        for(a=height.length-1;a>=maxIndex;a--){
            if(height[a]<height[b]){
                sum+=height[b]-height[a];
            }else{
                b=a;
            }
        }
        return sum;
    }
    /*
    * 给定数组n+1,数在1-n之间*/
//    public int findDup(int[] arr){
////
////    }
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length+nums2.length;
//        int k = n/2;
//        String a = "";
//        a.replace();
//        while(k>=0){
//            int a = k/2;
//            if(nums1[a]>nums2[a]){
//
//            }
//        }
//    }
    public static void main(String[] args) {
        byteDance byteDance = new byteDance();
        byteDance.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
