class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        boolean hasOdd = false;
        int[] count = new int[128];
        for(char ch : s.toCharArray()){
            count[ch]++;
        }
        for(int val : count){
            if(val%2==0) ans+=val;
            else {
                ans+=(val-1);
                hasOdd = true;
            }
        }
        if(hasOdd) return ans+1;
        return ans;
    }
}