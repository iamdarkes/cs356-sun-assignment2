import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class AdminControlPanel extends JPanel {

    private static AdminControlPanel instance;

    private AdminControlPanel() {

        JFrame frame = new JFrame("Mini Twitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //all elements nested inside
        JPanel outerMostPanel = new JPanel(new BorderLayout());

        //JTree nested inside only, nested directly in outerMostPanel
        JPanel treeViewPanel = new JPanel(new BorderLayout());
        treeViewPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //JTextField and JButton for adding users nested inside, nested directly in addPanel
        JPanel addUserPanel = new JPanel(new BorderLayout());
        addUserPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //JTextField and JButton for adding groups nested inside, nested directly in addPanel
        JPanel addGroupPanel = new JPanel(new BorderLayout());
        addGroupPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //addUserPanel and addGroupPanel nested directly inside, nested directly in outerEastPanel
        JPanel addPanel = new JPanel(new BorderLayout());
        addPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //JButton openUserView nested directly inside, nested directly in outerEastPanel
        JPanel openUserViewPanel = new JPanel(new BorderLayout());
        openUserViewPanel.setBorder(BorderFactory.createEmptyBorder(150, 5, 150, 5));

        //addPanel, openUserViewPanel, showPanel nested directly inside, nested directly in outerMostPanel
        JPanel outerEastPanel = new JPanel(new BorderLayout());
        outerEastPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //JButtons showUserTotal, showGroupTotal nested directly inside, inside showPanel
        JPanel showTopPanel = new JPanel(new BorderLayout());
        showTopPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //JButtons showMessagesTotal, showPositivePercentage nested directly inside, inside showPanel
        JPanel showBottomPanel = new JPanel(new BorderLayout());
        showBottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //showTopPanel, showBottomPanel nested inside, inside outerEastPanel
        JPanel showPanel = new JPanel(new BorderLayout());
        showPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JTree userJTree = new JTree(new DefaultMutableTreeNode("Root"));
        userJTree.setScrollsOnExpand(true);
        userJTree.setPreferredSize(new Dimension(400, 500));
        treeViewPanel.add(userJTree);
        outerMostPanel.add(outerEastPanel, BorderLayout.EAST);
        outerMostPanel.add(treeViewPanel, BorderLayout.WEST);

        JTextField addUserTextField = new JTextField(10);
        final String[] addUserText = {""};
        addUserTextField.getDocument().addDocumentListener(new DocumentListener() {
            //when change is made to text
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                addUserText[0] = addUserTextField.getText();
                System.out.println(addUserText[0]);
            }

            //when field is cleared.
            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                addUserText[0] = addUserTextField.getText();
                System.out.println(addUserText[0]);
            }

            //not sure when this happens
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                System.out.println("This happened");
            }
        });
        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!addUserText[0].equals("")) {
                    DefaultTreeModel model = (DefaultTreeModel) userJTree.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
                    model.insertNodeInto(new DefaultMutableTreeNode(addUserText[0]), root, root.getChildCount());
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a user name.");
                }
            }
        });

        JTextField addGroupTextField = new JTextField(10);
        JButton addGroupButton = new JButton("Add Group");

        JButton openUserViewButton = new JButton("Open User View");
        openUserViewButton.setActionCommand("OPEN_USER_VIEW");
        openUserViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserViewPanel();
            }
        });

        openUserViewPanel.add(openUserViewButton, BorderLayout.CENTER);

        JButton showUserTotalButton = new JButton("Show User Total");
        showUserTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "User Total: ");
            }
        });

        JButton showGroupTotalButton = new JButton("Show Group Total");
        showGroupTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Group Total: ");
            }
        });

        showTopPanel.add(showUserTotalButton, BorderLayout.WEST);
        showTopPanel.add(showGroupTotalButton, BorderLayout.EAST);

        JButton showMessagesTotalButton = new JButton("Show Messages Total");
        showMessagesTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Messages Total: ");
            }
        });

        JButton showPositivePercentageButton = new JButton("Show Positive Percentage");
        showPositivePercentageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Positive Percentage: ");
            }
        });

        showBottomPanel.add(showMessagesTotalButton, BorderLayout.WEST);
        showBottomPanel.add(showPositivePercentageButton, BorderLayout.EAST);

        showPanel.add(showTopPanel, BorderLayout.NORTH);
        showPanel.add(showBottomPanel, BorderLayout.SOUTH);

        addUserPanel.add(addUserTextField, BorderLayout.WEST);
        addUserPanel.add(addUserButton, BorderLayout.EAST);

        addGroupPanel.add(addGroupButton, BorderLayout.EAST);
        addGroupPanel.add(addGroupTextField, BorderLayout.WEST);

        addPanel.add(addUserPanel, BorderLayout.NORTH);
        addPanel.add(addGroupPanel, BorderLayout.SOUTH);

        outerEastPanel.add(addPanel, BorderLayout.NORTH);
        outerEastPanel.add(openUserViewPanel, BorderLayout.CENTER);
        outerEastPanel.add(showPanel, BorderLayout.SOUTH);

        frame.setContentPane(outerMostPanel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Create the GUI and show it using Singleton pattern.
     */
    public static AdminControlPanel getInstance() {
        if (instance == null) {
            instance = new AdminControlPanel();
        }
        return instance;
    }

}
