class Solution {
    public String largestGoodInteger(String num) {
        //SOLVE AGAIN
        // Check from '9' down to '0'
        for (char d = '9'; d >= '0'; d--) {
            String target = "" + d + d + d;  // e.g., "999", "888", ...
            if (num.contains(target)) {
                return target;  // first match is the largest
            }
        }
        return "";
    }
}