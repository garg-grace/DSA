class Solution {
    private void bfs(int[] edges,int[] dist,int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while(!q.isEmpty()){
            int node = q.poll();
            int nei = edges[node];
            if(nei==-1) continue;

            if(1+dist[node]<dist[nei]){
                dist[nei]=1+dist[node];
                q.add(nei);
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1,(int)(1e9));
        Arrays.fill(dist2,(int)(1e9));

        bfs(edges,dist1,node1);
        bfs(edges,dist2,node2);

        int mini = (int)(1e9);
        int node = -1;
        for(int i=0;i<n;i++){
            int temp = Math.max(dist1[i],dist2[i]);
            if(temp<mini){
                mini=temp;
                node=i;
            }
        }
        return node;
    }
}