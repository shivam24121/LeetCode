class Solution {
        static final String part4="([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        static final String ip4="^("+part4 +"\\.){3}"+part4+ "$";

        static final String part6="([0-9a-fA-F]{1,4})";
        static final String ip6="^("+ part6 +":){1,7}" + part6 +"$";
    public String validIPAddress(String queryIP) {
        if(queryIP.matches(ip4))return "IPv4";
        if(queryIP.matches(ip6))return "IPv6";
        return "Neither";
    }
}
