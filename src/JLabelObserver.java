import javax.swing.*;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class JLabelObserver extends JLabel implements Observer{
    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof User && o instanceof Long) {
            ((User) observable).setLateUpdateTime((Long) o);
            this.setText("Last Updated Time: " + new Date(((User) observable).getLateUpdateTime()).toString());
        }
    }
}
