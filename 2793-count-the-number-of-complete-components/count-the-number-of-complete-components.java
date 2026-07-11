class Solution {
    int[] parent;
    private int find(int node){
        if(node == parent[node]) return node;

        return parent[node]=find(parent[node]);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1];
            int ulp_u = find(u);
            int ulp_v = find(v);
            parent[ulp_u]=parent[ulp_v];
        }
        int[] nodeCount = new int[n];
        int[] edgeCount = new int[n];
        for(int i=0;i<n;i++){
            nodeCount[find(i)]++;
        }
        for(int[] edge:edges){
            edgeCount[find(edge[0])]++;
        }
        int out=0;
        for(int i=0;i<n;i++){
            int count=nodeCount[i];
            int expected = (count*(count-1))/2;
            if(count == 0) continue;
            else if(expected==edgeCount[i]) out++;
        }
        return out;
    }
}