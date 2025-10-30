class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int res=0;
        int last=0;

        for(int i=0;i<n;i++){
            int ele = target[i];

            if(ele>last){
                res+=(ele-last);
            }

            last=ele;
        }
        return res;
    }
}