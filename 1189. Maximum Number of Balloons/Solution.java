class Solution {
    public int maxNumberOfBalloons(String s) {
        
        String target="ballon";
        int[] freq=new int[26];

        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            freq[index]++;
        }

        int max=Integer.MAX_VALUE;

        max=Math.min(max,freq[1]);
        max=Math.min(max,freq[0]);
        max=Math.min(max,freq[14]/2);
        max=Math.min(max,freq[13]);
        max=Math.min(max,freq[11]/2);

        return max;
    }
}
