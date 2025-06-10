class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        int even = s.length();
        int odd = 0;

        for(int i=0;i<26;i++){
            int freq=arr[i];
            if(freq==0) continue;
            if(freq%2==0){
                if(freq<even) even=freq;
            }else{
                if(freq>odd) odd=freq;
            }
        }
        return odd-even;
    }
}