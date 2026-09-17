//solve again
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty
            if (flowerbed[i] == 0) {
                // Left neighbor is empty if we are at index 0 OR the previous plot is 0
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                
                // Right neighbor is empty if we are at the last index OR the next plot is 0
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                // If both sides are clear, plant a flower here
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    
                    if (n == 0) return true;
                }
            }
        }
        
        return n <= 0;
    }
}
