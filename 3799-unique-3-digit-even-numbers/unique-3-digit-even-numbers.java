class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int validCount = 0;
        for (int i = 100; i <= 999; i += 2) {
            int d1 = i / 100;
            int d2 = (i / 10) % 10;
            int d3 = i % 10;

            int[] temp = new int[10];
            temp[d1]++;
            temp[d2]++;
            temp[d3]++;

            if (temp[d1] <= count[d1] && temp[d2] <= count[d2] && temp[d3] <= count[d3]) {
                validCount++;
            }
        }

        return validCount;
    }
}