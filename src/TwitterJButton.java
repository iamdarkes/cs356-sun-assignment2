import javax.swing.*;

/**
 * implementation of composite pattern
 */
public class TwitterJButton extends JButton implements View {

    public TwitterJButton() {
        super();
    }

    public TwitterJButton(String name) {
        super(name);
    }

    @Override
    public void display() {
    }
}
