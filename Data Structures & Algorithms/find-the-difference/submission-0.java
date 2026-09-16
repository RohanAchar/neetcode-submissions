class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(Character ch : s.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(Character ch : t.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        for(Character ch : t.toCharArray()){
            if(!map1.containsKey(ch)) return ch;
            else{
                if(map1.get(ch)!=map2.get(ch)) return ch;
            }
        }
        return ' ';
    }
}