class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String> res=new ArrayList<>();
        res.add(words[0]);

        for(int i=1;i<n;i++){
            if(!anagram(words[i],words[i-1])){
                res.add(words[i]);
            }
        }
        return res;
    }
    public boolean anagram(String a,String b){
        int[] arr=new int[26];

        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            arr[c-'a']++;
        }
        for(int i=0;i<b.length();i++){
            char c=b.charAt(i);
            arr[c-'a']--;
        }
        for(int i:arr){
            if(i!=0)return false;
        }
        return true;
    }
}
