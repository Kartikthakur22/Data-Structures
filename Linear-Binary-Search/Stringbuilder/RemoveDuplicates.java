import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicates(String str){
        StringBuilder sb=new StringBuilder();
        HashSet<Character> seen=new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(!seen.contains(str.charAt(i))){
                sb.append(str.charAt(i));
                seen.add(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        String unique = removeDuplicates(input);
        System.out.println("After removing duplicates: " + unique);
    }
}
