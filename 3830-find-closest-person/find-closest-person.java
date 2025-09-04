class Solution {
    public int findClosest(int x, int y, int z) {
        int xz = Math.abs(z-x);
        int yz = Math.abs(z-y);

        if(xz==yz) return 0;

        return xz<yz?1:2;
    }
}