class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols=len/rows;
        char[][] arr = new char[rows][cols];
        int idx=0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                arr[i][j]=encodedText.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0;j<cols;j++){
            int d=j;
            for(int i=0;i<rows && d<cols;i++){
                sb.append(arr[i][d++]);
                // System.out.println(sb);
            }
        }
        return sb.toString().stripTrailing();
    }
}