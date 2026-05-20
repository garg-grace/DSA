class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            freq[A[i]]++;
            freq[B[i]]++;

            if(i!=0) res[i]=res[i-1];

            if(freq[A[i]] == 2) res[i]++;
            if(A[i]!=B[i] && freq[B[i]] == 2) res[i]++;
        }
        return res;
    }
}