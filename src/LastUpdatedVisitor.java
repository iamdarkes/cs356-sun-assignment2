public class LastUpdatedVisitor implements TwitterVisitor{

    private User userLastUpdated;


    @Override
    public void visit(TwitterElement twitterElement) {
    }

    public LastUpdatedVisitor() {
        userLastUpdated = new User();
    }

    @Override
    public void visit(User user) {
        if(userLastUpdated.getLateUpdateTime() < user.getLateUpdateTime() || userLastUpdated == null) {
            userLastUpdated = user;
        }
    }

    public User getUserLastUpdated() {
        return userLastUpdated;
    }

    public void setUserLastUpdated(User userLastUpdated) {
        this.userLastUpdated = userLastUpdated;
    }
}
