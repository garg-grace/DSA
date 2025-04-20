class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int num:answers){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> it:mp.entrySet()){
            int color=it.getKey();
            int count=it.getValue();

            if(count>color+1){
                int freq = count/(color+1);
                ans+=(freq*(color+1));
                int rem = count%(color+1);
                if(rem!=0) ans+=(color+1);
            }else{
                ans+=color+1;
            }
        }
        return ans;
    }
}