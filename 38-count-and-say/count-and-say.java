class Solution {
    private String buildNext(String s){
        StringBuilder res = new StringBuilder();
        int cnt=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cnt++;
            }else{
                res.append(cnt).append(s.charAt(i-1));
                cnt=1;
            }
        }
        res.append(cnt).append(s.charAt(s.length()-1));
        return res.toString();
    }
    public String countAndSay(int n) {
        String res = "1";
        for(int i=1;i<n;i++){
            res = buildNext(res);
        }       
        return res;
    }
}