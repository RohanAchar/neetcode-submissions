class Solution {
    //SOLVE AGAIN
    public String destCity(List<List<String>> paths) {
        // Step 1: Add all starting cities to a set
        Set<String> starts = new HashSet<>();
        for (List<String> path : paths) {
            starts.add(path.get(0));
        }

        // Step 2: Find the city that never appears as a start
        for (List<String> path : paths) {
            String endCity = path.get(1);
            if (!starts.contains(endCity)) {
                return endCity;  // This is the destination city
            }
        }

        return ""; // Problem guarantees this won't happen
    }
}