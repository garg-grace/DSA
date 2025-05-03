class Solution {
    private int largestRectangleArea(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>heights[i])){
                int height = heights[st.pop()];
                int width = st.isEmpty()?i:i-st.peek()-1;
                maxArea = Math.max(maxArea,height*width);
            }
            st.add(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] height = new int[m];
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            maxArea = Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;        
    }
}