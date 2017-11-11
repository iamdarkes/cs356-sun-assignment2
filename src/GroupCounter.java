/**
 * Implementation of visitor pattern
 */
public class GroupCounter extends TwitterElement {
    @Override
    public void accept(TwitterVisitor visitor) {
        visitor.visit(this);
    }
}
