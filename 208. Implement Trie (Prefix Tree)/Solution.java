class Trie {

    static class Node{
        Node[] child;
        boolean eow;

        Node(){
            child=new Node[26];
        }
    }
    static Node root;

    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
        }
        curr.eow=true;
    }
    
    public boolean search(String word) {
        Node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.child[idx]==null)return false;

            curr=curr.child[idx];
        }
        return curr.eow;
    }
    
    public boolean startsWith(String word) {
        Node curr=root;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';

            if(curr.child[idx]==null)return false;

            curr=curr.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
