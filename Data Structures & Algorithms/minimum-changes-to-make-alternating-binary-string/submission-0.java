class Solution {
    //check why s.length()-ans is part of the other answer.
    public int minOperations(String s) {
        char previous = s.charAt(0);
        int ans = 0;
        for(int i=1;i<s.length();i++){
            char present = s.charAt(i);
            if(present-previous == 0){
                if(present=='1'){
                    ans++;
                    previous='0';
                }
                else{
                    ans++;
                    previous='1';
                }
            }
            else{
                previous = present;
            }
        }
        return Math.min(s.length()-ans,ans);
    }
}