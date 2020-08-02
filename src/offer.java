
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author cutiewang
 * @date 2020/1/26 11:37
 */
public class offer {

/*    public boolean isNumeric(char[] str) {
        int len = str.length;
        if (len == 0) {
            return false;
        }
        if (!((str[0] <= '9' && (str[0] >= '0')) || str[0] == '+' || str[0] == '-')) {
            return false;
        }
        int i = 1;
        while (i < len) {
            if (isnum(str[i - 1]) && str[i] == 'e' || str[i] == 'E') {
                //check left char
                if (i + 1 < len) {
                    if(str[i+1] == '-' || isnum(str[i+1])){
                        for(int tmp = i+2;tmp<len;tmp++){
                            if (!isnum(str[tmp])) {
                                return false;
                            }
                        }
                        return true;
                    } else return false;
                } else return false;
            } else if ((str[i] <= 'z' && str[i] >= 'a') || (str[i] <= 'Z' && str[i] >= 'A') || str[i] == '+' || str[i] == '-') {
                return false;
            } else if (str[i] == '.') {
                for (int tmp = i+1; tmp < len; tmp++) {
                    if (!isnum(str[tmp])) {
                        return false;
                    }
                }
                return true;
            }
            i++;
        }
        return true;
    }

    private boolean isnum(char c) {
        return c <= '9' && c >= '0';
    }*/


    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        s = s.replaceAll(" ","%20");
        return s;
    }

    /*链表的归并排序*/
    public ListNode sortList(ListNode head) {

        return head == null? null: mergesort(head);
    }
    public ListNode mergesort(ListNode head){
        if( head.next == null){
            return head;
        }
        //找到链表中间节点的方法并***断链***
        ListNode pre = head,fast = head, slow = head;
        while(fast!=null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l1 = mergesort(head);
        ListNode l2 = mergesort(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode head, ListNode tail){
        ListNode cur = new ListNode(0);
        ListNode new_head = cur;
        while(head!=null && tail != null){
            if(head.val>tail.val){
                cur.next = tail;
                tail = tail.next;
            }else{
                cur.next = head;
                head = head.next;
            }
            cur = cur.next;
        }
        if(head!=null){
            cur.next = head;
        }
        if(tail!=null){
            cur.next = tail;
        }
        return new_head.next;
    }

    /*合并k个排序链表*/
    ListNode[] list;
    public ListNode mergeKLists(ListNode[] lists) {
        list = lists;
        int k = lists.length;
        if(k ==0){
            return null;
        }
        return mergesortKlist(0,k-1);
    }
    public ListNode mergesortKlist(int start,int end){
        if(end == start){
            if(list[start] == null){
                return null;
            }
            return list[start];
        }
        int mid = (end+start)/2;
        ListNode l1 = mergesortKlist(start,mid);
        ListNode l2 = mergesortKlist(mid+1,end);
        return merge(l1,l2);
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode head = root;
        while(root!=null){
            root = root.next;
            len++;
        }
        int mod = len%k;
        int size = len/k;
        root = head;
        ListNode[] lists = new ListNode[k];
        for(int i = 0; i< k;i++) {
            lists[i] = root;
            int curSize = mod == 0 ? size : size + 1;
            for (int j = 0; j < curSize; j++) {
                head = root;
                root = root.next;
            }
            head.next = null;
            mod--;
        }
        return lists;
    }


    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList();
        int i = 0,j=i+1;
        int n = num.length;
        int tmp = num[i];
        while(j<n && j<i+size){
            if(num[j]>num[i]){
                tmp = num[j];
            }
        }
        result.add(tmp);
        for(i =1;i<n-size+1;i++){
            j = i+size-1;
            tmp = num[i];
            if(num[j]>result.get(i-1)){
                tmp = num[j];
            }
            result.add(tmp);
        }
        return result;
    }
    public static void main(String[] args) {
        offer o = new offer();
        StringBuffer s = new StringBuffer("");
        String str = o.replaceSpace(s);
        System.out.println(str);
    }

}

