package user;
import java.util.LinkedList;

import friendshipFormation.FriendRequest;
import friendshipFormation.Friendship;
import javaxt.io.Image;
import utilities.Date;
import utilities.UtilityMethods;

public class User {
	
	private int uniqueId;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String email;
	private Image profPic;
	private LinkedList<Post> postList;
	private LinkedList<User> friends;
	private LinkedList<FriendRequest> requests;
	
	
	public User(String first, String last, String username, String password, int uniqueId, Date birthday, String email, String pathToProPic) {
		this.firstName = first;
		this.lastName = last;
		this.userName = username.equals("") ? first : username;
		this.passWord = password.equals("") ? last : password;
		this.uniqueId = uniqueId;
		this.birthday = birthday == null ? UtilityMethods.getRandomDate() : birthday;
		this.email = email.equals("") ? first + "." + last + "@danbook.com" : email;
		this.profPic = pathToProPic.equals("") ? new Image ("Pictures\\Dan.jpg") : new Image (pathToProPic);
		this.postList = new LinkedList<Post>();
		this.friends = new LinkedList<User>();
		this.requests = new LinkedList<FriendRequest>();
	}
	public int getUniqueId() {
		return this.uniqueId;
	}
	public String getfirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getUserName() {
		return this.userName;
	}
	public Date getBirthday() {
		return this.birthday;
	}
	public String getEmail() {
		return this.email;
	}
	public LinkedList<User> getFriends(){
		return this.friends;
	}
	public LinkedList<FriendRequest> getRequests(){
		return this.requests;
	}
	public void changePassword(String newPassword) {
		this.passWord = newPassword;
	}
	public FriendRequest sendFriendRequest(User recipient) {
		return new FriendRequest(this, recipient);
	}
	public void removeRequest(FriendRequest toRemove) {
		requests.remove(toRemove);
	}
	public Friendship acceptFriendRequest(FriendRequest requestToAccept) {
		return requestToAccept.accept();
	}
	public void updateProfilePicture(String path) {
		this.profPic = new Image(path);
	}
	public void rotateProfilePicture() {
		profPic.rotate(90);
	}
	public void addFriend(User newFriend) {
		friends.add(newFriend);
	}
	public void post(String thoughts) {
		postList.add(new Post(thoughts, this));
	}
	public boolean isYou(String firstName, String lastName) {
		return firstName.equals(this.firstName) && lastName.equals(this.lastName);
	}
	public boolean unlock(String username, String password) {
		return username.equals(this.userName) && password.equals(this.passWord);
	}
	public void addRequest(FriendRequest request) {
		requests.add(request);
	}
	public Image getProfPic() {
		return this.profPic;
	}
	public LinkedList<Post> getPostList(){
		return this.postList;
	}
	public void acceptAllRequests() {
		for(FriendRequest request : requests) {
			request.accept();
		}
	}
	public void rejectAllRequests() {
		for(FriendRequest request : requests) {
			request.decline();
		}
	}
	public boolean equals(User user) {
		return this.uniqueId == user.uniqueId;
	}
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.email + " " + this.profPic.toString();
	}
}
