class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = findMax(piles);
        int m = 0;
        boolean isPossible = false;
        int k = -1;
        while(i<=j){
            m = (i+j)/2;
            isPossible = checkIfPossible(piles,m,h);
            if(isPossible){
                k=m;
                j=m-1;
            }
            else{
                i=m+1;
            }
        }
        return k;
    }

    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int pile : piles){
            max = Math.max(pile,max);
        }
        return max;
    }

    public boolean checkIfPossible(int[] piles, int m, int h){
        long totalHoursSpent = 0;
        for(int pile : piles){
            totalHoursSpent+=(long)Math.ceil((double)pile/m);
            if(totalHoursSpent>h){
                return false;
            }
        }
        return true;
    }
}