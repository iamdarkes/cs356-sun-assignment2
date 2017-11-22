public class InvalidInputCounter {

    private static InvalidInputCounter instance;
    private static int counter = 0;

    private InvalidInputCounter() {
    }

    public static InvalidInputCounter getInstance() {
        if(instance == null) {
            instance = new InvalidInputCounter();
        }
        return instance;
    }

    public static int getCounter() {
        return counter;
    }

    public static void incrementCounter() {
        counter++;
    }
}
