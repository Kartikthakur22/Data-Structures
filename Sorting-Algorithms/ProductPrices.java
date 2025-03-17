import java.util.Scanner;

public class ProductPrices {
    public static void quickSort(int[] bookPrices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(bookPrices, low, high);
            quickSort(bookPrices, low, pivotIndex - 1);
            quickSort(bookPrices, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                swap(prices, i, j);
            }
        }
        
        swap(prices, i + 1, high);
        return i + 1;
    }
    
    public static void swap(int[] prices, int i, int j) {
        int temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of products:");
        int n=sc.nextInt();
        int[] bookPrices=new int[n];
        System.out.print("Enter prices of products:");
        for(int i=0;i<n;i++){
            bookPrices[i]=sc.nextInt();
        }
        quickSort(bookPrices,0,bookPrices.length-1);
        System.out.print("products prices in ascending order:");
        for(int i=0;i<n;i++){
            System.out.print(bookPrices[i]+" ");
        }
    }
}
