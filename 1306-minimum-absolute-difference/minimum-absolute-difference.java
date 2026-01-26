class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minAbsDiff = Integer.MAX_VALUE;

        for(int i=0;i<n-1;i++) {
            minAbsDiff = Math.min(minAbsDiff,Math.abs(arr[i+1]-arr[i]));
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int diff = Math.abs(arr[i+1]-arr[i]);
            if(diff == minAbsDiff){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                res.add(list);
            }
        }

        return res;
    }
}