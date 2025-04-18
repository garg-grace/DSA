class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        int n = strs.length;
        String f=strs[0],l=strs[n-1];

        for(int i=0;i<Math.min(f.length(),l.length());i++){
            if(f.charAt(i)!=l.charAt(i)){
                return ans.toString();
            }
            ans.append(f.charAt(i));
        }
        return ans.toString();
    }
}