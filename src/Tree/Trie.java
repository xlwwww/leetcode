package Tree;

/**
 * @author cutiewang
 * @date 2020/2/27 22:01
 */
public class Trie {
    /** Initialize your data structure here. */
    private class TrieNode{
        //isLeaf是用来标记该节点是否构成单词的
        boolean isLeaf = false;
        TrieNode[] children = new TrieNode[26];
        TrieNode(){

        }
    }
    private TrieNode root = new TrieNode();
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word,root);
    }

    private void insert(String word,TrieNode root){
        int len = word.length();
        if(len == 0) {
            root.isLeaf = true;
            return ;
        }
        int index = word.charAt(0)-'a';
        if(root.children[index]==null){
            root.children[index] = new TrieNode();
        }
        insert(word.substring(1),root.children[index]);
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word,root);
    }
    private boolean search(String word,TrieNode root){
        if(root == null) return false;
        if(word.length() == 0 && root.isLeaf) return true;
        if(word.length() == 0) return false;
        int index = word.charAt(0)-'a';
        if(root.children[index] == null) return false;
        return search(word.substring(1),root.children[index]);
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(prefix,root);
    }
    private boolean startsWith(String prefix,TrieNode root){
        if(root == null) return false;
        if(prefix.length() == 0) return true;
        int index = prefix.charAt(0)-'a';
        if(root.children[index] == null) return false;
        return startsWith(prefix.substring(1),root.children[index]);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
//        System.out.println(trie.search("app"));
//        String word = "cutiebaby";
//        System.out.println(word.substring(10));
    }
}
