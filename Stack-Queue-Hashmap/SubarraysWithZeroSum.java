import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraysWithZeroSum {
    public static List<int[]> countSubarrays(int[] arr){
        HashMap<Integer,Integer> hm=new HashMap<>();
        ArrayList<int[]> ans=new ArrayList<>();
        int sum=0,n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if (sum == 0) {
                int[] temp = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    temp[j] = arr[j];
                }
                ans.add(temp);
            }
            if(hm.containsKey(sum)){
                int[] temp=new int[i-hm.get(sum)];
                int ind=0;
                for(int j=hm.get(sum)+1;j<=i;j++){
                    temp[ind++]=arr[j];
                }
                ans.add(temp);
            }
            hm.put(sum,i);
        }
        return ans;
    }
}
