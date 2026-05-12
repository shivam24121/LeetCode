class Solution {
    public int minimumEffort(int[][] arr) {
        
        int n=arr.length;
        Arrays.sort(arr,(a,b)->Integer.compare(b[1]-b[0],a[1]-a[0]));

        // for(int[] a:arr){
        //     for(int i:a){
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        int res=arr[0][1];

        int energy=res;
        energy-=arr[0][0];

        for(int i=1;i<n;i++){

            int take=arr[i][0];
            int req=arr[i][1];

            // System.out.println(energy+" "+res+" "+take+" "+req);

            if(req>energy){
                int diff=req-energy;
                res+=diff;
                energy=req-take;
            }
            else{
                energy-=take;
            }
        }
        return res;
    }
}
