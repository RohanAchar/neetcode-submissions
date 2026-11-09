class Solution {
    /*
     * Computes the maximum score for a binary string.
     * Score = (number of '0's in the left part) + (number of '1's in the right part).
     * Uses two passes: first counts total '1's, then scans to track zeros on the left
     * and remaining ones on the right, updating the maximum score at each split.
     * Time: O(n), Space: O(1)
     */
    public int maxScore(String s) {
        // Solution 2 Time O(n)  Space O(1)
        int one = 0;
        int zero = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1')
                one++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0')
                zero++;
            else
                one--;
            ans = Math.max(one + zero, ans);
        }
        return ans;

        // Solution 1 Time : O(n) Space O(n)
        //  int[] prefix = new int[s.length()];
        //  int[] suffix = new int[s.length()];
        //  if(s.charAt(0)=='0') prefix[0]=1;
        //  else prefix[0]=0;
        //  if(s.charAt(s.length()-1)=='1') suffix[s.length()-1]=1;
        //  else suffix[s.length()-1]=0;
        //  for(int i=1;i<s.length();i++){
        //      if(s.charAt(i)=='0'){
        //          prefix[i]=prefix[i-1]+1;
        //      }
        //      else{
        //          prefix[i]=prefix[i-1];
        //      }
        //  }
        //  for(int i=s.length()-2;i>=0;i--){
        //      if(s.charAt(i)=='1') suffix[i]=suffix[i+1]+1;
        //      else suffix[i]=suffix[i+1];
        //  }
        //  int ans = 0;
        //  for(int i=0;i<prefix.length-1;i++){
        //      ans = Math.max(ans,prefix[i]+suffix[i+1]);
        //  }
        //  return ans;
    }
}