class Solution {
    public List<String> readBinaryWatch(int turnedOn) {

        List<String>res=new ArrayList<>();

        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){

                    String hr=String.valueOf(i);
                    String min=(j<10?"0":"")+String.valueOf(j);
                    res.add(hr+":"+min);
                }
            }
        }
        return res;
    }
}
