class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int t=(minutesToTest/minutesToDie)+1;

        int pigs=0;

        while((Math.pow(t,pigs))<buckets){
            System.out.println(Math.pow(t,pigs));
            pigs++;
        }
        return pigs;
    }
}
