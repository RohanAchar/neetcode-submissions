class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if(n==1) return true;
        Map<Character,Integer> map = new HashMap<>();    
        for(String s : words){
            for(Character ch : s.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        for(Integer val : map.values()){
            if(val%n!=0) return false;
        }
        return true;
    }
}