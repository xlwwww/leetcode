package search;

import java.util.*;

/**
 * @author cutiewang
 * @date 2020/2/25 15:50
 */
public class DfsSolve {
    int[][] grid;
    int N;
    static int ans = Integer.MAX_VALUE;
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        this.grid = grid;
//        N = grid.length;
//        ans = N*N+1;
//        int[][] visited = new int[N][N];
//        dfs(0,0,1,visited);
//        return ans==(N*N+1)?-1:ans;
//    }
//    public void dfs(int i,int j,int res,int[][] visited){
//        if(i == N-1 && j == N-1){
//            if(res<ans){
//                ans = res;
//            }
//            return ;
//        }
//        if(i<0 || i>=N || j<0 || j>= N || grid[i][j] == 1 || visited[i][j] == 1){
//            return ;
//        }
//        res++;
//        visited[i][j] = 1;
//        dfs(i+1,j,res,visited);
//        dfs(i-1,j,res,visited);
//        dfs(i,j-1,res,visited);
//        dfs(i,j+1,res,visited);
//        dfs(i-1,j-1,res,visited);
//        dfs(i-1,j+1,res,visited);
//        dfs(i+1,j-1,res,visited);
//        dfs(i+1,j+1,res,visited);
//        visited[i][j] = 0;
//    }
////    int[] map;
////    public int cutRope(int target) {
////        map = new int[target];
////        Arrays.fill(map,-1);
////        if(target == 2) return 1;
////        else if(target == 3) return 2;
////        return help(target);
////    }
////    private int help(int target){
////        if(target <=4) return target;
////        int m = 0;
////        for(int i = 2;i<target;i++){
////            if(map[target-i]==-1){
////                map[target-i] = help(target-i);
////            }
////            m = Math.max(m,i * map[target-i]);
////        }
////        return m;
////    }
//
//    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
//    {
//        char[][] m = new char[rows][cols];
//        int k = 0;
//        for(int i =0;i<rows;i++){
//            for(int j =0;j<cols;j++){
//                m[i][j] = matrix[k++];
//            }
//        }
//        int[][] visited = new int[rows][cols];
//        for(int i =0;i<m.length;i++){
//            for(int j = 0;j<m[0].length;j++){
//                if(m[i][j] == str[0]){
//                    if(dfs(m,str,0,i,j,visited)) return true;
//                }
//            }
//        }
//        return false;
//    }
//    private boolean dfs(char[][] m, char[] str,int pos,int row,int col,int[][] visited){
//        if(row<0 || row>=m.length || col<0 || col>=m[0].length) return false;
//        if(m[row][col]!=str[pos] || visited[row][col] == 1) return false;
//        visited[row][col] = 1;
//        if(pos == str.length-1) return true;
//        if(dfs(m,str,pos+1,row+1,col,visited) || dfs(m,str,pos+1,row-1,col,visited)||
//                dfs(m,str,pos+1,row,col-1,visited)|| dfs(m,str,pos+1,row,col+1,visited)){
//            return true;
//        }
//        visited[row][col] = 0;
//        return false;
//    }
//
//    public ArrayList<String> Permutation(String str) {
//        ArrayList<String> list = new ArrayList();
//        int len = str.length();
//        int[] visited = new int[len];
//        dfs(list,"",str,visited);
//        HashSet<String> set = new HashSet<>(list);
//        ArrayList<String> ans = new ArrayList(set);
//        Collections.sort(ans);
//        return ans;
//
//    }
//    public void dfs(ArrayList<String> list, String tmp,String str,int[] visited){
//        if(str.equals("")) return ;
//        if(tmp.length() == str.length()){
//            list.add(tmp);
//            return;
//        }
//        for(int i = 0;i<str.length();i++){
//            if(visited[i]==0){
//                //not visited
//                visited[i] = 1;
//                dfs(list,tmp+str.charAt(i),str,visited);
//                visited[i] = 0;
//            }
//        }
//    }
//    HashMap<Integer,Integer> map = new HashMap();
//    public int countDigitOne(int n) {
//        if(n < 10) return 1;
//        if(map.containsKey(n)) return map.get(n);
//        int num=n,pow=1;
//        while(n>9){
//            n = n/10;
//            pow *= 10;
//        }
//        int last = num-n*pow;
//        int sum = countDigitOne(pow-1)+last+1+countDigitOne(last);
//        map.put(num,sum);
//        return sum;
//    }
    public static void dfs(char[][] map,boolean[][] visited,char pre,int cur,int curx,int cury,int ex,int ey){
        if(cur>=ans) return;
        if(curx == ex && cury == ey){
            if(pre == 'S' && map[curx][cury] == 'S') cur += 2;
            else if (pre == 'C' && map[curx][cury] == 'C') cur += 3;
            else cur+=5;
            ans = Math.min(ans,cur);
            return;
        }
        if(curx >= map.length || curx<0 || cury >=map[0].length || cury<0 || visited[curx][cury]) return;
        visited[curx][cury] = true;
        if(pre!='N'){
            if(pre == 'S' && map[curx][cury] == 'S') {
                dfs(map,visited,map[curx][cury],cur+2,curx+1,cury,ex,ey);
                dfs(map,visited,map[curx][cury],cur+2,curx-1,cury,ex,ey);
                dfs(map,visited,map[curx][cury],cur+2,curx,cury+1,ex,ey);
                dfs(map,visited,map[curx][cury],cur+2,curx,cury-1,ex,ey);
            }
            else if (pre == 'C' && map[curx][cury] == 'C') {
                dfs(map,visited,map[curx][cury],cur+3,curx+1,cury,ex,ey);
                dfs(map,visited,map[curx][cury],cur+3,curx-1,cury,ex,ey);
                dfs(map,visited,map[curx][cury],cur+3,curx,cury+1,ex,ey);
                dfs(map,visited,map[curx][cury],cur+3,curx,cury-1,ex,ey);
            }
            else {
                dfs(map,visited,map[curx][cury],cur+5,curx+1,cury,ex,ey);
                dfs(map,visited,map[curx][cury],cur+5,curx-1,cury,ex,ey);
                dfs(map,visited,map[curx][cury],cur+5,curx,cury+1,ex,ey);
                dfs(map,visited,map[curx][cury],cur+5,curx,cury-1,ex,ey);
            }
        }else{
            dfs(map,visited,map[curx][cury],cur,curx+1,cury,ex,ey);
            dfs(map,visited,map[curx][cury],cur,curx-1,cury,ex,ey);
            dfs(map,visited,map[curx][cury],cur,curx,cury+1,ex,ey);
            dfs(map,visited,map[curx][cury],cur,curx,cury-1,ex,ey);
        }
        visited[curx][cury] = false;
    }

        public static void main(String[] args) {
//         int[][] grid = new int[][]{{0,1,0,0,1,1,0},{1,0,0,0,0,0,0},{1,0,0,1,1,1,1},{0,1,0,0,0,0,0},{1,0,0,0,0,0,1},{1,0,0,1,0,0,0},{1,0,1,0,0,1,0}};
//        //int[][] grid = new int[][]{{0,1},{1,0}};
//        DfsSolve s = new DfsSolve();
//        char[] ma = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
//        char[] str = new char[]{'a','b','c','b'};
////        System.out.println(s.hasPath(ma,3,4,str));
//        s.countDigitOne(12);
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] map = new char[n][m];
            for(int i = 0;i<n;i++){
                String tmp = in.next();
                for(int j = 0;j<tmp.length();j++){
                    map[i][j] = tmp.charAt(j);
                }
            }
            int bx = in.nextInt();
            int by = in.nextInt();
            int ex = in.nextInt();
            int ey = in.nextInt();
            boolean[][] visited = new boolean[n][m];
            dfs(map,visited,'N',0,bx-1,by-1,ex-1,ey-1);
            System.out.println(ans);
    }
}
