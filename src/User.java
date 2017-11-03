import java.util.List;
import java.util.UUID;

public class User {
    private UUID userId;
    private List<UUID> followers;
    private List<UUID> following;
    private List<Tweet> feed;
    private String name;

    public User() {
        this.userId = UUID.randomUUID();
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

    public List<UUID> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UUID> followers) {
        this.followers = followers;
    }

    public List<UUID> getFollowing() {
        return following;
    }

    public void setFollowing(List<UUID> following) {
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
}
