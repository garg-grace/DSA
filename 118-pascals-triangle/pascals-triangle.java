class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));

        for(int i=2;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> temp = res.get(res.size()-1);
            for(int j=0;j<temp.size()-1;j++){
                list.add(temp.get(j)+temp.get(j+1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}