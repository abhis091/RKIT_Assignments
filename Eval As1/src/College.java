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
			int choice=0;
			
			try {
				choice=sc.nextInt();
			}catch(Exception e) {
				System.out.println("Enter a Number");
				return;
			}
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
		
		try {
			if(EventManager.searchSport(nameOfSport)!=null) {
				System.out.println("Sport Already Listed");
				return;
			}
		}catch(Exception e) {}
		
		System.out.println("Enter Max Participants of Sport "+nameOfSport);
		int max_participants=0;
		
		try{
			max_participants = sc.nextInt();
		}catch(Exception e1) {
			System.out.println("Enter a Number");
			return;
		}
		
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
		int noOfSports=0;
		try {
			noOfSports=sc.nextInt();
		}catch(Exception e) {
			System.out.println(e);
			return;
		}
		
		Player player = new Player();
		player.setId();
		player.setName(name);
		
		ArrayList<String> sportsToRegister = new ArrayList<>();
		
		System.out.println("Enter name of those Sports");
		int i=0;
		while(i<noOfSports) {
			String nameOfSport = sc.next();
			try {
				if(EventManager.searchSport(nameOfSport)!=null) {
					sportsToRegister.add(nameOfSport);
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
		
		System.out.println("Enter Schedule for 7 days");
		ArrayList<String> days = new ArrayList<>();
		days.add("SUNDAY");
		days.add("MONDAY");
		days.add("TUESDAY");
		days.add("WEDNESDAY");
		days.add("THURSDAY");
		days.add("FRIDAY");
		days.add("SATURDAY");
		
		while(days.size()!=0) {
			System.out.println("Enter Day");
			String day= sc.next().toUpperCase();
			String choice="";
			int flag=0;
			try {
				if(EventManager.isDayAvailable(day)) {
					for(String s : days){
						if(s.equals(day)) {
							choice = day;
							flag=1;
							break;
						}
					}
					if(flag==0){
						System.out.println(day+" is already scheduled..Enter another day of week");
						continue;
					}
				}
			}catch(DayNotFoundException e) {
				System.out.println(e);
				continue;
			}
			
			
			switch(choice) {
				case "SUNDAY":days.remove("SUNDAY");break;
				case "MONDAY":days.remove("MONDAY");break;
				case "TUESDAY":days.remove("TUESDAY");break;
				case "WEDNESDAY":days.remove("WEDNESDAY");break;
				case "THURSDAY":days.remove("THURSDAY");break;
				case "FRIDAY":days.remove("FRIDAY");break;
				case "SATURDAY":days.remove("SATURDAY");break;
			}
			
			int noOfSports;
			
			System.out.println("Enter Number of Sports to be played on "+day);
			try{
				noOfSports = sc.nextInt();
				if(noOfSports>SportsEventConstants.maxSportsEachDay) {
					System.out.println("You can play upto 3 sports each day...Please Enter Again");
					days.add(day);
					continue;
				}
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
					days.add(day);
					continue;
				}
			}
			
			SportsSchedule ss = new SportsSchedule();
			ss.setDay(day);
			ss.setNamesOfSports(sp);
			
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
		System.out.println("Enter Day");
		String day = sc.next();
		try{
			if(EventManager.isDayAvailable(day)) {
				EventManager.printScheduleForDay(day);
			}
		}catch(DayNotFoundException e) {
			System.out.println(e);
			return;
		}
		
	} 
	
	public static void update() {
		System.out.println("Enter Day of which You want to Update Schedule");
		String day = sc.next();
		
		try {
			if(EventManager.isDayAvailable(day)) {
				System.out.println("1 Add Sport\n2 Remove Sport\n3 Remove Player from Sport\n4 Exit");
				int choice=0;
				try {
					choice = sc.nextInt();
				}catch(Exception e) {
					System.out.println("Enter a Number");
					return;
				}
				System.out.println("Enter Sport's Name");
				String nameOfSport = sc.next();
				
				try {
					if(EventManager.searchSport(nameOfSport)!=null) {
						
						switch(choice) {
						
						case 1: EventManager.addSportInSchedule(day,nameOfSport); break;
						case 2: EventManager.removeSportFromSchedule(day,nameOfSport);break;
						case 3: 
							System.out.println("Enter Player Name");
							String playerName="";
							Player p;
							try {
								p = EventManager.searchPlayer(playerName);
							}catch(PlayerNotFoundException e) {
								System.out.println(e);
								return;
							}
							if(p!=null) {
								EventManager.removePlayerFromSport(nameOfSport, p);
							}
							break;
							
						case 4: return;
						default: System.out.println("Invalid Choice"); return;
					}
					}
				}catch(SportNotFoundException e) {
					System.out.println(e);
					return;
				}
				
				
			}
		}catch(DayNotFoundException e) {
			System.out.println(e);
			return;
		}
	}
}
