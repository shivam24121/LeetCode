class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        int[] fact=new int[n+1];
        fact[0]=1;
        ArrayList<Integer>nums=new ArrayList<>();

        for(int i=1;i<=n;i++){
            fact[i]=fact[i-1]*i;
            nums.add(i);
        }
        k--;

        for(int i=n;i>=1;i--){
            int temp=k/fact[i-1];
            sb.append(nums.get(temp));
            nums.remove(temp);
            k=k%fact[i-1];
        }
        return sb.toString();
    }
}
