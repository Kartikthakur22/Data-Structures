import java.util.Scanner;

public class PeakElement {
    public static int peakElement(int[] arr){
        int l=0,r=arr.length-1;
        while(l<r){
            int m=(l+r)/2;
            if(arr[m]>arr[m-1] && arr[m]>arr[m+1]){
                return arr[m];
            }
            else if(arr[m-1]>arr[m]){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter elements array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Peak element: "+peakElement(arr));
    }
}
