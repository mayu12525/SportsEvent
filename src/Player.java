import java.util.Arrays;
import java.util.Date;

public class Player{
    private int id;
    private String name;
    private int noOfGames;
    private String[] games;
    
    public int getNoOfGames() {
		return noOfGames;
	}

	public void setNoOfGames(int noOfGames) {
		this.noOfGames = noOfGames;
	}

	
    
    public String[] getGames() {
		return games;
	}

	public void setGames(String[] games) {
		this.games = games;
	}



	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
		return "Player [id=" + id + ", Name=" + name+ ", No of Games he want to play =" + noOfGames + ", Game=" + Arrays.toString(games)
				+ "]";
	}
}