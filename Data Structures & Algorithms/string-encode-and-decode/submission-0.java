class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String str1 : strs){
            int length = str1.length();
            str.append(length).append("#").append(str1);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        int length = str.length();
        int strLength = 0;
        List<String> arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j<length){
            while(str.charAt(j)!='#')
            {
                j++;
            }
            strLength = Integer.parseInt(str.substring(i,j));
            arr.add(str.substring(j+1,j+1+strLength));
            j=j+1+strLength;
            i=j;
        }
        return arr;
    }
}
