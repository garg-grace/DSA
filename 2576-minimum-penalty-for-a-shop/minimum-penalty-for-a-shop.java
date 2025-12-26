class Solution {
    public int bestClosingTime(String customers) {
        int totalHours = customers.length();
        int totalCustomers = 0;
        for(char c:customers.toCharArray()){
            if(c=='Y') totalCustomers++;
        }
        if(totalHours==totalCustomers) return totalHours;

        int remCustomers = totalCustomers;
        int earliestHour = totalHours; 
        int penalty = totalHours; 
        int nonVisHour = 0;
        
        for(int i=0; i<totalHours; i++) {
            char c = customers.charAt(i);
            if(nonVisHour+remCustomers<penalty){
                penalty = nonVisHour+remCustomers;
                earliestHour=i;
            }

            if(c=='Y') {
                remCustomers--;
            } else {
                nonVisHour++;
            }
            
        }

        return nonVisHour+remCustomers<penalty?totalHours:earliestHour;
    }
}