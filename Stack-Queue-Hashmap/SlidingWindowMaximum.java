import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindowMaximum {
    public static int[] windowMax(int[] arr,int k){
        int n=arr.length,j=0;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[n-k+1];
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[j++]=arr[dq.peekFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter window size:");
        int k=sc.nextInt();
        int[] ans=windowMax(arr,k);
        System.out.print("Sliding window max array:");
        for(int i=0;i<n-k+1;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
