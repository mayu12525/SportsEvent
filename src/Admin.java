import java.util.*;

public class Admin {
	
	private static Scanner sc_string=new Scanner(System.in);
	private static Scanner sc_int=new Scanner(System.in);
	private static Sport[] sports=new Sport[SportsEvent.MAX_SPORTS];
	private static Player[]player=new Player[SportsEvent.MAX_PARTICIPANTS_IN_EVENT];
	private static Schedule[]schedule=new Schedule[SportsEvent.MAX_SCHEDULE];
	private static int player_id=1;
	private static int id=1;
	private static int index=0;
	private static int k=0;
	private static int schedule_i=0;
    public static void main(String[] args) {
	// write your code here
        showMenu();
    }

    private static void showMenu(){
    		while(true)
    		{
    			System.out.println("1.Add Sports");
    			System.out.println("2.Register Player");
    			System.out.println("3.Create Schedule");
    			System.out.println("4.Display Schedule for player");
    			System.out.println("5.Display Schedule for sport");
    			System.out.println("6.Display Schedule for day");
    			System.out.println("7.Update Schedule");
    			System.out.println("8.Exit");
    			int choice=sc_int.nextInt();
    			switch(choice)
    			{
    				case 1:addSportsException();
    				break;
    				case 2:LimitCrossedException();
    				break;
    				case 3:SportNotAvailableException();
    				break;
    				case 4:displayScheduleForPlayer();
    				break;
    				case 5:displayScheduleForSport();
    				break;
    				case 6:displayScheduleForDay();
    				break;
    				case 7:InvalidDayException();
    				break;
    				case 8:System.exit(1);
    				break;
    				
    					
    			}
    		}
    }

    private static void addSportsException()
    {
    	try {
			addSports();
			}
			catch(EnoughSportsException e){
				System.out.println("Oops ! There are already seven sports registered");
			}
    }
    
    private static void LimitCrossedException()
    {
    	try {
    		registerPlayer();
    	}catch(LimitCrossedException e)
    	{
    		System.out.println("You have reached your sports limit. You can not register into other sports!");
    	}
    }
    private static void addSports() throws EnoughSportsException{
        // To add sports
    	
    	
    	if(id>7) {
    		throw new EnoughSportsException();
    		//System.out.println("Oops ! There are already seven sports registered");
    	}
    	else 
    	{
    		System.out.println("Enter Name of Sport : ");
        	String sport_name=sc_string.nextLine();
        	if(index!=0) {
	        	for(int i=0;i<index;i++) {
	        		String exist_sport=sports[i].getName_of_sports();
	        		if(exist_sport.equals(sport_name))
	        		{
	        			System.out.println("This sport already exist!");
	        			return;
	        		}
	        	}
        	}
	    	Sport s=new Sport();
	    	int sport_id=id++;
	    	s.setName_of_sports(sport_name);
	    	System.out.println("Enter the number of max Participants for this game :");
	    	int max_participants=sc_int.nextInt();
	    	s.setMax_participants(max_participants);
	    	s.setId(sport_id);
	    	sports[index++]=s;
    	}
    	return;
    	
    }

    private static void registerPlayer() throws LimitCrossedException{
        // To register player
    	Player p=new Player();
    	System.out.println("Enter your name :");
    	String player_name=sc_string.nextLine();
    	System.out.println("Number of sports you want to register :");
    	int no_of_sports=sc_int.nextInt();
    	for(int i=0;i<k;i++)
    	{
    		if(player[i].getName().equals(player_name))
    		{
    			String[]games=player[i].getGames();
    			if(games.length==3){
    					throw new LimitCrossedException();
    					//return;
    			}
    			else
    			{
    				int a=0;
    				for(int j=games.length;j<SportsEvent.MAX_GAME_PLAYER_ALLOWED;j++) {
    					System.out.println("Enter sport you want to play");
    					String sp=sc_string.nextLine();
    					//addSports();
    					addSportsException();
        	    		games[j]=sp;
    				}
    	    		
    			}
    		}
    	}
    		
    			/*System.out.println("Number of sports you want to register :");
    	    	int no_of_sports=sc_int.nextInt();*/
    	    	p.setId(player_id++);
    	    	p.setName(player_name);
    	    	p.setNoOfGames(no_of_sports);
    	    	String []games=new String[SportsEvent.MAX_GAME_PLAYER_ALLOWED];
    	    	for(int i1=0;i1<no_of_sports;i1++)
    	    	{
    	    		System.out.println("Enter sport you want to play");
    	    		String sp=sc_string.nextLine();
    	    		//addSports();
    	    		addSportsException();
    	    		games[i1]=sp;
    	    	}
    	    	p.setGames(games);
    	    	player[k++]=p;
    		
    	
    	for(int i=0;i<k;i++)
    	{
    		System.out.println(player[i]);
    	}
    	return;
    	
    }
    
    private static void SportNotAvailableException() {
    	try {
    		createSchedule();
    	}
    	catch(SportNotAvailableException e) {
    		System.out.println("Oops ! You can not shcedule sports more than 3! ");
    	}
    }
    
    private static void createSchedule() throws SportNotAvailableException{
        // To create schedule
    	Schedule s=new Schedule();
    	System.out.println("Enter a day :");
    	String day=sc_string.nextLine();
    	System.out.println("Number of sports to be played on that day:");
        int sports_per_day=sc_int.nextInt();
        if(sports_per_day>3)
        {
        	//System.out.println("Oops ! You can not shcedule sports more than 3! ");
        	throw new SportNotAvailableException();
        	//return;
        }
    	
    	// check for if my day was registered already or not
    	int status=checkForDay(day);
    	if(status!=-1)
    	{
    		String[]days=schedule[status].getSports();
    		if(days.length==3)
    		{
    			/*System.out.println("Oops ! You can not shcedule sports more than 3! ");
	        	return;*/
    			throw new SportNotAvailableException();
    		}
    		for(int i=days.length;i<SportsEvent.MAX_NUMBER_OF_SPORTS_PER_DAY;i++)
    		{
    			System.out.println("Enter sport:");
        		String sp=sc_string.nextLine();
        		if(checkForSport(sp))
        		{ 
        			System.out.println("Oops ! This sport is not available ");
        		}
        		else
        		{
        			continue;
        		}
    		}
    		
    	}
    	else 
    	{
	    	s.setDay(day);
	        s.setNumber_of_sports(sports_per_day);
	        String []sports_on_day=new String[SportsEvent.MAX_NUMBER_OF_SPORTS_PER_DAY];
	        for(int i=0;i<sports_per_day;i++)
	        {
	        		System.out.println("Enter sport:");
	        		String sp=sc_string.nextLine();
	        		if(checkForSport(sp))
	        		{ 
	        			sports_on_day[i]=sp;
	        		}
	        		else
	        		{
	        			System.out.println("Oops ! This sport is not available ");
	        		}
	        }
	        s.setSports(sports_on_day);
	        schedule[schedule_i++]=s;
    	}
    	
    	for(int i=0;i<schedule_i;i++)
    	{
    		System.out.println(schedule[i]);
    	}
    	
    }

	private static int checkForDay(String day) {
		// TODO Auto-generated method stub
		for(int i=0;i<schedule_i;i++)
		{
			if(schedule[i].getDay().equals(day))
			{
				return i;
			}
		}
		return -1;
	}

	private static boolean checkForSport(String sport) {
		// TODO Auto-generated method stub
		for(int i=0;i<index;i++)
		{
			if(sports[i].getName_of_sports().equals(sport))
			{
				return true;
			}
		}
		return false;
	}

	private static void displayScheduleForPlayer(){
        // Display schedule for given player

		 System.out.println("Enter player name :");
		 String player_name=sc_string.nextLine();
		 int status=checkForPlayer(player_name);
		 if(status!=-1)
		 {
			 String[]player_sports=player[status].getGames();
			 for(int i=0;i<player_sports[i].length();i++)
			 {
				 String name=player_sports[i];
				 for(int j=0;j<schedule_i;j++)
				 {
					 String[]games=schedule[j].getSports();                 /////NULL pointer exception is coming  fix this problem
					 for(int p=0;p<games.length;p++)
					 {
						 if(games[p].equals(name))
						 {
							 System.out.println("Day : "+schedule[j].getDay());
							 System.out.println("Game :"+games[p]);
						 }
					 }
				 }
			 }
		 }
		 else
		 {
			 System.out.println("Oops ! There is no such player!");
		 }
    }

    private static int checkForPlayer(String player_name) {
		// TODO Auto-generated method stub
    	for(int i=0;i<k;i++)
    	{
    		if(player[i].getName().equals(player_name))
    		{
    			return i;
    		}
    	}
		return -1;
	}

	private static void displayScheduleForSport(){
		System.out.println("Enter sport :");
    	String sport=sc_string.nextLine();
    	if(!checkForSport(sport))
    	{
    		System.out.println("Oops ! There is no such Sport registered!");
    		return;
    	}
    	for(int i=0;i<schedule_i;i++)
    	{
    		boolean flag=false;
    		String[]sports=schedule[i].getSports();
    		for(int j=0;j<sports.length;j++)
    		{
    			if(sports[j].equals(sport))
    			{
    				flag=true;
    				System.out.println(schedule[i].getDay());             
    			}
    			if(flag)
    				break;
    		}
    	}
    }

    private static void displayScheduleForDay(){
    	System.out.println("Enter day :");
    	String day=sc_string.nextLine();
    	for(int i=0;i<schedule_i;i++)
    	{
    		if(schedule[i].getDay().equals(day))
    		{
    			String[]sports=schedule[i].getSports();
    			for(int j=0;j<sports.length;j++)
    			{
    				System.out.println(sports[j]);
    			}
    			
    			return;
    		}
    	}
    	System.out.println("There is no day to update their schedule!");

    }
   	
    private static void InvalidDayException() {
    	try {
    		updateSchedule();
    	}
    	catch(InvalidDayException e) {
    		System.out.println("Enter Valid Day");
    	}
    	catch(DayNotAvailableException e)
    	{
    		System.out.println("There is no day to update their schedule!");
    	}
    }
    private static void updateSchedule() throws InvalidDayException,DayNotAvailableException{
    	System.out.println("Enter day :");
    	String day=sc_string.nextLine();
    	String[]days= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    	boolean ans=false;
    	for(int i=0;i<days.length;i++)
    	{
    		if(days[i].equalsIgnoreCase(day)) {
    			ans=true;
    			break;
    		}
    	}
    	if(ans==false){
    		throw new InvalidDayException();
    	}
    	Schedule s=new Schedule();
    	for(int i=0;i<schedule_i;i++)
    	{
    		if(schedule[i].getDay().equals(day))
    		{
    			System.out.println("Enter the 3 sports you want to schedule : ");
    			String[]games=schedule[i].getSports();
    			for(int j=0;j<SportsEvent.MAX_NUMBER_OF_SPORTS_PER_DAY;j++)
    			{
    				System.out.println("Enter sports name : ");
    				String sport_name=sc_string.nextLine();
    				games[j]=sport_name;
    			}
    			s.setDay(day);
    			s.setSports(games);
    			return;
    		}
    	}
    	//System.out.println("There is no day to update their schedule!");
    	throw new DayNotAvailableException();
    	

    }

}
