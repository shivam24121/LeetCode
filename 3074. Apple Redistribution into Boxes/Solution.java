class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total=0;
        for(int i:apple){
            total+=i;
        }
        Arrays.sort(capacity);
        reverse(capacity);
        int ct=0;

        int temp=0,idx=0;
        while(temp<total){
            temp+=capacity[idx++];
            ct++;
        }
        return ct;
    }
    public void reverse(int[] a){
        int n=a.length;
        for(int i=0;i<n/2;i++){
            int temp=a[i];
            a[i]=a[n-i-1];
            a[n-i-1]=temp;
        }
    }
}
