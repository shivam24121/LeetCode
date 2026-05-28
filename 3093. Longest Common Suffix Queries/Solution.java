class Solution {

    class Pair{
        String s;
        int index;

        Pair(String s,int i){
            this.s=s;
            this.index=i;
        }
    }

    class Node{

        Node[] child;
        boolean eow;
        PriorityQueue<Pair> pq;

        Node(){
            child=new Node[26];
            eow=false;
            pq=new PriorityQueue<>((a,b)->{
                if(a.s.length()==b.s.length()){
                    return a.index-b.index;
                }
                return a.s.length()-b.s.length();
            });
        }
    }
    public Node root;

    public int ask(String s){
        int n=s.length();
        Node curr=root;
        int ans=-1;

        for(int i=0;i<n;i++){
            
            int idx=s.charAt(i)-'a';
            if(curr.child[idx]==null){
                return ans;
            }
            curr=curr.child[idx];
            ans=curr.pq.peek().index;
        }
        return ans;
    }
    public void insert(String s , int id){

        int n=s.length();
        Node crawl=root;

        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            if(crawl.child[idx]==null){
                crawl.child[idx]=new Node();
            }
            crawl=crawl.child[idx];
            crawl.pq.offer(new Pair(s,id));
            if(crawl.pq.size()>1){
                Pair tempo=crawl.pq.poll();
                crawl.pq.clear();
                crawl.pq.offer(tempo);
            }
        }
        crawl.eow=true;
    }
    public int[] stringIndices(String[] words, String[] query) {
        
        int n=words.length;
        root=new Node();

        int temp=-1;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            String s=words[i];
            String rev=new StringBuilder(s).reverse().toString();
            if(s.length()<min){
                min=s.length();
                temp=i;
            }

            insert(rev,i);
        }
        int ansN=query.length;

        int[] ans=new int[ansN];

        for(int i=0;i<ans.length;i++){
            String rev=new StringBuilder(query[i]).reverse().toString();
            int res=ask(rev);
            ans[i]=res==-1?temp:res;
        }
        return ans;
    }
}
