class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    // Idea:
    // Use the character-frequency array as the identity/key for each anagram group.
    // For every word, create an array of size 26 and count the frequency of
    // each lowercase letter from 'a' to 'z'. Anagrams have exactly the same
    // character frequencies, so they create the same frequency array.
    //
    // Convert the int[] array to a String using Arrays.toString(arr). We do
    // this because using int[] directly as a HashMap key would not work:
    // Java compares arrays by their object reference (memory location), not
    // by their contents. Thus, two arrays with identical counts could be
    // treated as different keys.
    //
    // The map stores:
    // frequency-array String key -> List of words with those frequencies.
    //
    // After processing every word, map.values() contains all the anagram
    // groups. Convert it into an ArrayList and return it.
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] arr = new int[26];
            for(char ch : str.toCharArray()){
                arr[ch-'a']++;
            }
            String strArr = Arrays.toString(arr);
            map.putIfAbsent(strArr,new ArrayList<String>());
            map.get(strArr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
