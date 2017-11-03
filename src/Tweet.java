import java.util.UUID;

public class Tweet {
    private UUID userId;
    private String message;
    private UUID tweetId;

    public Tweet() {
        this.tweetId = UUID.randomUUID();
    }

    public UUID getTweetId() {
        return tweetId;
    }

    public void setTweetId(UUID tweetId) {
        this.tweetId = tweetId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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
                "userId=" + userId +
                ", message='" + message + '\'' +
                ", tweetId=" + tweetId +
                '}';
    }
}
