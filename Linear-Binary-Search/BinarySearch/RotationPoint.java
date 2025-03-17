import java.util.Scanner;

public class RotationPoint {
    public static int rotatedIndex(int[] arr){
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=(left+(right-left))/2;
            if(arr[mid]>arr[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter elements of rotated sorted array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Index of rotated point: "+rotatedIndex(arr));
    }
}
