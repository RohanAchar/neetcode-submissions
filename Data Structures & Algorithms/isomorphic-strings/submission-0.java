class Solution {
    /*
     Approach: Two-Way (Bijective) Mapping using HashMaps
     
     1. Setup Tracking:
        - 'sMap' stores the forward mapping (Character from 's' -> Character from 't').
        - 'tMap' stores the reverse mapping (Character from 't' -> Character from 's').
     
     2. Simultaneous Scanning:
        - The code loops through both strings index by index, extracting 'charS' and 'charT'.
     
     3. Enforce One-to-One Rules (Validation):
        - Condition 1 (sMap check): If 'charS' was already mapped, it must point to the exact same 'charT' again.
        - Condition 2 (tMap check): If 'charT' was already mapped, it must point back to the exact same 'charS'.
        - If either rule is broken, the strings are not isomorphic, and the method immediately returns false.
     
     4. Record Mappings:
        - If the pairs pass the check, the dynamic translation rules are saved into both maps.
        - If the entire loop completes without conflict, it returns true.
    
     Complexity: Time O(N) | Space O(1) (ASCII limit)
    */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);
            if((sMap.containsKey(charS) && sMap.get(charS)!=charT) || (tMap.containsKey(charT) && tMap.get(charT)!=charS)) return false;
            sMap.put(charS,charT);
            tMap.put(charT,charS);   
        }
        return true;
    }
}