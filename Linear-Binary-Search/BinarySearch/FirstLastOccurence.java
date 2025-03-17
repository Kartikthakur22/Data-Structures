public class FirstLastOccurence {
    public int first(int[] nums,int target){
        int ind=-1;
        int l=0,h=nums.length-1;
        while(l<=h){
            int m=l+((h-l)/2);
            if(nums[m]>target){
                h=m-1;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                ind=m;
                h=m-1;
            }
        }
        return ind;
    }
    public int last(int[] nums,int target){
        int ind=-1;
        int l=0,h=nums.length-1;
        while(l<=h){
            int m=l+((h-l)/2);
            if(nums[m]>target){
                h=m-1;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                ind=m;
                l=m+1;
            }
        }
        return ind;
    }
}

