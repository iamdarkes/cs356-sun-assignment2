/**
 * Counts both positive and total tweets
 */
public class MessageCounter {

    private static MessageCounter instance;
    private static int totalPositiveMessages = 0;
    private static int totalMessages = 0;

    private MessageCounter() {

    }

    public static MessageCounter getInstance() {
        if (instance == null) {
            instance = new MessageCounter();
        }
        return instance;
    }

    public static void incrementTotalMessages() {
        totalMessages += 1;
    }

    public static void incrementTotalPositiveMessages() {
        totalPositiveMessages += 1;
    }

    public static int getTotalPositiveMessages() {
        return totalPositiveMessages;
    }

    public static void setTotalPositiveMessages(int totalPositiveMessages) {
        MessageCounter.totalPositiveMessages = totalPositiveMessages;
    }

    public static int getTotalMessages() {
        return totalMessages;
    }

    public static void setTotalMessages(int totalMessages) {
        MessageCounter.totalMessages = totalMessages;
    }

    public static double positivePercentage() {
        return ((double) totalPositiveMessages / (double) totalMessages) * 100;
    }
}
