class Solution {
    public char kthCharacter(int k) {
        List <Integer> word=new ArrayList<>();
        word.add(0);
        while(word.size()<k){
            int n=word.size();
            for(int i=0;i<n;i++){
                word.add((word.get(i)+1)%26);
            }
        }
        return (char)('a'+word.get(k-1));
    }
}
