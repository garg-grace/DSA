class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer,Integer> nums2ElementCount=new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int num:nums2){
            nums2ElementCount.put(num,nums2ElementCount.getOrDefault(num,0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        int ele = nums2[index];
        int newEle = ele + val;
        nums2[index]=newEle;
        nums2ElementCount.put(ele,nums2ElementCount.get(ele)-1);
        nums2ElementCount.put(newEle,nums2ElementCount.getOrDefault(newEle,0)+1);
    }
    
    public int count(int tot) {
        int cnt =0;
        for(int i=0;i<nums1.length;i++){
            int remainingTotal = tot-nums1[i];
            if(nums2ElementCount.containsKey(remainingTotal)){
                cnt+=nums2ElementCount.get(remainingTotal);
            }
        }
        return cnt;        
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */