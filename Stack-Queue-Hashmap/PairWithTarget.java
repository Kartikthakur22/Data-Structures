import java.util.HashMap;
import java.util.Scanner;

public class PairWithTarget {
    public static boolean pairExist(int[] arr,int target){
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            int complement=target-arr[i];
            if(hm.containsKey(complement)){
                return true;
            }
            hm.put(arr[i],i);
        }
        return false;
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
        if(pairExist(arr, target)){
            System.out.println("Pair exists with this target");
        }else{
            System.out.println(" No Pair exists with this target");
        }
    }
}