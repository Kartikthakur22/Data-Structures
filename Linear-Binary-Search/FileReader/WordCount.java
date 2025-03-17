import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {
        String fileName = "example.txt";  // Replace with the path to your text file
        String targetWord = "example";    // Replace with the word you want to count
        
        int wordCount = countWordOccurrences(fileName, targetWord);
        System.out.println("The word '" + targetWord + "' appeared " + wordCount + " times.");
    }

    public static int countWordOccurrences(String fileName, String targetWord) {
        int count = 0;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");  // Split the line into words using whitespace
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}
