class Solution {
    
    Map<Integer,int[]>map=new HashMap<Integer,int[]>();

    public void util(TreeNode root,int curr,int level){
        if(root==null)return;
        
        if(!map.containsKey(level)){
            map.put(level,new int[]{curr,curr});
        }
        else{
            map.get(level)[0]=Math.min(map.get(level)[0],curr);
            map.get(level)[1]=Math.max(map.get(level)[1],curr);
        }
        util(root.left,curr*2+1,level+1);
        util(root.right,curr*2+2,level+1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        util(root,0,1);
        int ans=1;

        for(var e:map.entrySet()){
            ans=Math.max(ans,e.getValue()[1]-e.getValue()[0]+1);
        }
        return ans;
    }
}
