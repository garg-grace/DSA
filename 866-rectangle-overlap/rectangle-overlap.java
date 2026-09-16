class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check if x-intervals overlap
        boolean xOverlap = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);
        
        // Check if y-intervals overlap
        boolean yOverlap = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
        
        // Both conditions must be true for a non-zero area overlap
        return xOverlap && yOverlap;
    }
}