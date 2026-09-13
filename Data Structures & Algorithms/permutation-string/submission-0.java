class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false; 
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for(int i=0;i<s1.length();i++){
            s1Arr[s1.charAt(i)-'a']+=1;
            s2Arr[s2.charAt(i)-'a']+=1;
        }
        boolean exists=true;
        for(int i=0;i<26;i++){
            if(s1Arr[i]!=s2Arr[i]) exists=false;
        }
        if(exists) return exists;
        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            exists = true;
            s2Arr[s2.charAt(r)-'a']+=1;
            s2Arr[s2.charAt(l)-'a']-=1;
            l++;
            for(int i=0;i<26;i++){
                if(s1Arr[i]!=s2Arr[i]){
                    exists=false;
                    break;
                }
            }
            if(exists) return true;
        }
        return false;
    }
}