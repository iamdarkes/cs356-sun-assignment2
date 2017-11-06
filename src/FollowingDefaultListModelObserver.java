import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class FollowingDefaultListModelObserver extends DefaultListModel implements Observer{
    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof User && o instanceof User) {
            if (!((User)observable).getFollowing().contains(o)) {
                ((User) observable).addFollowing((User) o);
            }
            addElement(this, o);
        }

    }
    public void addElement(DefaultListModel defaultListModel, Object o) {
        defaultListModel.addElement(o);
        //defaultListModel.addElement(((User)o).getName());
    }

}
