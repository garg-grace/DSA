class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int[] arr = new int[n*m];

        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[index++]=grid[i][j];
            }
        }

        int base = arr[0]%x;
        for(int num:arr){
            if(num%x != base) return -1; //impossible
        }
        
        Arrays.sort(arr);
        int median = arr[arr.length/2];
        int operation = 0;
        for(int num:arr){
            operation += Math.abs(num-median)/x;
        }
        return operation;
    }
}