import javax.swing.*;
import java.awt.*;

public class UserViewPanel extends JPanel {

    public UserViewPanel() {
        JFrame frame = new JFrame("User View");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //all elements nested inside
        JPanel outerMostPanel = new JPanel(new BorderLayout());

        //contains followingUserPanel, followingPanel, nested in outerMostPanel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //contains tweetPanel, feedPanel, nested in outerMostPanel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //userIdTextField, followUserButton, nested in topPanel
        JPanel followUserPanel = new JPanel(new BorderLayout());
        followUserPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //followingJList, nested in topPanel
        JPanel followingPanel = new JPanel(new BorderLayout());
        followingPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //tweetTextField, tweetButton, nested in bottomPanel
        JPanel tweetPanel = new JPanel(new BorderLayout());
        tweetPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //feedJList, nested in bottomPanel
        JPanel feedPanel = new JPanel(new BorderLayout());
        feedPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        outerMostPanel.add(topPanel, BorderLayout.NORTH);
        outerMostPanel.add(bottomPanel, BorderLayout.SOUTH);

        topPanel.add(followUserPanel, BorderLayout.NORTH);
        topPanel.add(followingPanel, BorderLayout.SOUTH);

        bottomPanel.add(tweetPanel, BorderLayout.NORTH);
        bottomPanel.add(feedPanel, BorderLayout.SOUTH);

        JTextField userIdTextField = new JTextField(10);
        JButton followUserButton = new JButton("Follow User");
        followUserPanel.add(userIdTextField, BorderLayout.WEST);
        followUserPanel.add(followUserButton, BorderLayout.EAST);

        DefaultListModel followingModel = new DefaultListModel();
        followingModel.addElement("Jane Doe");
        followingModel.addElement("John Smith");
        followingModel.addElement("Kathy Green");
        followingModel.addElement("Jane Doe");
        followingModel.addElement("John Smith");
        followingModel.addElement("Kathy Green");

        JList followingJList = new JList<String>(followingModel);
        followingJList.setVisibleRowCount(5);
        followingJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        followingJList.setLayoutOrientation(JList.VERTICAL);
        followingJList.setSelectedIndex(0);
        JScrollPane followingListScroller = new JScrollPane(followingJList);
        followingPanel.add(followingListScroller);

        JTextField tweetTextField = new JTextField(10);
        JButton tweetButton = new JButton("Post Tweet");
        tweetPanel.add(tweetTextField, BorderLayout.WEST);
        tweetPanel.add(tweetButton, BorderLayout.EAST);

        DefaultListModel feedModel = new DefaultListModel();
        feedModel.addElement("Went outside");
        feedModel.addElement("Walked up some stairs");
        feedModel.addElement("ate");
        feedModel.addElement("bought a dog");
        feedModel.addElement("Ran a really long marathon and now I'm tired");
        feedModel.addElement("text text text this is to see what happens with long messages");

        JList feedJList = new JList<String>(feedModel);
        feedJList.setVisibleRowCount(5);
        feedJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        feedJList.setLayoutOrientation(JList.VERTICAL);
        feedJList.setSelectedIndex(0);
        JScrollPane feedListScroller = new JScrollPane(feedJList);
        feedPanel.add(feedListScroller);

        frame.setContentPane(outerMostPanel);
        frame.pack();
        frame.setVisible(true);


    }
}
