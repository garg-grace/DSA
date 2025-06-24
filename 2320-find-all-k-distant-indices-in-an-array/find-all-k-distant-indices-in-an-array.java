class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                if(i+j<n && nums[i+j]==key){
                    res.add(i);
                    break;
                }else if(i-j>=0 && nums[i-j]==key){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}