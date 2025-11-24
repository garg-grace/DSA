class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int temp = 0;

        for(int num : nums) {
            temp = ((temp<<1)+num)%5;
            res.add(temp==0);
        }
        return res;
    }
}