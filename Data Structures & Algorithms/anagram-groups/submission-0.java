class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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
