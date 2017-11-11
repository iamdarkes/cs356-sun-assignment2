import java.util.List;

/**
 * contains composite pattern elements containing a list of UI views
 */
public class Window implements View {

    private List<View> views;

    @Override
    public void display() {
        for (View v : views) {
            v.display();
        }
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }
}
