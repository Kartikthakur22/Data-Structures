import java.util.Scanner;

public class BookPrices {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(prices, left, mid);
        mergeSort(prices, mid + 1, right);
        merge(prices, left, mid, right);
    }

    private static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of books:");
        int n=sc.nextInt();
        int[] bookPrices=new int[n];
        System.out.print("Enter price books:");
        for(int i=0;i<n;i++){
            bookPrices[i]=sc.nextInt();
        }
        mergeSort(bookPrices,0,bookPrices.length-1);
        System.out.print("Books prices in ascending order:");
        for(int i=0;i<n;i++){
            System.out.print(bookPrices[i]+" ");
        }
    }
}
