class Solution {
    private String res="";
    void solve(Set<String> list, int len, StringBuilder temp) {
        if(temp.length()==len) {
            String str = temp.toString();
            if(!list.contains(str)) {
                res = str;
            }
            return;
        }

        if(!res.isEmpty()) return;

        temp.append("0");
        solve(list, len, temp);
        temp.deleteCharAt(temp.length()-1);

        if(!res.isEmpty()) return;

        temp.append("1");
        solve(list, len, temp);
        temp.deleteCharAt(temp.length()-1);
    }
    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        Set<String> list = new HashSet<>();
        for(String num : nums) {
            list.add(num);
        }
        
        solve(list,len,new StringBuilder());
        return res;
    }
}