class Solution {
    int numberOfSubstrings(String s) {
        int ans=0;
        int lastSeen[]=new int[]{-1,-1,-1};
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a']=i;
            ans+=(1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
        }
        return ans;
    }
};