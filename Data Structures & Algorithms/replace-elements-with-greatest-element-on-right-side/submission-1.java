class Solution {
    public int[] replaceElements(int[] arr) {
        int[] postfix = new int[arr.length];
        postfix[arr.length-1]=-1;
        if(arr.length==1) return postfix;
        for(int i=arr.length-2;i>=0;i--){
            postfix[i]=Math.max(arr[i+1],postfix[i+1]);
        }
        return postfix;
    }
}