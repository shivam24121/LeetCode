class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");

        int n=s1.length;
        int m=s2.length;
        int max=Math.max(n,m);

        for(int i=0;i<max;i++){
            int num1=i<n?Integer.parseInt(s1[i]):0;
            int num2=i<m?Integer.parseInt(s2[i]):0;

            if(num1>num2)return 1;
            if(num2>num1)return -1;
        }
        return 0;
    }
}
