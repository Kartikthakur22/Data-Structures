import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static int[] findIndices(int[] arr,int target){
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            int complement=target-arr[i];
            if(hm.containsKey(complement)){
                return new int[]{hm.get(complement),i};
            }
            hm.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter target:");
        int target=sc.nextInt();
        int[] ans=findIndices(arr,target);
        System.out.print("Pair with this target: ");
        for(int i=0;i<2;i++){
            System.out.print(ans[i]);
        }
    }
}
