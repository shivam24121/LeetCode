class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1,carry=0;
        while(i>=0 || j>=0 || carry>0){
            int a=i>=0?num1.charAt(i--)-'0':0;
            int b=j>=0?num2.charAt(j--)-'0':0;
            int sum=a+b+carry;
            sb.append(sum%10);
            carry=sum/10;
        }
        return sb.reverse().toString();
    }
}
