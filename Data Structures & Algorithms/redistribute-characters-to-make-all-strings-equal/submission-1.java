class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if(n==1) return true;
        int[] freq = new int[26];    
        for(String s : words){
            for(Character ch : s.toCharArray()){
                freq[ch-'a']++;
            }
        }
        for(Integer val : freq){
            if(val%n!=0) return false;
        }
        return true;
    }
}