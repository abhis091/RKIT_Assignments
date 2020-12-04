import java.util.ArrayList;
import java.util.Scanner;
	
public class College {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		showMenu();
	}
	
	public static void showMenu(){
		while(true) {
			System.out.println("1 Add Sport");
			System.out.println("2 Register Player");
			System.out.println("3 Create Sport Schedule");
			System.out.println("4 Display Schedule for Player");
			System.out.println("5 Display Schedule for Sport");
			System.out.println("6 Display Schedule for day");
			System.out.println("7 Update");
			System.out.println("8 Exit");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: addSport(); break;
			case 2: registerPlayer(); break;
			case 3: createSchedule(); break;
			case 4: displaySchedulePlayer(); break;
			case 5: displayScheduleSport(); break;
			case 6: displayScheduleDay(); break;
			case 7: update(); break;
			case 8: System.exit(1);
			}
		}
	}

	////Method to Add a Sport
	public static void addSport() {
		System.out.println("Enter Name of Sport");
		String nameOfSport = sc.next();
		System.out.println("Enter Max Participants of Sport "+nameOfSport);
		int max_participants = sc.nextInt();
		
		Sport sport = new Sport();
		sport.setNameOfSport(nameOfSport.toLowerCase());
		sport.setMax_participants(max_participants);
		EventManager.setSports(sport);
	}
	
	
	////Method to Register a Player
	public static void registerPlayer(){
		if(EventManager.sports.size()==0) {
			System.out.println("Sports List is Empty!!!");
			return;
		}
		
		System.out.println("Enter Name of Player");
		String name = sc.next();
		System.out.println("Enter No of Sports "+name +" want to play");
		int noOfSports = sc.nextInt();
		
		Player player = new Player();
		player.setId();
		player.setName(name);
		
		String[] sportsToRegister = new String[noOfSports];
		
		System.out.println("Enter name of those Sports");
		int i=0;
		while(i<noOfSports) {
			String nameOfSport = sc.next();
			try {
				if(EventManager.searchSport(nameOfSport)!=null) {
					sportsToRegister[i] = nameOfSport;
					i++;
				}
			}catch(SportNotFoundException e) {
				System.out.println(e);
				continue;
			}
		}
		
		player.setSportsToRegister(sportsToRegister);
		EventManager.setPlayers(player);
	}
	
	////Method to Create Schedule of 7 Days
	public static void createSchedule() {
		int k=0;
		System.out.println("Enter Schedule for 7 days");
		while(k<7) {
			System.out.println("Enter Day");
			String day = sc.next();
			
			int flag=0;
			for(int i=0;i<SportsEventConstants.days.length;i++) {
				if(day.equalsIgnoreCase(SportsEventConstants.days[i])) {
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("Enter Valid Day!!!");
				continue;
			}
			
			int noOfSports;
			System.out.println("Enter Number of Sports to be played on "+day);
			try{
				noOfSports = sc.nextInt();
			}catch(Exception e) {
				System.out.println("Enter a Number");
				continue;
			}
			
			ArrayList<String> sp = new ArrayList<>();
			System.out.println("Enter Names of Sports to be played on "+day);
			int i=0;
			while(i<noOfSports){
				String nameOfSport = sc.next();
				try {
					if(EventManager.searchSport(nameOfSport)!=null) {
						sp.add(nameOfSport);
						i++;
					}
				}catch(SportNotFoundException e) {
					System.out.println(e);
					continue;
				}
			}
			
			SportsSchedule ss = new SportsSchedule();
			ss.setDay(day);
			ss.setNamesOfSports(sp);
			k++;
			
			EventManager.setSchedule(ss);
		}
	}
	
	////Method to print a schedule of a player
	public static void displaySchedulePlayer() {
		
		System.out.println("Enter Player Name");
		String playerName = sc.next();
		Player p = new Player();
		
		try {
			p = EventManager.searchPlayer(playerName);
		}catch(PlayerNotFoundException e) {
			System.out.println(e);
			return;
		}
		
		EventManager.printScheduleForPlayer(p);
	}
	
	
	
	////Method to print Schedule of a sport
	public static void displayScheduleSport() {
		System.out.println("Enter Name of Sport");
		String nameOfSport = sc.next();
		try {
			if(EventManager.searchSport(nameOfSport)!=null) {	
				EventManager.printScheduleOfSport(nameOfSport);
			}
		}catch(SportNotFoundException e) {
			System.out.println(e);
			return;
		}
	}
	
	public static void displayScheduleDay() {
		
	} 
	
	public static void update() {
		
	}
}
