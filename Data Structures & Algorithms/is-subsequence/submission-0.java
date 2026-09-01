//solve again
class Solution {
    public boolean isSubsequence(String s, String t) {
        // int i=0;
        // for(int j=s.length();j<=t.length();j++){
        //     String str = t.substring(i,j);
        //     if(str.equals(s)) return true;
        //     i++;
        // }
        // return false;
        int i = 0;

        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }
}