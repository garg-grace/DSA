class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int res1=0,res2=0;
        boolean flag = false;
        for(char ch : s.toCharArray()) {
            if(!flag) {
                if(ch=='0') res2++;
                else res1++;
            } else {
                if(ch=='1') res2++;
                else res1++;
            }
            flag=!flag;
        }
        return Math.min(res1,res2);
    }
}