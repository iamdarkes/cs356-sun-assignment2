/**
 * Implementation of visitor pattern
 */
public class GroupCountVisitor implements TwitterVisitor {

    private int groupCounter = 1;

    @Override
    public void visit(TwitterElement twitterElement) {
        setGroupCounter(getGroupCounter() + 1);
    }

    public int getGroupCounter() {
        return groupCounter;
    }

    public void setGroupCounter(int groupCounter) {
        this.groupCounter = groupCounter;
    }
}
