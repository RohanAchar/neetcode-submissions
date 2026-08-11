class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sHashMap = new HashMap<>();
        Map<Character,Integer> tHashMap = new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(char ch : s.toCharArray()){
            sHashMap.put(ch,sHashMap.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            tHashMap.put(ch,tHashMap.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : sHashMap.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if(value!=tHashMap.getOrDefault(key,0)) return false;
        }
        return true;
    }
}
