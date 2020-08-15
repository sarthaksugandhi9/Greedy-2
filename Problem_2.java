// Time complexity - O(n)
// Space complexity - O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for(char task : tasks){
            int cnt = map.getOrDefault(task,0);
            maxFreq = Math.max(maxFreq,cnt+1);
            map.put(task,cnt+1);
        }
        
        for(char c : map.keySet()){
            if(map.get(c) == maxFreq){
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int empty = (n - (maxCount - 1))* partitions;
        int pending =   tasks.length - maxFreq*maxCount;
        int idle = Math.max(0, empty - pending);
        return idle + tasks.length;
    }
}
