import javax.swing.*;
import java.awt.*;

public class TwitterJFrame extends JFrame implements View {

    @Override
    public void display() {
        this.setTitle("Mini Twitter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
