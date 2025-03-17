import java.util.Scanner;

public class FirstNegative {
    public static int firstNegative(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of integers:");
        int n=sc.nextInt();
        System.out.print("Enter integers:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ans=firstNegative(arr);
        if(ans==-1){
            System.out.println("No element is negative is there");
        }
        else{
            System.out.println("First negative  element is at "+ans+" index");
        }
    }
}
