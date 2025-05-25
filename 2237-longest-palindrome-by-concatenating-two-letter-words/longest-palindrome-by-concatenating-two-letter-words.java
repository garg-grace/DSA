class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> mp = new HashMap<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }

        int res=0;
        Boolean sameCharOdd=false;
        for(Map.Entry<String,Integer> it:mp.entrySet()){
            String st = it.getKey();
            int cnt = it.getValue();

            String revStr = ""+st.charAt(1)+st.charAt(0);
            if(st.charAt(0)==st.charAt(1)){
                if(cnt%2==0){
                    res+=cnt;
                }else{
                    if(sameCharOdd==false){
                        res+=cnt;
                        sameCharOdd=true;
                    }else res+=(cnt-1);                    
                }
            }else{
                if(mp.containsKey(revStr)){
                    int revCnt = mp.get(revStr);
                    int temp = Math.min(cnt,revCnt);
                    res+=2*temp;
                    mp.put(revStr,0);
                }
            }
        }
        return res*2;
    }
}