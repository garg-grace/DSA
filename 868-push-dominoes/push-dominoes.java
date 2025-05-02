class Pair{
    int i;
    char d;
    public Pair(int i,char d){
        this.i=i;
        this.d=d;
    }
}
class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<dominoes.length();i++){
            if(dominoes.charAt(i)!='.') q.add(new Pair(i,dominoes.charAt(i)));
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i=p.i;
            char d=p.d;

            if(d=='L' && i>0 && sb.charAt(i-1)=='.'){
                q.add(new Pair(i-1,'L'));
                sb.setCharAt(i-1,'L');
            }else if(d=='R'){
                if((i+1)<sb.length() && sb.charAt(i+1)=='.'){
                    if((i+2)<sb.length() && sb.charAt(i+2)=='L') q.remove();
                    else{
                        q.add(new Pair(i+1,'R'));
                        sb.setCharAt(i+1,'R');
                    }
                }
            }
        }
        return sb.toString();        
    }
}