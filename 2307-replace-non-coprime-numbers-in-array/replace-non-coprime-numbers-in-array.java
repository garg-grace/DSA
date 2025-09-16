class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num:nums){
            while(!list.isEmpty()){
                int last = list.get(list.size()-1);
                int g = gcd(last,num);
                if(g==1) break;

                list.remove(list.size()-1);
                num = (last/g)*num;
            }
            list.add(num);
        }
        return list;
    }

    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}