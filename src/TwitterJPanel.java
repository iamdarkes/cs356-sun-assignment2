import javax.swing.*;
import java.awt.*;

public class TwitterJPanel extends JPanel implements View{

    public TwitterJPanel() {
        super();
    }

    public TwitterJPanel(BorderLayout borderLayout) {
        super(borderLayout);
    }

    @Override
    public void display() {
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
}
