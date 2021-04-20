import java.util.*;

public class Sport{
    private String name_of_sport;
    private int max_participants;
    private int id;
    //private Date date;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_of_sports() {
        return name_of_sport;
    }

    public void setName_of_sports(String name_of_sport) {
        this.name_of_sport = name_of_sport;
    }

    public int getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(int max_participants) {
        this.max_participants = max_participants;
    }
    
    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/
    public String toString() {
    	return "Sport [id=" + id + ", name=" + name_of_sport + ", max_participants=" + max_participants + "]";
	}
}