class Solution {
    private int[] findCoordinates(int currVal,int n){
        int r = n - (currVal-1)/n -1;
        int c = (currVal-1)%n;

        if(n%2==r%2) c = n-1-c;

        return new int[]{r,c};
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        int[][] vis = new int[n][n];
        q.add(1);
        vis[n-1][0]=1;
        int minSteps=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int it=0;it<size;it++){
                int val = q.poll();
                if(val==n*n) return minSteps;

                for(int i=1;i<=6;i++){
                    int currVal = val+i;
                    int[] coordinates = findCoordinates(currVal,n);
                    int row = coordinates[0];
                    int col = coordinates[1];
                    if(row<0 || col<0 || vis[row][col]==1) continue;
                    vis[row][col]=1;
                    if(board[row][col]!=-1){
                        q.add(board[row][col]);
                    }else{
                        q.add(currVal);
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }
}