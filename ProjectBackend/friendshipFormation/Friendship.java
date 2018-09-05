package friendshipFormation;

import java.util.LinkedList;

import user.Post;

// Ignore this class for now unless you want to make it your interesting addition.
// It is still under construction.
public class Friendship {
	private long timeStamp;
	private FriendRequest request;
	private LinkedList<Post> postsBetween;
	public Friendship (FriendRequest request){
		timeStamp = System.currentTimeMillis();
		this.request = request;
	}
	public long getAge() {
		return this.timeStamp;
	}
	public LinkedList<Post> getPostsBetween(){
		return this.postsBetween;
	}
	public void addPost(Post postBetween) {
		this.postsBetween.add(postBetween);
	}
}
