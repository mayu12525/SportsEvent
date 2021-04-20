import java.util.Arrays;
import java.util.Date;

public class Schedule {
	private String day;
	private int number_of_sports;
	private String[]sports;
	public String[] getSports() {
		return sports;
	}
	public void setSports(String[] sports) {
		this.sports = sports;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getNumber_of_sports() {
		return number_of_sports;
	}
	public void setNumber_of_sports(int number_of_sports) {
		this.number_of_sports = number_of_sports;
	}
	
	 public String toString() {
			return "Schedule [day=" + day + ", Number of sports =" +number_of_sports+ ",  Sports=" + Arrays.toString(sports)
					+ "]";
		}
}
