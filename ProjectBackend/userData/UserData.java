package userData;

import user.User;

public class UserData {
	private int uniqueId;
	private User[] users;
	public UserData() {
		users = new User[0];
	}
	public synchronized int getNextUniqueId() {
		++uniqueId;
		return uniqueId;
	}
	public void createNewUserData() {
		uniqueId = 0;
		users = new User[1];
	}
	public void loadUserData(String filePath) {
		//TODO: Load User data from a file
	}
	public void saveUserData(String filePath) {
		//TODO: Save User data to a file
	}
	public void addUser(User newUser) {
		if(users.length == newUser.getUniqueId()) {
			User[] hold = new User[2*users.length];
			int i = 0;
			for(User user : users) {
				hold[i] = user;
				++i;
			}
			users = hold;
		}

		users[newUser.getUniqueId()] = newUser;
	}
	public void deleteUser(User userToDelete) {
		users[userToDelete.getUniqueId()] = null;
	}
	public NewsFeed getNewsFeed(User user, long sinceBefore) {
		// TODO: for a specified user, collect relevant posts.
		// Hint: sinceBefore is meant to be a time stamp. We only
		// want the twenty or so most recent posts before the time stamp.
		// This way, we can add more post later and know where to start.
		return null;
	}
	public User getUserById(int id) {
		return users[id];
	}
	public User getUserByName (String firstName, String lastName) {
		for(User user: users) {
			if (user != null) {
				if(user.isYou(firstName, lastName)) {
					return user;
				}
			}
		}
		return null;
	}
	public User getUserByUsernameAndPassword(String username, String password) {
		for(int i = 0; i < users.length; ++i) {
			User user = users[i];
			if(user != null) {
				if(user.unlock(username, password)) {
					return user;
				}
			}
		}
		return null;
	}
}
