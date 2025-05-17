class Solution {
    public boolean checkHammingCondition(String str1,String str2){
        if(str1.length()!=str2.length()) return false;

        int cnt=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) cnt++;
            if(cnt>1) return false;
        }
        return cnt==1;
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int[] parent = new int[n];
        Arrays.fill(parent,-1);     
        int maxi=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(groups[i]!=groups[j] && checkHammingCondition(words[i],words[j])){
                    if(dp[i]<1+dp[j]){
                        dp[i]=1+dp[j];
                        parent[i]=j;
                    }
                }
            }
            if(dp[i]>maxi) maxi=dp[i];
        }

        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                while(i!=-1){
                    res.add(words[i]);
                    i=parent[i];
                }
                break;
            }
        }
        
        Collections.reverse(res);
        return res;
    }
}