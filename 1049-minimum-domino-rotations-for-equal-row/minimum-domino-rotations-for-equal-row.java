class Solution {
    private  int check(int target,int[] tops,int[] bottoms){
        int rotateTop=0;
        int rotateBottom=0;

        for(int i=0;i<tops.length;i++){
            if(tops[i]!=target && bottoms[i]!=target) return -1;

            if(tops[i]!=target) rotateTop++;
            if(bottoms[i]!=target) rotateBottom++;
        }
        return Math.min(rotateTop,rotateBottom);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res=check(tops[0],tops,bottoms);
        if(res!=-1) return res;
        return check(bottoms[0],tops,bottoms);
    }
}