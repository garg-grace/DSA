class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        //suppose first val of arr to 0 and min and maxval in arr
        int curr=0,mini=0,maxi=0;

        for(int d:differences){
            curr+=d;

            maxi=Math.max(maxi,curr);
            mini=Math.min(mini,curr);

            if(((upper-maxi)-(lower-mini)+1)<=0) return 0;
        }

        return (upper-maxi)-(lower-mini)+1;        
    }
}