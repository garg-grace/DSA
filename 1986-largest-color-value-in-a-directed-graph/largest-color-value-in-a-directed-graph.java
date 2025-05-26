class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] temp = new int[n];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            temp[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(temp[i]==0) q.add(i);
        }
        int[][] dp = new int[n][26];
        int cnt=0,ans=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            dp[node][colors.charAt(node)-'a']++;
            ans = Math.max(ans,dp[node][colors.charAt(node)-'a']);
            for(int it:adj.get(node)){
                for(int c=0;c<26;c++){
                    dp[it][c]=Math.max(dp[it][c],dp[node][c]);
                }
                if(--temp[it]==0) q.add(it);
            }
        }

        if(cnt!=n) return -1;

        return ans;        
    }
}