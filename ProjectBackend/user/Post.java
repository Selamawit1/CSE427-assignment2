package user;

public class Post {
	private String thoughts;
	private long timeStamp;
	private User poster;
	public Post(String thoughts, User poster) {
		this.thoughts = thoughts;
		this.timeStamp = System.currentTimeMillis();
		this.poster = poster;
	}
	public String getPostThoughts() {
		return this.thoughts;
	}
	public long getTimeStamp() {
		return this.timeStamp;
	}
	public User getPoser() {
		return this.poster;
	}
}
