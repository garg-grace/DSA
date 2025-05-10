class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0,cnt1=0;
        for(int num:nums1){
            sum1+=(long)num;
            if(num==0)cnt1++;
        }

        long sum2=0,cnt2=0;
        for(int num:nums2){
            sum2+=(long)num;
            if(num==0) cnt2++;
        }

        if(sum1+cnt1>sum2 && cnt2==0) return -1;
        if(sum2+cnt2>sum1 && cnt1==0) return -1;

        return Math.max(sum1+cnt1,sum2+cnt2);        
    }
}