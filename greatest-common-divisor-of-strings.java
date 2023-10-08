class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder prefixBuilder = new StringBuilder();
        int len1 = str1.length(), len2= str2.length();
        for(int i=Math.min(len1, len2);i>0;i--){
            if(divides(str1,str2, i)){
                return str1.substring(0,i);
            }
        }
        return "";
    }


    private boolean divides(String str1, String str2, int len){
        if(str1.length() % len != 0 && str2.length() %len!=0)
            return false;
        String base = str1.substring(0, len);
        return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
    }
}
