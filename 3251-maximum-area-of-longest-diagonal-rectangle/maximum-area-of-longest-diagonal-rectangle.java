class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea=0;
        int maxDiagonal=0;

        for(int i=0;i<dimensions.length;i++){
            int l = dimensions[i][0];
            int b = dimensions[i][1];
            int d = l*l+b*b;

            if(d>maxDiagonal || (d==maxDiagonal && l*b>maxArea)){
                maxArea=l*b;
                maxDiagonal=d;
            }
        }
        return maxArea;
    }
}