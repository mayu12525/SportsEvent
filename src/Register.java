import java.util.Date;

public class Register{
    private int  register_id;
    private Player player;
    //private Sport[] sports=new Sport[SportsEvent.MAX_GAME_PLAYER_ALLOWED];
    private Date date;
    

    public int getRegister_id() {
        return register_id;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

  

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}