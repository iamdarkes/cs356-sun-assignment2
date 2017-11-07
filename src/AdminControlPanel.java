import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class AdminControlPanel extends JPanel {

    public static List<View> allRootViews = new ArrayList<>();
    private static AdminControlPanel instance;
    private static int userTotal = 0;
    //root group is group 1
    private static int groupTotal = 1;

    private AdminControlPanel() {

        //Demonstrate Composite pattern with Frame, Panels and Buttons
        TwitterJFrame tJFrame = new TwitterJFrame();

        //all elements nested inside
        JPanel outerMostPanel = new JPanel(new BorderLayout());

        //JTree nested inside only, nested directly in outerMostPanel
        TwitterJPanel treeViewPanel = new TwitterJPanel(new BorderLayout());

        //JTextField and JButton for adding users nested inside, nested directly in addPanel
        TwitterJPanel addUserPanel = new TwitterJPanel(new BorderLayout());

        //JTextField and JButton for adding groups nested inside, nested directly in addPanel
        TwitterJPanel addGroupPanel = new TwitterJPanel(new BorderLayout());

        //addUserPanel and addGroupPanel nested directly inside, nested directly in outerEastPanel
        TwitterJPanel addPanel = new TwitterJPanel(new BorderLayout());

        //JButton openUserView nested directly inside, nested directly in outerEastPanel
        JPanel openUserViewPanel = new JPanel(new BorderLayout());
        openUserViewPanel.setBorder(BorderFactory.createEmptyBorder(150, 5, 150, 5));

        //addPanel, openUserViewPanel, showPanel nested directly inside, nested directly in outerMostPanel
        TwitterJPanel outerEastPanel = new TwitterJPanel(new BorderLayout());

        //JButtons showUserTotal, showGroupTotal nested directly inside, inside showPanel
        TwitterJPanel showTopPanel = new TwitterJPanel(new BorderLayout());

        //JButtons showMessagesTotal, showPositivePercentage nested directly inside, inside showPanel
        TwitterJPanel showBottomPanel = new TwitterJPanel(new BorderLayout());

        //showTopPanel, showBottomPanel nested inside, inside outerEastPanel
        TwitterJPanel showPanel = new TwitterJPanel(new BorderLayout());

        TwitterJButton addUserButton = new TwitterJButton("Add User");
        TwitterJButton addGroupButton = new TwitterJButton("Add Group");
        TwitterJButton openUserViewButton = new TwitterJButton("Open User View");
        TwitterJButton showUserTotalButton = new TwitterJButton("Show User Total");
        TwitterJButton showGroupTotalButton = new TwitterJButton("Show Group Total");
        TwitterJButton showMessagesTotalButton = new TwitterJButton("Show Messages Total");
        TwitterJButton showPositivePercentageButton = new TwitterJButton("Show Positive Percentage");

        Window window = new Window();
        window.setViews(Arrays.asList(new View[]{tJFrame, addUserButton, addGroupButton, openUserViewButton,
                 showUserTotalButton, showGroupTotalButton, showMessagesTotalButton,
                showPositivePercentageButton, treeViewPanel, addUserPanel, addGroupPanel, addPanel,
                outerEastPanel, showTopPanel, showBottomPanel, showPanel}));
        window.display();

        for(View v : AdminControlPanel.allRootViews) {
            v.display();
        }

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        JTree userJTree = new JTree(root);
        userJTree.setScrollsOnExpand(true);
        userJTree.setPreferredSize(new Dimension(400, 500));
        final DefaultMutableTreeNode[] selectedNode = new DefaultMutableTreeNode[1];
        userJTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                 selectedNode[0] = (DefaultMutableTreeNode)userJTree.getLastSelectedPathComponent();
            }
        });
        DefaultMutableTreeNode firstLeaf = ((DefaultMutableTreeNode)userJTree.getModel().getRoot()).getFirstLeaf();
        userJTree.setSelectionPath(new TreePath(firstLeaf.getPath()));
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
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!addUserText[0].equals("")) {
                    DefaultTreeModel model = (DefaultTreeModel) userJTree.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
                    model.insertNodeInto(new DefaultMutableTreeNode(new User(addUserText[0])), selectedNode[0], selectedNode[0].getChildCount());
                    userTotal++;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a user name.");
                }
            }
        });

        JTextField addGroupTextField = new JTextField(10);
        final String[] addGroupText = {""};
        addGroupTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                addGroupText[0] = addGroupTextField.getText();
                System.out.println(addGroupText[0]);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                addGroupText[0] = addGroupTextField.getText();
                System.out.println(addGroupText[0]);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                addGroupText[0] = addGroupTextField.getText();
                System.out.println(addGroupText[0]);
            }
        });
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(!addGroupText[0].equals("")) {
                    DefaultTreeModel model = (DefaultTreeModel) userJTree.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
                    //model.insertNodeInto(new DefaultMutableTreeNode(addGroupText[0]), root, root.getChildCount());
                    model.insertNodeInto(new DefaultMutableTreeNode(addGroupText[0]), selectedNode[0], selectedNode[0].getChildCount());
                    groupTotal++;

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a group name.");
                }
            }
        });
        openUserViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserViewPanel((User)selectedNode[0].getUserObject());
            }
        });

        openUserViewPanel.add(openUserViewButton, BorderLayout.CENTER);

        showUserTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "User Total: " + userTotal);
            }
        });

        showGroupTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Group Total: " + groupTotal);
            }
        });

        showTopPanel.add(showUserTotalButton, BorderLayout.WEST);
        showTopPanel.add(showGroupTotalButton, BorderLayout.EAST);

        showMessagesTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Messages Total: ");
            }
        });

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

//        frame.setContentPane(outerMostPanel);
//        frame.pack();
//        frame.setVisible(true);

        tJFrame.setContentPane(outerMostPanel);
        tJFrame.pack();
        tJFrame.setVisible(true);
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
