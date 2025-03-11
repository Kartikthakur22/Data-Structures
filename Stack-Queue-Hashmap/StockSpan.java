import java.util.Stack;
import java.util.Scanner;

public class StockSpan {
    public static int[] calculate(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        ans[0]=1;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of stocks:");
        int n=sc.nextInt();
        int[] stocks=new int[n];
        System.out.print("Enter stocks:");
        for(int i=0;i<n;i++){
            stocks[i]=sc.nextInt();
        }
        int[] ans=calculate(stocks);
        System.out.print("Span array:");
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
