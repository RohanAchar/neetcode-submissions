class Solution {
    public String firstPalindrome(String[] words) {
        for(String str : words){
            if(isPalindrome(str)) return str;
        }
        return "";
    }

    public boolean isPalindrome(String str){
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}