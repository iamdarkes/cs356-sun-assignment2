import java.util.List;

public class VisitorCollection extends TwitterElement{

    private List<TwitterElement> collection;

    public List<TwitterElement> getCollection() {
        return collection;
    }

    public void setCollection(List<TwitterElement> collection) {
        this.collection = collection;
    }

    @Override
    public void accept(TwitterVisitor visitor) {
        for(TwitterElement twitterElement : collection) {
            twitterElement.accept(visitor);
        }
    }
}
