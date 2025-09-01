class Solution {
    private double calculateGain(int passes,int students){
        return((double)(passes+1)/(students+1)-(double)passes/students);
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));

        for(int[] c:classes){
            double gain = calculateGain(c[0],c[1]);
            maxHeap.offer(new double[]{gain,c[0],c[1]});
        }

        while(extraStudents-- >0){
            double[] current = maxHeap.poll();
            int passes = (int)current[1];
            int students = (int)current[2];
            double gain = calculateGain(passes+1,students+1);
            maxHeap.offer(new double[]{gain,passes+1,students+1});
        }

        double totalPassRatio=0;

        while(!maxHeap.isEmpty()){
            double[] current = maxHeap.poll();
            totalPassRatio+= current[1]/current[2];
        }
        return totalPassRatio/classes.length;        
    }
}