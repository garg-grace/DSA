class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int ind=0;
        if(n%2==1) res[ind++]=0;
        
        int temp=1;
        while(ind<n){
            res[ind++]=temp;
            res[ind++]=(-1)*temp;
            temp++;
        }
        return res;
    }
}