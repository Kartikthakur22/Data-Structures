import java.util.Scanner;

public class ReverseString {
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }
}
