package utilities;

public class Date {
	private int month;
	private int day;
	private int year;
	
	public Date (int month, int day, int year){
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	public int getYear() {
		return this.year;
	}
	public boolean isDateOlderThan(Date other) {
		if(this.getYear() > other.getYear()) {
			return true;
		}else if(this.getYear() == other.getYear()) {
			if(this.getMonth() > other.getMonth()) {
				return true;
			}else if(this.getMonth() == other.getMonth()) {
				if(this.getDay() > other.getDay()) {
					return true;
				}
			}
		}
		return false;
	}
	public String toString() {
		return month + "/" + day + "/" + year;
	}
}
