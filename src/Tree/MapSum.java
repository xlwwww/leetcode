package Tree;

class MapSum {
    private class TrieNode{
        int cnt = 0;
        TrieNode[] children = new TrieNode[26];
    }
    private TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for(int i =0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index] = new TrieNode();
            }
            if(i == key.length()-1) node.children[index].cnt = val;
            node = node.children[index];
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for(int i = 0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            node = node.children[index];
        }
        return dfs(node);
    }
    private int dfs(TrieNode root){
        if(root == null) return 0;
        int sum = root.cnt;
        for(int i = 0;i<26 && root.children[i]!=null;i++){
            sum += dfs(root.children[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa",3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("ab",2);
        System.out.println(mapSum.sum("a"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */