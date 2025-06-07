class Pair{
    char ch;
    int index;
    public Pair(char ch,int i){
        this.ch=ch;
        this.index=i;
    }
}
class Solution {
    public String clearStars(String s) {
        int n=s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> {
            if (x.ch == y.ch) return y.index - x.index;
            return x.ch - y.ch;
        });
        Set<Integer> toRemove = new HashSet<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='*'){
                Pair it = pq.poll();
                toRemove.add(it.index);
            }else{
                pq.add(new Pair(ch,i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch!='*' && !toRemove.contains(i)) sb.append(ch);
        }
        return sb.toString();
    }
}