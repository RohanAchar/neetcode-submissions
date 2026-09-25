class Solution {
    public int maxDifference(String s) {
        /*
        Find the maximum odd frequency and minimum even frequency
        to maximize (freqOdd - freqEven).
        */
        int[] arr = new int[26];
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(Character ch : s.toCharArray()){
            arr[ch-'a']+=1;
        }
        for(int i : arr){
            if(i==0) continue;
            if(i%2!=0) maxOdd = Math.max(maxOdd,i);
            else minEven = Math.min(minEven,i);
        }
        return maxOdd-minEven;
    }
}