import java.util.*;

public class Trie{
    static class TrieNode{
        Map<Character , TrieNode> children = new HashMap<>();
    }
    
    TrieNode root = new TrieNode();
    char endsymbol = '*';
    
    public Trie(String str){
        SuffixTrie(str);
    }
    public void SuffixTrie(String str){
        for(int i=0;i<str.length();i++){
            InsertSubstring(i,str);
        }
    }
    public void InsertSubstring(int index,String str){
        TrieNode node = root;
        for (int i=index;i<str.length();i++) {
            char letter = str.charAt(i);
            if(!node.children.containsKey(letter)){
                TrieNode newnode = new TrieNode();
                node.children.put(letter,newnode);
            }
                node = node.children.get(letter);
            
        }
        node.children.put(endsymbol,null);
    }
    public boolean contains(String str){
        TrieNode node = root;
        for(int i =0;i<str.length();i++){
            char letter = str.charAt(i);
            if(!node.children.containsKey(letter)){
                return false;
            }
            node = node.children.get(letter);
        }
        return node.children.containsKey(endsymbol);
    }
    public static void main (String[] args) {
        Trie trie =new Trie("Mannan");
        System.out.println(trie.contains("naan"));
    }
}