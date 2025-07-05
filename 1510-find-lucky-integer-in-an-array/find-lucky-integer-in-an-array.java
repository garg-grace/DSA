class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:arr){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        int res=-1;
        for(int k:freq.keySet()){
            int v=freq.get(k);
            if(k==v){
                if(k>res) res=k;
            }
        }
        return res;
    }
}