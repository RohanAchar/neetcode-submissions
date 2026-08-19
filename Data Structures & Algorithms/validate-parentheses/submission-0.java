class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> inSet = new HashSet<>(Arrays.asList('(','{','['));
        for(char ch : s.toCharArray()){
            if(inSet.contains(ch)) stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                Character popChar = stack.pop();
                if(ch==')' && popChar!='(') return false;
                if(ch=='}' && popChar!='{') return false;
                if(ch==']' && popChar!='[') return false;
            }
        }
        return stack.isEmpty();
    }
}