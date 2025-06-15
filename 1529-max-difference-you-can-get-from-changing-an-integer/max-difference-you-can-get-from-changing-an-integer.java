class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for(char x='0';x<='9';x++){
            for(char y='0';y<='9';y++){
                StringBuilder sb = new StringBuilder();
                boolean replaced = false;

                for(char ch:numStr.toCharArray()){
                    if(ch==x){
                        sb.append(y);
                        replaced=true;
                    }else{
                        sb.append(ch);
                    }
                }

                if(!replaced) continue;

                if(sb.charAt(0)=='0') continue;

                int val = Integer.parseInt(sb.toString());
                maxVal=Math.max(maxVal,val);
                minVal=Math.min(minVal,val);
            }
        }

        return maxVal-minVal;        
    }
}