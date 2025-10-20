class Solution {
    public int finalValueAfterOperations(String[] operations) {

        int res=0;

        for(String st:operations){
            if(st.contains("+")) res++;
            else res--;
        }
        return res;
    }
}