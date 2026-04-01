class Solution {
    public List<Integer> survivedRobotsHealths(int[] idx, int[] hp, String dir) {

        List<Integer>res=new ArrayList<>();
        int n=idx.length;

        Integer[] temp=new Integer[n];
        for(int i=0;i<n;i++){
            temp[i]=i;
        }

        Arrays.sort(temp,(a,b)->Integer.compare(idx[a],idx[b]));

        // for(int i=0;i<n;i++){
        //     System.out.print(temp[i]+" ");
        // }

        Stack<Integer>st=new Stack<>();

        for(int i=0;i<n;i++){
            
            int pos=temp[i];

            if(dir.charAt(pos)=='R'){
                st.push(pos);
            }
            else{
                while(!st.isEmpty() && hp[pos]>0){

                    int top=st.pop();

                    if(hp[pos]<hp[top]){
                        hp[top]--;
                        hp[pos]=0;
                        st.push(top);
                    }
                    else if(hp[pos]==hp[top]){
                        hp[pos]=0;
                        hp[top]=0;
                    }
                    else{
                        hp[top]=0;
                        hp[pos]--;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(hp[i]>0){
                res.add(hp[i]);
            }
        }
        return res;
    }
}
