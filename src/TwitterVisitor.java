/**
 * interface for visitor pattern
 */
public interface TwitterVisitor {
    public void visit(TwitterElement twitterElement);
    public void visit(User user);

}
