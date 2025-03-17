import java.util.Scanner;

class SortStudentMarks{
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of students:");
        int n=sc.nextInt();
        int[] marks=new int[n];
        System.out.print("Enter marks of students:");
        for(int i=0;i<n;i++){
            marks[i]=sc.nextInt();
        }
        bubbleSort(marks);
        System.out.print("Marks of students in ascending order:");
        for(int i=0;i<n;i++){
            System.out.print(marks[i]+" ");
        }
    }
}