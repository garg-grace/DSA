class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] prefixSum = new int[n];
        int[] indices = new int[n];

        for(int i=0;i<n;i++){
            indices[i] = fruits[i][0];
            prefixSum[i]  = fruits[i][1] + (i>0?prefixSum[i-1]:0);
        }

        int maxFruits = 0;
        for(int d=0;d<=k/2;d++){
            int remain = k-2*d;
            int i = startPos-d;
            int j = startPos+remain;

            int left = lowerBound(indices,i);
            int right = upperBound(indices,j)-1;
            if(left<=right){
                int total = prefixSum[right] - (left>0?prefixSum[left-1]:0);
                maxFruits = Math.max(maxFruits,total);
            }

            remain = k-2*d;
            i = startPos-remain;
            j = startPos+d;

            left = lowerBound(indices,i);
            right = upperBound(indices,j)-1;
            if(left<=right){
                int total = prefixSum[right] - (left>0?prefixSum[left-1]:0);
                maxFruits = Math.max(maxFruits,total);
            }
        }
        
        return maxFruits;
    }

    private int lowerBound(int[] arr,int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    private int upperBound(int[] arr,int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]<=target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}