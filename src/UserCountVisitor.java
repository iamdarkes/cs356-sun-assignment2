/**
 * implementation of visitor pattern
 */
public class UserCountVisitor implements TwitterVisitor {

    private int userCounter = 0;

    @Override
    public void visit(TwitterElement twitterElement) {
        setUserCounter(getUserCounter() + 1);
    }

    public int getUserCounter() {
        return userCounter;
    }

    public void setUserCounter(int userCounter) {
        this.userCounter = userCounter;
    }
}
