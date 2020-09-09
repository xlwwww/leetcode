package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.*;


/**
 * @author cutiewang
 * @date 2020/8/4 10:49
 */
public class ArrayTest {


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] arr = new int[m];
//        HashSet<Integer> set = new HashSet<>();
//        int i =0, j = 0;
//        for(i =0;i<m;i++){
//            arr[i] = in.nextInt();
//            set.add(arr[i]);
//        }
//        if(n == m){
//            for(i=0;i<n-1;i++){
//                System.out.print(arr[i]);
//                System.out.print(" ");
//            }
//            System.out.print(arr[i]);
//            return;
//        }
//        int[] arr2 = new int[n-m]; //1,3,5
//        int k =0;
//        for(i =1;i<=n;i++){
//            if(!set.contains(i)) {
//                arr2[k] = i;
//                k++;
//            }
//        }
//        for(i =0,j=0;i<arr.length && j<arr2.length ; ){
//            if(arr2[j]<arr[i]){
//                System.out.print(arr2[j]);
//                System.out.print(" ");
//                j++;
//            }else {
//                System.out.print(arr[i]);
//                System.out.print(" ");
//                i++;
//            }
//        }
//        while(i<arr.length-1) {
//            System.out.print(arr[i]);
//            System.out.print(" ");
//            i++;
//        }
//        if(i == arr.length-1) System.out.print(arr[i]);
//        while(j<arr2.length) {
//            System.out.print(arr2[j]);
//            System.out.print(" ");
//            j++;
//        }
//        if(j == arr2.length-1) System.out.print(arr2[j]);
//    }

    //去除 某些元素，使得剩下元素可以平分
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while(t>0){
//            t--;
//            int n = in.nextInt();
//            List<Integer> arr = new ArrayList<>();
//            int sum = 0;
//            for(int i=0;i<n;i++){
//                int m = in.nextInt();
//                arr.add(m);
//                sum+=m;
//            }
//            Collections.sort(arr);
//            int ret = 0;
//            for(int i =0;i<n;i++){
//                ret = arr.get(i);
//                arr.remove(i);
//                if((sum-ret)%2==0 && cut(arr,(sum-ret)/2)) {
//                    System.out.println(ret);
//                    return;
//                }else arr.add(i,ret);
//            }
//            Random r = new Random();
//            System.out.println(arr.get(r.nextInt(n)));
//        }
//    }
//    public static boolean cut(List list,int target){
//
//    }
//     static HashSet<ArrayList<Integer>> set = new HashSet<>();
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         int n = in.nextInt();
//         boolean[] visited = new boolean[n+1];
//         Arrays.fill(visited,false);
//         for(int i = 1;i<=n;i++){
//             visited[i] = true;
//             ArrayList tmp = new ArrayList<Integer>();
//             tmp.add(i);
//             dfs(i,n,tmp,visited);
//             visited[i] = false;
//         }
//         for(ArrayList list:set){
//             for(Object i :list){
//                 System.out.print(i);
//                 System.out.print(' ');
//             }
//             System.out.println();
//         }
//     }
//     public static void dfs(int cur,int n,ArrayList list,boolean[] visited){
//        if(list.size() == n){
//            set.add(new ArrayList(list));
//            return;
//        }
//        for(int i = 1;i<=n;i++){
//            if(!visited[i] && (cur-i != 1 && i -cur != 1)){
//                list.add(i);
//                visited[i] = true;
//                dfs(i,n,list,visited);
//                list.remove(list.size()-1);
//                visited[i] = false;
//            }
//        }
//        return;
////     }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int digits = 1;
//        int tmp = n;
//        while(tmp>3){
//            tmp = tmp/3;
//            digits++;
//        }
//        int d = digits;
//        int[] base = new int[]{2,3,5};
//        if(d == 1){
//            System.out.println(base[n-1]);
//            return;
//        }
//        StringBuilder sb = new StringBuilder();
//        int baseD = (int) Math.pow(3,d-1);
//        while(d>0){
//            int idx = (int) (n/baseD);
//            int h = base[idx];
//            n =  (n/3);
//            sb.append(h);
//            d--;
//        }
//        System.out.println(sb.reverse().toString());
//    }

/*
        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            char[] tt = in.readLine().trim().toCharArray();
            int n = tt[0]-'0';
        int[][] map = new int[n][2*n];
        for(int i =0;i<n;i++){
            String tmp = in.readLine().trim();
            int k = 0;
            for(Character c:tmp.toCharArray()){
                if(c!=' '){
                    map[i][k++] = c-'0';
                }
            }
        }
        for(int i =n-2;i>=0;i--){
            for(int j = 0;j+2<2*n;j++){
                map[i][j] = map[i][j]+ Math.max(Math.max(map[i+1][j],map[i+1][j+1]),map[i+1][j+2]);
            }
        }
        System.out.println(map[0][0]);
    }
*/

//public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int n = in.nextInt();
//    int x = in.nextInt();
//    int y = in.nextInt();
//    HashMap<Integer,Node> map = new HashMap<>();
//    int[][] relations = new int[n-1][2];
//    for(int i = 0;i<n-1;i++){
//        int val1 = in.nextInt();
//        int val2 = in.nextInt();
//        relations[i][0] = Math.min(val1, val2);
//        relations[i][1] = Math.max(val1, val2);
//    }
//    Arrays.sort(relations, new Comparator<int[]>() {
//        @Override
//        public int compare(int[] ints, int[] t1) {
//            return ints[0]-t1[0];
//        }
//    });
//    int max = 0;
//    for(int i =0;i<n-1;i++){
//        Node node1,node2;
//        int val1 = relations[i][0];
//        int val2 = relations[i][1];
//        if(!map.containsKey(val1)){
//            node1 = new Node(val1);
//            map.put(val1,node1);
//        }else node1 = map.get(val1);
//        if(!map.containsKey(val2)){
//            node2 = new Node(val2);
//            map.put(val2,node2);
//        }else node2 = map.get(val2);
//        List Nodes = node1.nexts;
//        if(Nodes == null){
//            Nodes = new ArrayList();
//        }
//        Nodes.add(node2);
//        node1.nexts = Nodes;
//        node2.parent = node1;
//        node2.level = node1.level+1;
//    }
//    Node tuan = map.get(y);
//    Node mei = map.get(x);
//    Node root = map.get(1);
//    //
//    max = maxPath(tuan,0);
//    Node parents = root;
//    while(tuan!=null){
//        if(tuan.val == mei.val) {
//            parents = mei;
//            break;
//        }
//        tuan = tuan.parent;
//    }
//    if(parents==root){
//        System.out.println(mei.level+max+1);
//    }else System.out.println(max-mei.level+1);
//}
//public static int maxPath(Node node,int max){
//    if(node == null) return 0;
//    if(node.nexts == null) return 1;
//    for(Node succ:node.nexts){
//        max = Math.max(maxPath(succ,max+1),max);
//    }
//    return max;
//}
//}
//
//
//class Node{
//    int val;
//    int level=0;
//    List<Node> nexts;
//    Node parent;
//    Node(int value){
//        this.val = value;
//    }
//}



//    面试官
//    小Q在进行射击气球的游戏，如果小Q在连续T枪中打爆了所有颜色的气球，将得到一只QQ公仔作为奖励。（每种颜色的气球至少被打爆一只）。这个游戏中有m种不同颜色的气球，编号1到m。小Q一共有n发子弹，然后连续开了n枪。小Q想知道在这n枪中，打爆所有颜色的气球最少用了连续几枪？
//    输入描述：
//    第一行两个空格间隔的整数数n，m。n<=1000000 m<=2000
//    第二行一共n个空格间隔的整数，分别表示每一枪打中的气球的颜色,0表示没打中任何颜色的气球。
//    输出描述：
//    一个整数表示小Q打爆所有颜色气球用的最少枪数。如果小Q无法在这n枪打爆所有颜色的气球，则输出-1
//    示例
//    输入：
//            12 5
//            2 5 3 1 3 2 4 1 0 5 4 3
//    输出：
//            6
//
//    test
//12 5
//        2 5 3 1 3 2 4 1 5 0 4 3
//        5

//public static void main(String[] args) {
//    int[] arr = new int[]{2,5,3,1,3,2,4,1,0,5,4,3};
//    int len = arr.length-1;
//    int n = 5;
//    int i =0,j=0;
//    int res = len;
//    HashMap<Integer,Integer> map = new HashMap<>();
//    for(;i<=len && j<=len;){
//        //算[i,j]的最小区间
//        if(arr[j]!=0) map.put(arr[j],map.getOrDefault(arr[j],0)+1);
//        if(map.size()>=n){
//            if(arr[i] == 0) i++;
//            while(map.get(arr[i])>1){
//                map.put(arr[i],map.get(arr[i])-1);
//                i++;
//            }
//            res = Math.min(res,j-i+1);
//        }
//        //下一步是扩大区间遍历
//        j++;
//    }
//    System.out.println(res);
//}
    public void merge(int[][] arrs){
        int k = arrs.length;
        int[] get = help(arrs,0,k-1);
        for(Integer t:get){
            System.out.print(t);
            System.out.print(" ");
        }
    }

    // 分治
    public int[] help(int[][] arrs,int start,int end){
        if(start>end) return null;
        if(start == end) return arrs[start];
        if(end-start == 1){
           return mergeTwo(arrs[start],arrs[end]);
        }
        return mergeTwo(help(arrs,start,end/2),help(arrs,end/2+1,end));
    }

    //merge two lists
    public int[] mergeTwo(int[] arr1,int[] arr2){
        int[] ret= new int[arr1.length+arr2.length];
        int i = arr1.length-1,j = arr2.length-1,k=ret.length-1;
        while(i>=0 || j>=0){
            if(i<0){
                ret[k--] = arr2[j--];
            }else if(j<0){
                ret[k--] = arr1[i--];
            }else if(arr1[i]>arr2[j]){
                ret[k--] = arr1[i--];
            }else if(arr1[i]<arr2[j]){
                ret[k--] = arr2[j--];
            }else{
                ret[k--] = arr1[i--];
                ret[k--] = arr2[j--];
            }
        }
        return ret;
    }
    //[2,4,-1,1,7,6,3,-2,3] & k=6 时，value=4
    //前缀和
    public int findSub(int[] arr,int k){
        int i=0;
        int preCount = 0;
        HashMap<Integer,Integer> map =new HashMap<>();
        int res = 0;
        map.put(0,-1);
        while(i<arr.length){
            preCount += arr[i];
            if(map.containsKey(k-preCount)){
                res = Math.max(res,i-map.get(k-preCount));
            }else map.put(preCount,i);
            i++;
        }
        return res;
    }
//    public int getMinScore (int[] gz) {
//        // write code here
//        int n = gz.length;
//        LinkedList<Integer> list = new LinkedList<>();
//        for(Integer i:gz){
//            list.add(i);
//        }
//        int ret=0,minC;
//        while(list.size()>1){
//            minC = Integer.MAX_VALUE;
//            for(int i = 1;i<list.size();i++){
//                minC = Math.min(list.get(i)+list.get(i-1),minC);
//            }
//            for(int i = 1;i<list.size();i++){
//                if(list.get(i)+list.get(i-1) == minC){
//                    ret += minC;
//                    list.remove(i);
//                    list.remove(i-1);
//                    list.add(i-1,minC);
//                    break;
//                }
//            }
//        }
//        return ret;
//    }
//    public int getMinLen (String str) {
//        // write code here
//        int n = str.length();
//        StringBuffer sb= new StringBuffer(str);
//        char[] ss = sb.reverse().toString().toCharArray();
//        int[][] dp = new int[n+1][n+1];
//        int ret = n;
//        for(int i =1;i<n;i++) {
//            for (int j = 1; j < n; j++) {
//                if (str.charAt(i) == ss[j]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return n-dp[n-1][n-1];
//    }
//            for(int i =1;i<k;i++){
//        if(red[i][1]<pre){
//            red[i][0] = preMinIdx;
//        }else{
//            pre = red[i][1];
//            preMinIdx = red[i][0];
//        }
//        rmap.put(red[i][1],preMinIdx);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] red = new int[n][2];
//        int[][] blue = new int[n][2];
//        int sumR = 0,j=0,k=0,sumB=0;
//        for(int i =0;i<n;i++){
//            int num = sc.nextInt();
//            int color = sc.nextInt();
//            if(color ==1){
//                red[k][0] = i+1; //idx
//                red[k][1] = num;//number
//                k++;
//                sumR +=num;
//            }else if(color == 2){
//                blue[j][0] = i+1; //idx
//                blue[j][1] = num;//number
//                j++;
//                sumB +=num;
//            }
//        }
//        int ansR = 0;
//        int a1 = 0,a2=0,a3=0;
//        int reqR = (int) Math.ceil(sumR/2);
//        int reqB = (int) Math.ceil(sumB/2);
//        boolean hasFindR = false;
//        for(int i =0;i<k && !hasFindR;i++){
//            for(int t =i+1;t<k && !hasFindR;t++){
//                for(int m = t+1;m<k && !hasFindR;m++){
//                    if(red[i][1]+red[t][1]+red[m][1]>=reqR){
//                        ansR = red[i][0]+red[j][0]+red[m][0];
//                        a1 = red[i][0];
//                        a2= red[t][0];
//                        a3 = red[m][0];
//                        hasFindR = true;
//                        break;
//                    }
//                }
//            }
//        }
//        for(int i =0;i<j ;i++){
//            for(int t =i+1;t<j;t++){
//                for(int m = t+1;m<j;m++){
//                    if(blue[i][1]+blue[t][1]+blue[m][1]>=sumB- && ( blue[i][0]+blue[j][0]+blue[m][0]<ansR || ansR ==0)){
//                        ansR = blue[i][0]+blue[j][0]+blue[m][0];
//                        System.out.print(blue[i][0]+" ");
//                        System.out.print(blue[t][0]+" ");
//                        System.out.print(blue[m][0]);
//                        System.out.println();
//                        System.out.println(2);
//                        System.out.println(blue[i][1]+blue[t][1]+blue[m][1]);
//                        return;
//                    }
//                }
//            }
//        }
//        if(a1 == 0) {System.out.println("null"); return;}
//        System.out.print(a1+" ");
//        System.out.print(a2+" ");
//        System.out.print(a3);
//        System.out.println();
//        System.out.println(1);
//        System.out.println(ansR);
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] ss = in.nextLine().split(",");
//        if(ss.length<2) {
//            System.out.println(0);
//            return;
//        }
//        int m = Integer.parseInt(ss[0]);
//        int n =Integer.parseInt(ss[1]);
//        char[][] grid = new char[m][n];
//        int[][] visited = new int[m][n];
//        for(int i =0;i<m;i++){
//            grid[i] = in.nextLine().trim().toCharArray();
//        }
//        int ans =0;
//        for(int i =0;i<m;i++){
//            for(int j =0;j<n;j++){
//                if(visited[i][j]==0 && grid[i][j]=='S'){
//                    ans++;
//                    dfs(grid,visited,i,j);
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//    public static void dfs( char[][] grid,int[][] visited,int i, int j){
//        if(i<0 ||i>=grid.length || j<0 || j>=grid[0].length ||grid[i][j] =='H' ||visited[i][j]==1) return;
//        visited[i][j] = 1;
//        dfs(grid,visited,i+1,j);
//        dfs(grid,visited,i-1,j);
//        dfs(grid,visited,i,j+1);
//        dfs(grid,visited,i,j-1);
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while(t>0){
//            t--;
//            int n = in.nextInt();
//            int m = in.nextInt();
//            //多个特征
//            List<List> map = new LinkedList<>();
//            for(int i =0;i<m;i++){
//                int k = in.nextInt();
//                //一个特征
//                List<int[]> arr = new ArrayList<>();
//                for(int j =0;j<k;j++){
//                    int left = in.nextInt();
//                    int right = in.nextInt();
//                    int[] qu = new int[]{left,right};
//                    arr.add(qu);
//                }
//                Collections.sort(arr, new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] ints, int[] t1) {
//                        if(ints[0] == t1[0]) return ints[1]-t1[1];
//                        return ints[0]-t1[0];
//                    }
//                });
//                map.add(arr);
//            }
//            List<int[]> ret = new ArrayList<>();
//            int sum = 0;
//            if(m== 1){
//                List<int[]> tmp = map.get(0);
//                for(int i =0;i<tmp.size();i++){
//                    sum  += tmp.get(i)[1]-tmp.get(i)[0]+1;
//                }
//                System.out.println(sum);
//                for(int i =0;i<tmp.size();i++){
//                    int left = tmp.get(i)[0];
//                    int right = tmp.get(i)[1];
//                    while(left<=right){
//                        System.out.print(left++);
//                        System.out.print(" ");
//                    }
//                }
//                return;
//            }
//            ret = compare(map.get(0),map.get(1));
//            for(int i = 2;i<map.size()-1;i+=2){
//                ret = compare(ret,compare(map.get(i),map.get(i+1)));
//            }
//            //sout ret
//            for(int i =0;i<ret.size();i++){
//                sum  += ret.get(i)[1]-ret.get(i)[0]+1;
//            }
//            System.out.println(sum);
//            for(int i =0;i<ret.size();i++){
//                int left = ret.get(i)[0];
//                int right = ret.get(i)[1];
//                while(left<=right){
//                    System.out.print(left++);
//                    System.out.print(" ");
//                }
//            }
//        }
//    }
//    public static List<int[]> compare(List<int[]> a, List<int[]> b){
//        List<int[]> ret = new ArrayList<>();
//        int i =0,j=0;
//        while(i<a.size() && j<b.size()){
//            int left = Math.max(a.get(i)[0],b.get(j)[0]);
//            int right = Math.min(a.get(i)[1],b.get(j)[1]);
//            if(left<=right){
//                ret.add(new int[]{left,right});
//                if(a.get(i)[1]<b.get(j)[1]){
//                    i++;
//                }else j++;
//            }else{
//                if(a.get(i)[0]>b.get(j)[1]) j++;
//                else if(a.get(i)[1]<b.get(j)[0]) i++;
//            }
//        }
//        return ret;
//    }

}