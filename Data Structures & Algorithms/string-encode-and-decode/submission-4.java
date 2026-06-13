class Solution {

    public String encode(List<String> strs) {
        String res = "";
        // String del="#";

        for(String str : strs){
            int len= str.length();
            res+=String.valueOf(len) + "#" + str;
        }
        System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        int start=0;
        String s = str;
        List<String> res= new ArrayList<>();
        int i=0;
        while(i < str.length()){
            
            int del = str.indexOf("#", i); // 1
            int size = Integer.parseInt(str.substring(i, del));
            
            String word = str.substring(
            del + 1,
            del + 1 + size
        );
            //System.out.println(str.substring(i+del+1,i+del+Integer.valueOf(size)+1));
            res.add(word);
            i = size + del +1 ;
        }
        return res ;
    }
}
