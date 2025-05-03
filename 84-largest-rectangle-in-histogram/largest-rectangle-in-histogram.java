class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea=0;

        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>heights[i])){
                int height = heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                maxArea = Math.max(maxArea,height*width);
            }
            st.add(i);
        }
        return maxArea;        
    }
}