
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReadUserInput {
    public static void main(String[] args) {
        String fileName = "user_input.txt";  // The file where user input will be written
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) {  // 'true' to append to the file
            
            String input;
            System.out.println("Enter your input. Type 'exit' to stop.");
            
            while (true) {
                input = reader.readLine();
                
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                
                writer.write(input + System.lineSeparator());  // Write input followed by a new line
            }
            
            System.out.println("Input has been written to the file.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
