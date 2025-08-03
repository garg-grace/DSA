class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> mp = new HashMap<>();
        int minEle = Integer.MAX_VALUE;

        for(int ele : basket1){
            mp.put(ele,mp.getOrDefault(ele,0)+1);
            minEle=Math.min(minEle,ele);
        }

        for(int ele : basket2){
            mp.put(ele,mp.getOrDefault(ele,0)-1);
            minEle=Math.min(minEle,ele);
        }
        
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int cost = entry.getKey();
            int freq = Math.abs(entry.getValue());
            if(freq==0) continue;
            if(freq%2!=0) return -1;

            for(int c=1;c<=freq/2;c++) list.add(cost);
        }

        long res=0;
        Collections.sort(list);
        for(int i=0;i<list.size()/2;i++){
            res = res+Math.min(list.get(i),minEle*2);
        }

        return res;
    }
}