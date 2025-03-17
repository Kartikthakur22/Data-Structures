import java.util.Scanner;

public class SortEmployeeId {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of employees:");
        int n=sc.nextInt();
        int[] ids=new int[n];
        System.out.print("Enter employee ids:");
        for(int i=0;i<n;i++){
            ids[i]=sc.nextInt();
        }
        insertionSort(ids);
        System.out.print("Employee ids in ascending order:");
        for(int i=0;i<n;i++){
            System.out.print(ids[i]+" ");
        }
    }
}
