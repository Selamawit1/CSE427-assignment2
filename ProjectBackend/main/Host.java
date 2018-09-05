package main;

import errorMessage.ErrorMessage;
import loadScreen.LoadScreen;
import loginScreen.LoginScreen;
import newUserScreen.NewUserScreen;
import saveScreen.SaveScreen;
import userScreen.UserScreen;
import user.User;
import userData.NewsFeed;
import userData.UserData;
import utilities.Date;

public class Host {
	
	private User user;
	private UserData userData;
	
	public Host() {
		userData = new UserData();
	}
	public void loadGame(int game) {
		userData.loadUserData("SaveData\\game" + game + ".txt");
		LoginScreen.LaunchLoginScreen(this);
	}
	public void toSaveGame() {
		SaveScreen.launchSaveScreen(this);
	}
	public void saveGame(int game) {
		userData.saveUserData("SaveData\\game" + game + ".txt");
	}
	public void editProPic() {
		userScreen.EditProfilePicture.launchEditProfilePicture(this);
	}
	public void newGame() {
		userData.createNewUserData();
		LoginScreen.LaunchLoginScreen(this);
	}
	public void switchUser() {
		LoginScreen.LaunchLoginScreen(this);
	}
	public void login(String username, String password){
		user = userData.getUserByUsernameAndPassword(username, password);
		if (user == null) {
			LoginScreen.LaunchLoginScreen(this);
			ErrorMessage.launchErrorMessage("Invalid username:password combination. Please enter the credentials of your account.");
		}else {
			UserScreen.launchUserScreen(this);
		}
	}
	public void toCreateNewUser() {
		NewUserScreen.launchNewUserScreen(this);
	}
	public void createNewUser(String first, String last, String username, String password, String email, String pathToProPic, Date birthday) {
		User newUser = new User(first, last, username, password, userData.getNextUniqueId(), birthday, email, pathToProPic);
		userData.addUser(newUser);
		this.user = newUser;
		UserScreen.launchUserScreen(this);
	}
	public NewsFeed getNewsFeed() {
		// Currently, this is set to get the twenty or so most recent posts.
		// You probably want to change this if you want to get different posts
		// each time.
		return userData.getNewsFeed(user, System.currentTimeMillis());
	}
	
	public void sendRequest(String first, String last) {
		User toFriend = userData.getUserByName(first, last);
		user.sendFriendRequest(toFriend);
	}
	
	public void run() {
		LoadScreen.launchLoadScreen(this);
	}
	
	public User getUser() {
		return this.user;
	}

}
