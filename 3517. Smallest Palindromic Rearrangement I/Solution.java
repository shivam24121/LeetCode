class Solution {
    public String smallestPalindrome(String s) {
        
        int n=s.length();
        int[] freq=new int[26];

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){

            int idx=s.charAt(i)-'a';
            freq[idx]++;
        }
        char mid='@';

        for(int i=0;i<26;i++){

            int num=freq[i];

            if((num&1)==1){
                mid=(char)(i+'a');
            }
            int times=num/2;
            while(times-->0){
                sb.append((char)(i+'a'));
            }
        }
        String rev=new StringBuilder(sb).reverse().toString();
        if(mid!='@'){
            sb.append(mid);
        }
        sb.append(rev);
        return sb.toString();
    }
}
