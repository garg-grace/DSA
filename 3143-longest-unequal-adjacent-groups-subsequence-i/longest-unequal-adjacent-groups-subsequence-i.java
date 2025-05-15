class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int ind=-1;
        int n = words.length;

        for(int i=0;i<n;i++){
            if(ind==-1 || ind!=groups[i]){
                ans.add(words[i]);
                ind=groups[i];
            }
        }
        return ans;
    }
}