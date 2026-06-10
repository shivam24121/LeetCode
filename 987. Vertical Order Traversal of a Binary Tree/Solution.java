class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>>res=new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,List<Integer>>>map=new TreeMap<>();

        solve(root,0,0,map);

        for(var e:map.entrySet()){

            List<Integer>list=new ArrayList<>();
            TreeMap<Integer,List<Integer>>mp=e.getValue();

            for(var f:mp.entrySet()){

                List<Integer>temp=f.getValue();
                Collections.sort(temp);
                list.addAll(temp);
            }
            res.add(list);
        }
        return res;
    }
    public void solve(TreeNode root,int pos,int lvl,TreeMap<Integer,TreeMap<Integer,List<Integer>>>map){

        if(root==null)return;

        map.putIfAbsent(pos,new TreeMap<>());
        map.get(pos).putIfAbsent(lvl,new ArrayList<>());

        map.get(pos).get(lvl).add(root.val);

        solve(root.left,pos-1,lvl+1,map);
        solve(root.right,pos+1,lvl+1,map);
    }
}
