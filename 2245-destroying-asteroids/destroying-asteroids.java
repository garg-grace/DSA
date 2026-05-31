class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;

        for(int am : asteroids) {
            if(am>currentMass) return false;

            currentMass+=am;
        }
        return true;
    }
}