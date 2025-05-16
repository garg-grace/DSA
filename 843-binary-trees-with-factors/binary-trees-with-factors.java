class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Long> mp = new HashMap<>();

        for(int root:arr){
            mp.put(root,1L);

            for(int factor:arr){
                if(factor>=root) break;

                if(root%factor==0 && mp.containsKey(root/factor)){
                    mp.put(root,mp.get(root)+mp.get(factor)*mp.get(root/factor));
                }

            }
        }

        long res=0L;
        for(Map.Entry<Integer,Long> it:mp.entrySet()){
            res = (res+it.getValue())%1_000_000_007;
            
        }
        return (int)res;        
    }
}