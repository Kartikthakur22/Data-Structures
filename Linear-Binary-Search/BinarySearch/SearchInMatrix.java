import java.util.Scanner;

public class SearchInMatrix {
    public static boolean search(int[][] matrix,int target){
        int r=matrix.length,c=matrix[0].length;
        int left=0,right=r*c-1;
        while(left<=right){
            int mid=(left+right)/2;
            int i=mid/c,j=mid%c;
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] matrix=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int target=sc.nextInt();
        if(search(matrix,target)){
            System.out.println("Target found in matrix");
        }
        else{
            System.out.println("No target found in matrix");
        }
    }
}
