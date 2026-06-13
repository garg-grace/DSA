class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int wt = Math.abs(calculateWordWeight(words[i],weights)%26-25);
            sb.append((char)('a'+wt));
        }

        return sb.toString();
    }

    private int calculateWordWeight(String word, int[] weights) {
        int wt = 0;
        for(char ch : word.toCharArray()) {
            wt += weights[ch-'a'];
        }
        return wt;
    }
}