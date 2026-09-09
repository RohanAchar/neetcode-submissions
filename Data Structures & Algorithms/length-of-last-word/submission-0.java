class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int r = s.length()-1;
        while(r>=0 && s.charAt(r)==' '){
            r--;
        }
        while (r>=0 && s.charAt(r)!=' '){
            length++;
            r--;
        }
        return length;
    }
}