/*
Sliding window approach. Idea is for a window length you check the highest frequence character in it and subtract that from the length of the window, and that value will be the number of replacements we need to do. and the number of replacements should not exceed k. So we check this condition and decrease the window length by removing the characters from the left of the window. And once you do that each time you check that with the maximum length we got till now, so that we can track the max length we got for a eligible window length. 
Time O(26n) because we need to check the 26 keys to see the max count each time. The commented lines if you uncomment thats the faster approach to avoid checking the max count each time we decided to keep a varible which will have the max frequency (compared to all keys), basically the max value frequency so that we need to not get the max by checking the whole hashmap, and when you decrease the window length you need not update this because we are aiming to maximize the frequency count so that the number of replacements will reduce and it will hence give more length. 
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int ans = 0;
        // int maxf = 0;
        Map<Character,Integer> hashmap = new HashMap<>();
        for(int r=0;r<s.length();r++){
            hashmap.put(s.charAt(r),hashmap.getOrDefault(s.charAt(r),0)+1);
            // maxf = Math.max(maxf,hashmap.get(s.charAt(r)));
            // while((r-l+1)-maxf>k){
            while((r-l+1)-Collections.max(hashmap.values())>k){
                hashmap.put(s.charAt(l),hashmap.get(s.charAt(l))-1);
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}