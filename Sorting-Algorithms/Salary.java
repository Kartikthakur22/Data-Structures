import java.util.Scanner;

public class Salary {
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }

    private static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }

    private static void swap(double[] salaries, int i, int j) {
        double temp = salaries[i];
        salaries[i] = salaries[j];
        salaries[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of employees:");
        int n=sc.nextInt();
        double[] salary=new double[n];
        System.out.print("Enter employee ids:");
        for(int i=0;i<n;i++){
            salary[i]=sc.nextInt();
        }
        heapSort(salary);
        System.out.print("Employee ids in ascending order:");
        for(int i=0;i<n;i++){
            System.out.print(salary[i]+" ");
        }
    }
}
