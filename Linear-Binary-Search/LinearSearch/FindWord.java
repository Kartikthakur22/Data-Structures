import java.util.Scanner;

public class FindWord {
    static String foundOrNot(String[] sentences,String word){
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of sentences:");
        int n=sc.nextInt();
        String[] arr=new String[n];
        System.out.print("Enter sentences:");
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        System.out.print("Enter word to find:");
        String word=sc.next();
        String ans = foundOrNot(arr, word);
        if(ans=="Not Found"){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}
