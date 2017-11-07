public interface TwitterVisitor {
    public void visitUser(User user);
    public void visitTweets(Tweet tweet);
    public void visitPositiveTweets(Tweet tweet);
    public void visitUserGroup(UserGroup userGroup);

}
