class Solution {
    public int minPartitions(String n) {
        int res = 0;

        for(char ch : n.toCharArray()) {
            int num = ch-'0';
            if(num>res) res=num;
        }
        return res;
    }
}