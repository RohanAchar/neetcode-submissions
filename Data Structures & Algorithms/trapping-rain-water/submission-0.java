//mistakes - using arraylist instead of int array.
/*idea - prefix of largest height encountered, postfix of largest height encountered. then for each height Math.abs(min(prefix largest at that height[i],postfix largest at the height[i])-height[i]).
Math.abs is required because the value can get negative.
*/ 
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(height.length==1) return 0;
        int[] preMaxHeights = new int[n];
        int[] postMaxHeights = new int[n];
        int ans = 0;
        preMaxHeights[0]=height[0];
        postMaxHeights[n-1]=height[n-1];
        for(int i =1;i<height.length;i++){
            preMaxHeights[i]=Math.max(preMaxHeights[i-1],height[i]);
        }
        for(int i =height.length-2;i>=0;i--){
            postMaxHeights[i]=Math.max(postMaxHeights[i+1],height[i]);
        }
        for(int i =0;i<height.length;i++){
            ans+=(Math.abs(Math.min(preMaxHeights[i],postMaxHeights[i])-height[i]));
        }
        return ans;
    }
}