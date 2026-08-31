class Solution {
    public int strStr(String haystack, String needle) {
        int i =0;
        for(int j=needle.length();j<=haystack.length();j++){
            String str = haystack.substring(i,j);
            if(str.equals(needle)) return i;
            i++;
        }
        return -1;
    }
}