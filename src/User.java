import java.util.*;

public class User extends Observable implements Observer {
    private UUID userId;
    private List<User> followers;
    private List<User> following;
    private List<Tweet> feed;
    private String name;

    public User() {
        super();
        this.userId = UUID.randomUUID();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.feed = new ArrayList<>();
    }

    public User(String name) {
        super();
        this.name = name;
        this.userId = UUID.randomUUID();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.feed = new ArrayList<>();
    }

    public User(UUID userId, List<User> followers, List<User> following, List<Tweet> feed, String name) {
        super();
        this.userId = userId;
        this.followers = followers;
        this.following = following;
        this.feed = feed;
        this.name = name;
    }

    public void addFollowing(User user){
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
        return "User{" +
                "userId=" + userId +
                ", followers=" + followers +
                ", following=" + following +
                ", feed=" + feed +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void update(Observable observable, Object o) {
//        if(observable instanceof User) {
//            if(o instanceof Tweet) {
//                for (Tweet t : ((User) observable).getFeed()) {
//                    System.out.println(t.toString());
//                    this.addFeed(t);
//                }
//            }
//
//            if(o instanceof User) {
//                System.out.println("rdsaf");
//                ((User) observable).addFollowing((User)o);
//            }
//        }
//        System.out.println("tests " + observable.toString() + " " + o.toString());
    }

    void changedData(Object data) {
//        if(data instanceof User) {
//            addFollowing((User) data);
//        }
//
//        if(data instanceof Tweet) {
//            addFeed((Tweet)data);
//        }
        setChanged();
        notifyObservers(data);
    }
}
