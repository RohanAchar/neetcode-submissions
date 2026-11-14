class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Counting Sort
        // Time  : O(n + range)
        //       = O(n + 1001)
        //       = O(n)
        // Space : O(range)
        //       = O(1001)
        //       = O(1) (constant space)

        int[] freq = new int[1001];

        // Count occurrences of each value in arr1.
        // Constraint: 0 <= arr1[i] <= 1000.
        for (int val : arr1) {
            freq[val]++;
        }

        // Place elements in the same relative order as arr2.
        // For each value in arr2, write it frequency times.
        int index = 0;
        for (int val : arr2) {
            while (freq[val] > 0) {
                arr1[index++] = val;
                freq[val]--;
            }
        }

        // Place remaining elements (not present in arr2).
        // Traversing freq from 0 to 1000 automatically gives sorted order.
        for (int start = 0; start <= 1000; start++) {
            while (freq[start] > 0) {
                arr1[index++] = start;
                freq[start]--;
            }
        }
        return arr1;

        // Brute Force (In-Place)
        // Idea:
        // Move all arr2 elements to the front in arr2 order,
        // then sort the remaining suffix.
        //
        // Time  : O(m*n + k log k)
        // Worst : O(n^2)
        // Space : O(1)
        // int l = 0;
        // for(int val : arr2){
        //     int start = l;
        //     for(int i=start;i<arr1.length;i++){
        //         if(arr1[i]==val){
        //             int temp = arr1[l];
        //             arr1[l]=arr1[i];
        //             arr1[i]=temp;
        //             l++;
        //         }
        //     }
        // }
        // Arrays.sort(arr1,l,arr1.length);
        // return arr1;
    }
}