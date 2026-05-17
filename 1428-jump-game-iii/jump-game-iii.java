class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 1;

        while(!q.isEmpty()) {
            int idx = q.poll();
            if(arr[idx]==0) return true;

            int idx1 = idx+arr[idx];
            if(idx1>=0 && idx1<n && vis[idx1]==0) {
                vis[idx1] = 1;
                q.add(idx1);
            }

            int idx2 = idx-arr[idx];
            if(idx2>=0 && idx2<n && vis[idx2]==0) {
                vis[idx2] = 1;
                q.add(idx2);
            }
        }

        return false;
    }
}