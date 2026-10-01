class Solution {
    //SOLVE AGAIN.
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] order = new Integer[names.length];

        for (int i = 0; i < names.length; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(heights[b], heights[a]));

        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            result[i] = names[order[i]];
        }

        return result;
    }
}