class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings,(a,b)->a[2]-b[2]);

        Set<Integer> knowsSecret = new HashSet<>();
        knowsSecret.add(0);
        knowsSecret.add(firstPerson);

        Map<Integer,List<int[]>> meetingsByTime = new HashMap<>();
        for(int[] m:meetings) {
            meetingsByTime.computeIfAbsent(m[2],k->new ArrayList()).add(m);
        }

        List<Integer> timePoints = new ArrayList<>(meetingsByTime.keySet());
        Collections.sort(timePoints);

        for(int time:timePoints) {
            Map<Integer,List<Integer>> adj = new HashMap<>();
            Set<Integer> involved = new HashSet<>();

            for(int[] meeting:meetingsByTime.get(time)){
                int p1=meeting[0];
                int p2=meeting[1];

                adj.computeIfAbsent(p1,k->new ArrayList<>()).add(p2);
                adj.computeIfAbsent(p2,k->new ArrayList<>()).add(p1);

                involved.add(p1);
                involved.add(p2);
            }

            Set<Integer> peopleWithSecret = new HashSet<>();
            for(int person:involved){
                if(knowsSecret.contains(person)) peopleWithSecret.add(person);
            }
            Queue<Integer> q = new LinkedList<>(peopleWithSecret);
            Set<Integer> visited = new HashSet<>(q);

            while(!q.isEmpty()){
                int person = q.poll();

                if(adj.containsKey(person)){
                    for(int nextPerson:adj.get(person)){
                        if(!visited.contains(nextPerson)){
                            visited.add(nextPerson);
                            q.add(nextPerson);
                            peopleWithSecret.add(nextPerson);
                        }
                    }
                }
            }
            knowsSecret.addAll(peopleWithSecret);
        }
        return new ArrayList<>(knowsSecret);
        
    }
}