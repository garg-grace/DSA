class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] res = new int[n];

        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int spell = spells[i];
            res[i] = strengthGreaterThanSuccess(spell,potions,success);
        }
        return res;
    }
    private int strengthGreaterThanSuccess(int spell,int[] potions,long success){
        int low=0;
        int high=potions.length-1;
        int idx=-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            long st = (long)potions[mid]*(long)spell;
            if(st<success){
                low=mid+1;
            }else{
                idx=mid;
                high=mid-1;
            }
        }
        return idx!=-1?potions.length-idx:0;
    }
}