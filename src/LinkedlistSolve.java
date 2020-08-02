import Tree.TreeNode;

/**
 * @author cutiewang
 * @date 2020/2/25 21:01
 */
public class LinkedlistSolve {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode p= head,q=head,pre=head;
        while(q.next!=null && q.next.next!=null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        //q = p.next;
        pre.next = null;

        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}
