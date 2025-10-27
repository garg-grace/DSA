class Solution {
    public int numberOfBeams(String[] bank) {
        int res=0;
        int last=0;

        for(String str:bank){
            int sd = 0;
            for(char ch:str.toCharArray()){
                if(ch=='1') sd++;
            }
            if(sd!=0){
                res += (last*sd);
                last=sd;
            }
        }

        return res;
    }
}