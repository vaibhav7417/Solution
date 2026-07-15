class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[]= new int[2];
        arr[0]=0;
        arr[1]=0;
        int a=-1;
        int b=-1;
        int i,j;
        int length= nums.length;
        for(i=0;i<length;i++){
            if(target==nums[i]){
                a=i;
                break;
            }
       }
       for(j=length-1;j>=0;j--){
        if(target==nums[j]){
            b=j;
            break;
        }


       }
        arr[0]=a;
        arr[1]=b;
        return arr;
    }
}