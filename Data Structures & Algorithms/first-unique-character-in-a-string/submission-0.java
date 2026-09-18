class Solution {
    public int firstUniqChar(String s) {

        //using int array because the string constraint in question says only lowercase letters
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1) return i;
        }
        return -1;
        
        //Using hashmap alternate solution
        // Map<Character,Integer> map = new HashMap<>();
        // for(Character ch : s.toCharArray()){
        //     map.put(ch,map.getOrDefault(ch,0)+1);
        // }
        // for(int i = 0;i<s.length();i++){
        //     if(map.get(s.charAt(i))==1) return i;
        // }
        // return -1;
    }
}