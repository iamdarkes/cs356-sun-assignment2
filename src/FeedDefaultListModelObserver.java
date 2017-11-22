import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * custom DefaultListModel to display tweets
 */
public class FeedDefaultListModelObserver extends DefaultListModel implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof User && o instanceof Tweet) {
            if (!((User) observable).getFeed().contains(o)) {
                ((User) observable).addFeed((Tweet) o);
            }
            //((User) observable).setLateUpdateTime(System.currentTimeMillis());
            addElement(this, o);
        }

    }

    public void addElement(DefaultListModel defaultListModel, Object o) {
        defaultListModel.addElement(o);
    }
}
