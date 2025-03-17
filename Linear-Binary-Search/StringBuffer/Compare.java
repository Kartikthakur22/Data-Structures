public class Compare {
    public static void main(String[] args) {
        int numberOfStrings = 1000000;
        String testString = "hello";

        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numberOfStrings; i++) {
            stringBuffer.append(testString);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfStrings; i++) {
            stringBuilder.append(testString);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        System.out.println("Time taken by StringBuffer for " + numberOfStrings + " append operations: " + durationBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder for " + numberOfStrings + " append operations: " + durationBuilder + " nanoseconds");
    }
}
