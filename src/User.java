import java.util.*;

public class User extends Observable implements Observer {
    private UUID userId;
    private List<User> followers;
    private List<User> following;
    private List<Tweet> feed;
    private String name;
    private FollowingDefaultListModelObserver followingModel;
    private FeedDefaultListModelObserver feedModel;

    public User() {
        super();
        this.userId = UUID.randomUUID();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.feed = new ArrayList<>();
        this.followingModel = new FollowingDefaultListModelObserver();
        this.feedModel = new FeedDefaultListModelObserver();
    }

    public User(String name) {
        super();
        this.name = name;
        this.userId = UUID.randomUUID();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.feed = new ArrayList<>();
        this.followingModel = new FollowingDefaultListModelObserver();
        this.feedModel = new FeedDefaultListModelObserver();
    }

    public User(UUID userId, List<User> followers, List<User> following, List<Tweet> feed, String name) {
        super();
        this.userId = userId;
        this.followers = followers;
        this.following = following;
        this.feed = feed;
        this.name = name;
        this.followingModel = new FollowingDefaultListModelObserver();
        this.feedModel = new FeedDefaultListModelObserver();
    }

    public FollowingDefaultListModelObserver getFollowingModel() {
        return followingModel;
    }

    public void setFollowingModel(FollowingDefaultListModelObserver followingModel) {
        this.followingModel = followingModel;
    }

    public FeedDefaultListModelObserver getFeedModel() {
        return feedModel;
    }

    public void setFeedModel(FeedDefaultListModelObserver feedModel) {
        this.feedModel = feedModel;
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void addFollowing(User user) {
        following.add(user);
    }

    public void addFeed(String message) {
        feed.add(new Tweet(this, message, UUID.randomUUID()));
    }

    public void addFeed(Tweet tweet) {
        feed.add(tweet);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Tweet> getFeed() {
        return feed;
    }

    public void setFeed(List<Tweet> feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    void changedData(Object data) {
        setChanged();
        notifyObservers(data);
    }
}
