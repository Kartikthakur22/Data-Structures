import java.util.Scanner;

public class ExamScores {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                swap(scores, i, minIndex);
            }
        }
    }
    
    public static void swap(int[] scores, int i, int j) {
        int temp = scores[i];
        scores[i] = scores[j];
        scores[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of scores:");
        int n=sc.nextInt();
        int[] scores=new int[n];
        System.out.print("Enter exam scores:");
        for(int i=0;i<n;i++){
            scores[i]=sc.nextInt();
        }
        selectionSort(scores);
        System.out.print("Scores in ascending order:");
        for(int i=0;i<n;i++){
            System.out.print(scores[i]+" ");
        }
    }
}
