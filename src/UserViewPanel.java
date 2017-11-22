import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.UUID;

/**
 * UI when opening user view
 */
public class UserViewPanel extends JPanel {

    FollowingDefaultListModelObserver followingModel;
    FeedDefaultListModelObserver feedModel;
    JLabelObserver jLabelObserver = new JLabelObserver();

    public UserViewPanel(User user) {
        JFrame frame = new JFrame(user.getName() + " View");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        System.out.println(user.toString());

        //all elements nested inside
        JPanel outerMostPanel = new JPanel(new BorderLayout());

        //outerMostPanel and timePanel
        JPanel outerestMostPanel = new JPanel(new BorderLayout());

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

        //creation time panel, inside outerestMostPanel
        JPanel creationTimePanel = new JPanel(new BorderLayout());
        creationTimePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        outerMostPanel.add(topPanel, BorderLayout.NORTH);
        outerMostPanel.add(bottomPanel, BorderLayout.SOUTH);

        topPanel.add(followUserPanel, BorderLayout.NORTH);
        topPanel.add(followingPanel, BorderLayout.SOUTH);

        bottomPanel.add(tweetPanel, BorderLayout.NORTH);
        bottomPanel.add(feedPanel, BorderLayout.SOUTH);

        outerestMostPanel.add(creationTimePanel, BorderLayout.NORTH);
        outerestMostPanel.add(outerMostPanel, BorderLayout.SOUTH);

        //JLabel lastUpdatedTime = new JLabel("Last Updated Time: " + new Date(user.getLateUpdateTime()));
        jLabelObserver.setText("Last Updated Time: " + new Date(user.getLateUpdateTime()).toString());


        creationTimePanel.add(new JLabel("User Creation Time: " + new Date(user.getCreationTime())), BorderLayout.NORTH);
        creationTimePanel.add(jLabelObserver, BorderLayout.SOUTH);

        followingModel = new FollowingDefaultListModelObserver();
        user.addObserver(followingModel);

        JTextField userIdTextField = new JTextField(10);
        final String[] userIdText = {""};
        userIdTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                userIdText[0] = userIdTextField.getText();
                System.out.println(userIdText[0]);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                userIdText[0] = userIdTextField.getText();
                System.out.println(userIdText[0]);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                userIdText[0] = userIdTextField.getText();
                System.out.println(userIdText[0]);
            }
        });

        if (user.getFeed() != null) {
            for (User u : user.getFollowing()) {
                if (!followingModel.contains(u))
                    followingModel.addElement(u);
            }
        }
        JButton followUserButton = new JButton("Follow User");
        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!userIdText[0].equals("")) {
                    if (UserRepository.getUser(userIdText[0]) != null) {
                        if (!userIdText[0].equals(user.getName())) {
                            User following = UserRepository.getInstance().getUser(userIdText[0]);
                            user.addObserver(following.getFeedModel());
                            user.addFollowing(following);
                            following.addFollower(user);
                            user.changedData(following);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot follow yourself.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "User doesn't exist.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a user to follow.");
                }
            }
        });

        followUserPanel.add(userIdTextField, BorderLayout.WEST);
        followUserPanel.add(followUserButton, BorderLayout.EAST);

        JList followingJList = new JList<String>(followingModel);
        followingJList.setVisibleRowCount(5);
        followingJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        followingJList.setLayoutOrientation(JList.VERTICAL);
        followingJList.setSelectedIndex(0);
        JScrollPane followingListScroller = new JScrollPane(followingJList);
        followingPanel.add(followingListScroller);

        feedModel = new FeedDefaultListModelObserver();
        user.addObserver(feedModel);

        user.addObserver(jLabelObserver);

        JTextField tweetTextField = new JTextField(10);
        final String[] tweetText = {""};
        tweetTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                tweetText[0] = tweetTextField.getText();
                System.out.println(tweetText[0]);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                tweetText[0] = tweetTextField.getText();
                System.out.println(tweetText[0]);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                tweetText[0] = tweetTextField.getText();
                System.out.println(tweetText[0]);
            }
        });

        if (user.getFeed() != null) {
            for (Tweet t : user.getFeed()) {
                if (!feedModel.contains(t)) {
                    feedModel.addElement(t);
                }
            }
        }
        JButton tweetButton = new JButton("Post Tweet");
        tweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!tweetText[0].equals("")) {
                    Tweet tweet = new Tweet(user, tweetText[0], UUID.randomUUID());

                    MessageCounter.getInstance().incrementTotalMessages();
                    for (String good : PositiveMessage.KEYWORDS) {
                        if (tweet.getMessage().toLowerCase().contains(good)) {
                            MessageCounter.getInstance().incrementTotalPositiveMessages();
                            break;
                        }
                    }

                    for (User u : user.getFollowers()) {
                        System.out.println(u);
                        u.setLateUpdateTime(System.currentTimeMillis());
                        u.changedData(System.currentTimeMillis());
                        u.changedData(tweet);
                    }
                    user.changedData(tweet);
                    user.changedData(System.currentTimeMillis());
                    //lastUpdatedTime.setText("Last Updated Time: " + new Date(user.getLateUpdateTime()).toString());
                    //jLabelObserver.setText("Last Updated Time: " + new Date(user.getLateUpdateTime()).toString());

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a something to tweet.");
                }
            }
        });
        tweetPanel.add(tweetTextField, BorderLayout.WEST);
        tweetPanel.add(tweetButton, BorderLayout.EAST);

        JList feedJList = new JList<String>(feedModel);
        feedJList.setVisibleRowCount(5);
        feedJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        feedJList.setLayoutOrientation(JList.VERTICAL);
        feedJList.setSelectedIndex(0);
        JScrollPane feedListScroller = new JScrollPane(feedJList);
        feedPanel.add(feedListScroller);

        frame.setContentPane(outerestMostPanel);
        frame.pack();
        frame.setVisible(true);

    }
}
