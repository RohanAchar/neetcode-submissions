class Solution {
    /*
    tMap stores the required frequency of each character in t and remains unchanged.
    sMap stores the frequency of only the relevant characters currently present in
    the sliding window of s.

    need is the total number of character occurrences required, including duplicates,
    so need = t.length(). have is the number of required character occurrences that
    the current window has matched so far.

    While expanding the window from the right, if a character is present in t, add it
    to sMap. Increment have only when its frequency in sMap does not exceed its
    required frequency in tMap. This prevents extra occurrences from being counted.

    When have == need, the current window contains every character required by t,
    including duplicates, so it is a valid candidate window.

    Once the window is valid, shrink it from the left to find the minimum valid window.

    Before removing the left character, update the minimum length and its indices.
    If the left character is relevant, reduce its frequency in sMap. If its frequency
    becomes less than the required frequency in tMap, the window is no longer valid,
    so decrement have.

    Continue moving the right pointer to find other valid windows and keep track of
    the smallest one found.
    */
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int need = t.length();
        int have = 0;
        int ans = Integer.MAX_VALUE;
        int[] ansIndex = new int[2];
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        for(Character ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        int l = 0;
        for(int i = 0;i<s.length();i++){
            if(tMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
                if(sMap.get(s.charAt(i))<=tMap.get(s.charAt(i))){
                    have++;
                }
            }
            while(have==need){
                if(i-l+1<ans){
                    ans=i-l+1;
                    ansIndex[0]=l;
                    ansIndex[1]=i;
                }
                if(l<s.length() && tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l),sMap.get(s.charAt(l))-1);
                    if(sMap.get(s.charAt(l))<tMap.get(s.charAt(l))) have--;
                }
                l++;
            }
        }
        if(ans!=Integer.MAX_VALUE) return s.substring(ansIndex[0],ansIndex[1]+1);
        else return "";
    }
}