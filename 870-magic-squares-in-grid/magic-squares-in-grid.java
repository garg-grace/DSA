class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                if(isMagicMatrix(i,j,grid)) res++;
            }
        }
        return res;
    }

    private boolean isMagicMatrix(int r, int c , int[][] grid){
        boolean isRowValid = false;
        boolean isColValid = false;
        boolean isDiagonalValid = false;
        int sum=0;
        

        for(int i=0;i<3;i++) sum+=grid[r][c+i];

        //check rows sum
        for(int i=1;i<3;i++){
            int temp = 0;
            for(int j=0;j<3;j++){
                temp+=grid[r+i][c+j];
            }
            if(sum!=temp) return false;
        }

        Set<Integer> numbers = new HashSet<>();
        //check cols sum
        for(int j=0;j<3;j++){
            int temp=0;
            for(int i=0;i<3;i++){
                if(grid[r+i][c+j]<1 || grid[r+i][c+j]>9) return false;
                numbers.add(grid[r+i][c+j]);
                temp+=grid[r+i][c+j];
            }
            if(temp!=sum) return false;
        }

        if(numbers.size()!=9) return false;

        //check diagonal sum
        int d1=0;
        int d2=0;
        for(int i=0;i<3;i++){
            d1+=grid[r+i][c+i];
        }
        if(d1!=sum) return false;

        d2+=(grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c]);
        if(d2!=sum) return false;

        return true;
    }
}