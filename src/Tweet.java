import java.util.UUID;

public class Tweet {
    private User user;
    private String message;
    private UUID tweetId;

    public Tweet() {
        this.tweetId = UUID.randomUUID();
    }


    public Tweet(User user, String message, UUID tweetId) {
        this.user = user;
        this.message = message;
        this.tweetId = tweetId;
    }

    public UUID getTweetId() {
        return tweetId;
    }

    public void setTweetId(UUID tweetId) {
        this.tweetId = tweetId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "userName=" + user.getName() +
                ", message='" + message + '\'' +
                ", tweetId=" + tweetId +
                '}';
    }
}
