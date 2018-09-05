package userScreen;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.Host;
import user.Post;
import user.User;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import friendshipFormation.FriendRequest;

import javax.swing.JTextField;

public class UserScreen {

	private JFrame frame;
	private Host host;
	private JTextArea previousPoststxt;
	private JTextField newsFeedtxt;

	/**
	 * Launch the application.
	 */
	public static void launchUserScreen(Host host) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserScreen window = new UserScreen(host);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserScreen(Host host) {
		this.host = host;
		initialize();
	}
	//TODO: implement this. You need to add a text field
	// to the scroll pane and have the back end deliver a
	// complete list of mutual friends.
	private void mutualFriends() {
		// TODO: you need to add a JTextArea feature to the
		// scroll panel to display text.
		JScrollPane mutualFriends = new JScrollPane();
	    mutualFriends.setBounds(1697, 210, 197, 251);
	    mutualFriends.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    frame.getContentPane().add(mutualFriends);
	    
	    JLabel lblMutualfutureFriends = new JLabel("Mutual Friends");
	    lblMutualfutureFriends.setBounds(1697, 176, 197, 23);
	    lblMutualfutureFriends.setHorizontalAlignment(SwingConstants.CENTER);
	    lblMutualfutureFriends.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    frame.getContentPane().add(lblMutualfutureFriends);
	}
	private void proPic() {
		javaxt.io.Image ii = host.getUser().getProfPic();
		ii.resize(400, 400, true);
	    frame.getContentPane().setLayout(null);
	    JLabel profilePicture = new JLabel(new ImageIcon(ii.getImage()));
	    profilePicture.setBounds(0, 0, 400, 400);
	    JPanel jsp = new JPanel();
	    jsp.setBounds(0, 0, 400, 400);
	    jsp.setLayout(null);
	    jsp.add(profilePicture);
	    frame.getContentPane().add(jsp); 
	    
	    //TODO: you need to get this button working.
	    // you need to make the entire EditProPic GUI.
	    JButton editProPic = new JButton("Edit Pro Pic");
	    editProPic.setBounds(0, 411, 127, 23);
	    editProPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Launched the edit propic gui
				host.editProPic();
			}
		});
	    frame.getContentPane().add(editProPic);
	}
	
	private void about() {
		JTextArea about = new JTextArea();
		about.setLineWrap(true);
	    about.setBounds(82, 492, 246, 251);
	    about.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    String aboutText = "Name: " + host.getUser().getfirstName() + " " + host.getUser().getLastName() + "\n" +
	    		"Username: " + host.getUser().getUserName() + "\nUnique Id: " + host.getUser().getUniqueId() +
	    		"\nBirthday: " + host.getUser().getBirthday().toString() + "\nEmail: " + host.getUser().getEmail();
	    about.setEditable(false);
	    about.setText(aboutText);
	    frame.getContentPane().add(about);
	    
	    JLabel lblNewLabel = new JLabel("About");
	    lblNewLabel.setBounds(10, 465, 390, 23);
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    frame.getContentPane().add(lblNewLabel);
	}
	
	private void previousPosts() {
		JScrollPane previousPosts = new JScrollPane();
	    previousPosts.setBounds(10, 779, 390, 251);
	    previousPosts.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    frame.getContentPane().add(previousPosts);
	    
	    previousPoststxt = new JTextArea();
	    previousPoststxt.setLineWrap(true);
	    previousPoststxt.setEditable(false);
	    String posts = "";
	    for(Post post : host.getUser().getPostList()) {
	    	posts = posts + post.getPostThoughts() + "\n\n";
	    }
	    previousPoststxt.setText(posts);
	    previousPosts.setViewportView(previousPoststxt);
	    previousPoststxt.setColumns(10);
	    
	    JLabel lblPosts = new JLabel("Posts");
	    lblPosts.setBounds(10, 754, 390, 23);
	    lblPosts.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPosts.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    frame.getContentPane().add(lblPosts);
	}
	
	private void randomButtons() {
		JButton switchUsers = new JButton("Switch Users");
	    switchUsers.setBounds(1754, 11, 140, 44);
	    switchUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				host.switchUser();
				frame.dispose();
			}
		});
	    frame.getContentPane().add(switchUsers);
	    
	    JButton save = new JButton("Save the World");
	    save.setBounds(1754, 66, 140, 44);
	    save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				host.toSaveGame();
			}
		});
	    frame.getContentPane().add(save);
	}
	
	private void addFriends() {
		JTextArea firstName = new JTextArea();
	    firstName.setBounds(1648, 892, 246, 23);
	    firstName.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    frame.getContentPane().add(firstName);
	    
	    JLabel lblAddFriends = new JLabel("Add Friends");
	    lblAddFriends.setBounds(1504, 867, 390, 23);
	    lblAddFriends.setHorizontalAlignment(SwingConstants.CENTER);
	    lblAddFriends.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    frame.getContentPane().add(lblAddFriends);
	    
	    JTextArea lastName = new JTextArea();
	    lastName.setBounds(1648, 926, 246, 23);
	    lastName.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    frame.getContentPane().add(lastName);
	    
	    JLabel lblFirstName = new JLabel("First Name");
	    lblFirstName.setBounds(1544, 889, 104, 26);
	    lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
	    lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    frame.getContentPane().add(lblFirstName);
	    
	    JLabel lblLastName = new JLabel("Last Name");
	    lblLastName.setBounds(1544, 923, 104, 26);
	    lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	    lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    frame.getContentPane().add(lblLastName);
	    
	    JButton AddFriend = new JButton("Add");
	    AddFriend.setBounds(1648, 960, 89, 23);
	    AddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// create new user
				host.sendRequest(firstName.getText(), lastName.getText());
				firstName.setText("");
				lastName.setText("");
			}
		});
	    frame.getContentPane().add(AddFriend);
	}
	
	private void newsFeed() {
		JScrollPane newsFeed = new JScrollPane();
	    newsFeed.setBounds(709, 38, 390, 636);
	    newsFeed.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    frame.getContentPane().add(newsFeed);
	    
	    newsFeedtxt = new JTextField();
	    newsFeedtxt.setEditable(false);
	    newsFeed.setViewportView(newsFeedtxt);
	    newsFeedtxt.setColumns(10);
	    // TODO: Here is the news feed that the back end will deliver.
	    // Pack this into a string so that it can be displayed.
	    // \n is a line break.
	    host.getNewsFeed();
	    
	    JLabel lblNewsfeed = new JLabel("News Feed");
	    lblNewsfeed.setBounds(709, 4, 390, 23);
	    lblNewsfeed.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewsfeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    frame.getContentPane().add(lblNewsfeed);
	    
	    JButton showMoreNewsFeed = new JButton("Show More");
	    showMoreNewsFeed.setBounds(848, 685, 118, 23);
	    frame.getContentPane().add(showMoreNewsFeed);
	    showMoreNewsFeed.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
				//TODO: this function is going to need modification.
	    		// Remember to keep track of the last time stamp divider.
	    		host.getNewsFeed();
			}
	    });
	}
	
	private void friendsList() {
		JLabel lblFriends = new JLabel("Friends");
	    lblFriends.setBounds(1490, 176, 197, 23);
	    lblFriends.setHorizontalAlignment(SwingConstants.CENTER);
	    lblFriends.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    frame.getContentPane().add(lblFriends);
	    
	    JScrollPane friends = new JScrollPane();
	    friends.setBounds(1490, 210, 197, 251);
	    friends.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    frame.getContentPane().add(friends);
	    
	    JTextArea friendstxt = new JTextArea();
	    friendstxt.setLineWrap(true);
	    friendstxt.setEditable(false);
	    String Friends = "";
	    for(User friend : host.getUser().getFriends()) {
	    	Friends = Friends + friend.getfirstName() + " " + friend.getLastName() + "\n";
	    }
	    friendstxt.setText(Friends);
	    friends.setViewportView(friendstxt);
	    friendstxt.setColumns(10);
	}
	
	private void writingPosts() {
		 JTextArea post = new JTextArea();
		 post.setLineWrap(true);
		    post.setBounds(709, 821, 390, 128);
		    post.setText("Tell a story...");
		    post.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		    frame.getContentPane().add(post);
		    
		    JLabel lblWhatAreYou = new JLabel("What are you thinking?");
		    lblWhatAreYou.setBounds(709, 794, 390, 23);
		    lblWhatAreYou.setHorizontalAlignment(SwingConstants.CENTER);
		    lblWhatAreYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    frame.getContentPane().add(lblWhatAreYou);
		    
		    JButton publishPost = new JButton("Post");
		    publishPost.setBounds(862, 960, 89, 23);
		    publishPost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// create new user
					host.getUser().post(post.getText());
					post.setText("Tell us what you think...");
				}
			});
		    frame.getContentPane().add(publishPost);
	}
	
	private void requests() {
		JScrollPane requests = new JScrollPane();
	    requests.setBounds(1504, 492, 390, 251);
	    requests.setToolTipText("");
	    requests.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
	    frame.getContentPane().add(requests);
	    
	    JTextArea requeststxt = new JTextArea();
	    requeststxt.setLineWrap(true);
	    requeststxt.setEditable(false);
	    String requestsList = "";
	    for(FriendRequest request : host.getUser().getRequests()) {
	    	User sender = request.getRequester();
	    	requestsList = requestsList + sender.getfirstName() + " " + sender.getLastName() + "\n";
	    }
	    requeststxt.setText(requestsList);
	    requests.setViewportView(requeststxt);
	    requeststxt.setColumns(10);
	    
	    JLabel lblRequests = new JLabel("Requests");
	    lblRequests.setBounds(1504, 465, 390, 23);
	    lblRequests.setHorizontalAlignment(SwingConstants.CENTER);
	    lblRequests.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    frame.getContentPane().add(lblRequests);
	    
	    JButton acceptAllRequests = new JButton("Accept all");
	    acceptAllRequests.setBounds(1613, 758, 104, 23);
	    acceptAllRequests.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
				host.getUser().acceptAllRequests();
			}
	    });
	    frame.getContentPane().add(acceptAllRequests);
	    
	    JButton rejectAllRequests = new JButton("Reject all");
	    rejectAllRequests.setBounds(1726, 758, 104, 23);
	    rejectAllRequests.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
				host.getUser().rejectAllRequests();
			}
	    });
	    frame.getContentPane().add(rejectAllRequests);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		about();
		newsFeed();
		addFriends();
		friendsList();
		mutualFriends();
		previousPosts();
		proPic();
		writingPosts();
		requests();
		randomButtons();
	}
}
