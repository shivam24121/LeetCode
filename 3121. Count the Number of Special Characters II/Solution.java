class Solution {
    public int numberOfSpecialChars(String s) {
        
        Set<Character>special=new HashSet<>();
        Set<Character>lower=new HashSet<>();
        Set<Character>blackList=new HashSet<>();

        int n=s.length();
        int ans=0;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(blackList.contains(Character.toLowerCase(c)))continue;
            // System.out.println("runner "+i+" "+c);

            if(Character.isLowerCase(c) && !blackList.contains(c)){
                if(special.contains(Character.toUpperCase(c))){
                    ans--;
                    special.remove(Character.toUpperCase(c));
                    blackList.add(c);
                }
                else{
                    lower.add(c);
                }
            }
            else if(Character.isUpperCase(c)){
                if(lower.contains(Character.toLowerCase(c)) && !special.contains(c)){
                    ans++;
                    // System.out.println(c+" yaha");
                    special.add(c);
                }
                else if(!special.contains(c)){
                    blackList.add(Character.toLowerCase(c));
                }
            }
        }
        // System.out.println(special);
        // System.out.println(blackList);
        return ans;
    }
}
