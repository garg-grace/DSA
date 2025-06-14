class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        char toReplace = '*';
        for (char ch : numStr.toCharArray()) {
            if (ch != '9') {
                toReplace = ch;
                break;
            }
        }

        String largestStr = numStr;
        if (toReplace != '*') {
            largestStr = numStr.replace(toReplace, '9');
        }

        toReplace = '*';
        for (char ch : numStr.toCharArray()) {
            if (ch != '0') {
                toReplace = ch;
                break;
            }
        }

        String smallestStr = numStr;
        if (toReplace != '*') {
            smallestStr = numStr.replace(toReplace, '0');
        }

        int largest = Integer.parseInt(largestStr);
        int smallest = Integer.parseInt(smallestStr);

        return largest - smallest;
    }
}
