class Solution {
    List<List<Integer>>res=new ArrayList<>();
    int n;
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        n=arr.length;
        solve(0,new ArrayList<>(),target,arr);
        return res;
    }
    public void solve(int idx,List<Integer>temp,int target,int[] arr){
        if(target==0){
            // if(res.contains(temp))return;
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target<0)return;

        else{

            for(int i=idx;i<n;i++){

                if(i>idx && arr[i]==arr[i-1])continue;
                if(arr[i]>target)break;
                temp.add(arr[i]);
                solve(i+1,temp,target-arr[i],arr);
                temp.remove(temp.size()-1);
            }
        }
    }
}
