class Solution {

    // smallest on left and if not then -1;

    public int[] SIL(int[] height){
        Stack<Integer>st=new Stack<>();
        int[] left=new int[height.length];
        int tempIndex=-1;
        for(int i=0;i<height.length;i++){
            if(st.isEmpty()){
                left[i]=tempIndex;
            }
            else{
                while(!st.isEmpty() && height[st.peek()]>=height[i]){
                    st.pop();
                }
                left[i]=st.isEmpty()?-1:st.peek();
            }
            st.push(i);
        }
        return left;
    }

    // smallest on right if not then n;

    public int[] SIR(int[] height){
        int n=height.length;
        int[] right=new int[n];
        Stack<Integer>st=new Stack<>();
        int tempIndex=height.length;
        for(int i=height.length-1;i>=0;i--){
            if(st.isEmpty()){
                right[i]=tempIndex;
            }
            else{
                while(!st.isEmpty() && height[st.peek()]>=height[i]){
                    st.pop();
                }
                right[i]=st.isEmpty()?tempIndex:st.peek();
            }
            st.push(i);
        }
        return right;
    }
   
    // calculate the width by right[i]-left[i]-1 and then find max area by height[i]*width[i];

    public int MAH(int[] height){
        int[] right=SIR(height);
        int[] left=SIL(height);
        int[] width=new int[height.length];

        for(int i=0;i<height.length;i++){
            width[i]=right[i]-left[i]-1;
        }
        int max=0;
        for(int i=0;i<height.length;i++){
            int h=height[i]*width[i];
            if(h>max){
                max=h;
            }
        }
        return max;
    }
     
    // convert the matrix in 1d and break the 2d into 1d 
    // note that if if find any 0 then make the height[i]=0 as it cant contribute any case;

    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int height[]=new int[n];
        for(int i=0;i<n;i++){
            height[i]=matrix[0][i]=='1'?1:0;
        }
        int max=MAH(height);
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    height[j]=0;
                }
                else{
                    height[j]+=1;
                }
            }
            max=Math.max(max,MAH(height));
        }
        return max;
    }
}
