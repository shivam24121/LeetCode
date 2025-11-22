class Solution {
    public int totalWaviness(int num1, int num2) {
        int ct=0;
        for(int j=num1;j<=num2;j++){
            String s=String.valueOf(j);
            int n=s.length();

            if(n<3)continue;
            int res=0;
            for(int i=1;i<n-1;i++){
                char l=s.charAt(i-1);
                char r=s.charAt(i+1);
                char mid=s.charAt(i);

                if(mid>l && mid>r)res++;
                else if(mid<l && mid<r)res++;
            }
            ct+=res;
        }
        return ct;
    }
}
