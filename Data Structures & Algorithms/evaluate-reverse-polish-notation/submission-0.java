class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        for(String str : tokens){
            if(!(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))){
                stack.push(Integer.parseInt(str));
            }
            else{
                if(stack.size()>=2){
                    int b = stack.pop();
                    int a = stack.pop();
                    if(str.equals("+")){
                        stack.push(a+b);
                    }
                    else if(str.equals("-")){
                        stack.push(a-b);
                    }
                    else if(str.equals("*")){
                        stack.push(a*b);
                    }
                    else if(str.equals("/")){
                        stack.push(a/b);
                    }
                }
            }
        }
        return stack.pop();
    }
}