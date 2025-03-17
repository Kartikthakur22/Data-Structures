import java.util.Scanner;

public class ConcatenateStrings {
    public static String concatenate(String[] arr){
        StringBuffer sb = new StringBuffer();
        for (String str :arr) {
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter length of array:");
        int n=sc.nextInt();
        String[] arr=new String[n];
        System.out.print("Enter strings:");
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        String ans = concatenate(arr);
        System.out.println("After concatenating: " + ans );
    }
}
