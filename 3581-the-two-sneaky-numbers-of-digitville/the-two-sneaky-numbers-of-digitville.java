class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int[] res = new int[2];
        int cnt=0;

        for(int num : nums) {
            if(st.contains(num)){
                res[cnt++]=num;
                if(cnt==2) return res;
            }

            st.add(num);
        }

        return res;
    }
}