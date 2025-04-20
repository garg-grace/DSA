class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num:answers){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        int ans=0;
        for(Map.Entry<Integer,Integer> it : mp.entrySet()){
            int color = it.getKey();
            int count = it.getValue();
            ans+=Math.ceil((double)count/(color+1))*(color+1);
        }
        return ans;
    }
}