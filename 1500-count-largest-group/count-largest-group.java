class Solution {
    private int calculateDigitSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        Map<Integer,Integer> mp = new HashMap<>();
        int maxi=0;
        for(int i=1;i<=n;i++){
            int digitSum = calculateDigitSum(i);
            mp.put(digitSum,mp.getOrDefault(digitSum,0)+1);
            maxi=Math.max(maxi,mp.get(digitSum));
        }

        int cnt=0;
        for(Map.Entry<Integer,Integer> it:mp.entrySet()){
            if(it.getValue()==maxi) cnt++;
        }
        return cnt;
    }
}