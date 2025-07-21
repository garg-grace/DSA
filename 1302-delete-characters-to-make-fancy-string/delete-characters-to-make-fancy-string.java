class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt=1;
        char prev=s.charAt(0);
        sb.append(prev);

        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(prev==ch){
                cnt++;
                if(cnt>2) continue;
            }else{
                cnt=1;
                prev=ch;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}