class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight:weights){
            low=Math.max(low,weight);
            high+=weight;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            int requiredDays=1;
            int currentLoad=0;
            for(int weight:weights){
                if(currentLoad+weight<=mid) currentLoad+=weight;
                else {
                    requiredDays++;
                    currentLoad=weight;
                }
            }
            if(requiredDays<=days) high=mid;
            else low=mid+1;
        }
        return low;
    }
}