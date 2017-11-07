public class CountVisitor implements TwitterVisitor {

    private int userCounter = 0;
    private int tweetCounter = 0;
    private int positiveTweetCounter = 0;
    private int groupCounter = 0;

    @Override
    public void visitUser(User user) {
        setUserCounter(getUserCounter() + 1);
    }

    @Override
    public void visitTweets(Tweet tweet) {
        setTweetCounter(getTweetCounter() + 1);
    }

    @Override
    public void visitPositiveTweets(Tweet tweet) {
        setPositiveTweetCounter(getPositiveTweetCounter() + 1);
    }

    @Override
    public void visitUserGroup(UserGroup userGroup) {
        setGroupCounter(getGroupCounter() + 1);
    }

    public int getUserCounter() {
        return userCounter;
    }

    public void setUserCounter(int userCounter) {
        this.userCounter = userCounter;
    }

    public int getTweetCounter() {
        return tweetCounter;
    }

    public void setTweetCounter(int tweetCounter) {
        this.tweetCounter = tweetCounter;
    }

    public int getPositiveTweetCounter() {
        return positiveTweetCounter;
    }

    public void setPositiveTweetCounter(int positiveTweetCounter) {
        this.positiveTweetCounter = positiveTweetCounter;
    }

    public int getGroupCounter() {
        return groupCounter;
    }

    public void setGroupCounter(int groupCounter) {
        this.groupCounter = groupCounter;
    }
}
