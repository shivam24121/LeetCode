class Solution {

    int n,m;

    int[] dx={1,0,0,-1};
    int[] dy={0,-1,1,0};

    class Node{

        boolean eow;
        String word;
        Node[] child;

        Node(){
            eow=false;
            word="";
            child=new Node[26];
        }
    }
    Node root=new Node();

    public void insert(String word,Node head){
        int n=word.length();
        Node root=head;

        for(int i=0;i<n;i++){
            int idx=word.charAt(i)-'a';
            if(root.child[idx]==null){
                root.child[idx]=new Node();
            }
            root=root.child[idx];
        }
        root.eow=true;
        root.word=word;
    }

    public List<String> findWords(char[][] grid, String[] words) {

        root=new Node();
        List<String>res=new ArrayList<>();
        for(String s:words){
            insert(s,root);
        }
        n=grid.length;
        m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(i,j,root,res,grid);
            }
        }
        return res;
    }
    public void dfs(int x,int y,Node node,List<String>res,char[][] word){

        if(x<0 || x==n || y<0 || y==m || word[x][y]=='0')return;
        
        char temp=word[x][y];
        Node root=node.child[temp-'a'];

        if(root==null)return;

        if(root.eow){
            res.add(root.word);
            root.eow=false;
        }

        word[x][y]='0';

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];

            if(xx<0 || xx==n || yy<0 || yy==m)continue;

            dfs(xx,yy,root,res,word);
        }
        word[x][y]=temp;
    }
}
