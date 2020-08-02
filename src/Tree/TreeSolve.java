package Tree;

import java.util.*;

/**
 * @author cutiewang
 * @date 2020/2/9 10:11
 */
public class TreeSolve {
    //按层次遍历构建二叉树
    public TreeNode buildTree(int[] lists){
        int N = lists.length;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(lists[0]);
        TreeNode tmp ;
        queue.add(node);
        int i = 1;
        while(!queue.isEmpty() && i<N){
            tmp = queue.poll();
//            System.out.println(tmp.val);
            TreeNode left,right;
            if(lists[i] == -100){
                left = null;
                i++;
            }else left = new TreeNode(lists[i++]);
            if(lists[i] == -100){
                right = null;
                i++;
            }else right = new TreeNode(lists[i++]);
            tmp.left = left;
            tmp.right = right;
            if(left!=null){
                queue.add(left);
            }
            if(right!=null) {
                queue.add(right);
            }
        }
        return node;
    }

    //层次遍历
    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    //判断是否为平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if (Math.abs(findDepth(root.left)-findDepth(root.right))>1){
            return false;
        }else return true;
    }

    public int findDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(findDepth(root.left),findDepth(root.right))+1;
    }

    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        //对所有节点dfs
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()){
            tmp = queue.poll();
            if(tmp.left!=null) queue.add(tmp.left);
            if(tmp.right!=null) queue.add(tmp.right);
            dfs(tmp,sum,0);
        }
        return ans;
    }
    public void dfs(TreeNode root, int sum, int cur){
        if(root == null){
            return;
        }
        cur = cur + root.val;
        if(cur == sum){
            ans++;
            return;
        }
        dfs(root.left,sum,cur);
        dfs(root.right,sum,cur);
    }

    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        this.nums = nums;
        return help(0,nums.length-1);
    }
    public TreeNode help(int start, int end){
        if(start>end) return null;
        int mid = (end+start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(start,mid-1);
        root.right = help(mid+1,end);
        return root;
    }


    List<Integer> list = new ArrayList<>();
    TreeNode pre;
    int max = 0;
    int cur = 1;
    public int[] findMode(TreeNode root) {
        if(root==null) {
            return new int[] {};
        }
        inorder(root);
        int[] a = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            a[i]=list.get(i);
        }
        return a;
    }
    private void inorder(TreeNode root) {
        if(root==null) {
            return ;
        }
        inorder(root.left);
        if(pre!=null) {
            if(pre.val==root.val) {
                cur++;
            }
            else {
                cur=1;
            }
        }
        if(cur==max) {
            list.add(root.val);
        }
        if(cur>max) {
            list.clear();
            list.add(root.val);
            max=cur;
        }
        pre=root;
        inorder(root.right);
    }


    public static void main(String[] args) {
//        //1.测试层次遍历构建二叉树
//        int[] l = {6,2,8,0,4,7,9,-100,-100,3,5};
//        TreeNode root = new TreeNode(6);
//        TreeNode n1 = new TreeNode(2);
//        TreeNode n2 = new TreeNode(8);
//        TreeNode n3 = new TreeNode(0);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(7);
//        TreeNode n6 = new TreeNode(9);
//        TreeNode n7 = new TreeNode(3);
//        TreeNode n8 = new TreeNode(5);
//        root.left = n1;
//        root.right = n2;
//        n1.left = n3;
//        n1.right = n4;
//        n2.left = n5;
//        n2.right =n6;
//        n4.left = n7;
//        n4.right = n8;
        TreeSolve solve = new TreeSolve();
        int[] num = new int[]{-10,-3,0,5,9};
        TreeNode root= solve.sortedArrayToBST(num);
        solve.levelOrder(root);
    }
}
