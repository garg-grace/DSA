class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int sz=n/k;
        if(n%k!=0) sz++;
        String[] res = new String[sz];

        for(int i=0;i<n;i+=k){
            String temp = (i+k<n+1)?s.substring(i,i+k):s.substring(i);
            if(i+k>n){
                while(temp.length()<k) temp+=fill;
            }
            res[i/k]=temp;
        }
        return res;
    }
}