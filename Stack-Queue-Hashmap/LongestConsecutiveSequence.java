import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static int lengthOfLongestSequence(int[] arr){
        int n=arr.length,maxLength=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(arr[i]);
        }
        for(int it:hs){
            if(!hs.contains(it-1)){
                int count=1;
                int x=it;
                while(hs.contains(x+1)){
                    count++;
                    x++;
                }
                maxLength=Math.max(maxLength,count);
            }
        }
        return maxLength;
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
        int length=lengthOfLongestSequence(arr);
        System.out.println("Length of longest consecutive sequence is "+length);
    }
}
