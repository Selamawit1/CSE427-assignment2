package friendshipFormation;

import user.User;

public class FriendRequest {
	private User requester;
	private User requestee;
	public FriendRequest (User requester, User requestee){
		this.requester = requester;
		this.requestee = requestee;
		this.requestee.addRequest(this);
	}
	public Friendship accept() {
		requester.addFriend(requestee);
		requestee.addFriend(requester);
		requestee.removeRequest(this);
		// Friendships are still being constructed.
		return new Friendship (this);
	}
	
	public void decline() {
		this.requestee.removeRequest(this);
	}
	public User getRequester() {
		return this.requester;
	}
	public User getRequestee() {
		return this.requestee;
	}
}
