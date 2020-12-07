import java.util.ArrayList;

public class EventManager {
	static ArrayList<Sport> sports = new ArrayList<>();
	static ArrayList<SportsSchedule> schedule = new ArrayList<>();
	static ArrayList<Player> players = new ArrayList<>();
	
	
	public static ArrayList<Sport> getSports() {
		return sports;
	}
	public static void setSports(Sport sport) {
		sports.add(sport);
	}
	public static ArrayList<SportsSchedule> getSchedule() {
		return schedule;
	}
	public static void setSchedule(SportsSchedule ss) {
		schedule.add(ss);
	}
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	public static void setPlayers(Player player) {
		players.add(player);
	}
	
	
	public static Sport searchSport(String nameOfSport) throws SportNotFoundException {
		for(Sport sport : sports) {
			if(sport!=null && sport.getNameOfSport().equalsIgnoreCase(nameOfSport)) {
				return sport;
			}
		}
		throw new SportNotFoundException("Sport Not Available....Enter Valid Sport Name");
	}
	
	public static Player searchPlayer(String playerName) throws PlayerNotFoundException {
		for(Player p : players) {
			if(p!=null && p.getName().equalsIgnoreCase(playerName)) {
				return p;
			}
		}
		throw new PlayerNotFoundException("Player Not Found...Enter Valid Name");
		
	}
	
	public static boolean isDayAvailable(String day) throws DayNotFoundException {
		for(String s : SportsEventConstants.days) {
			if(s.equalsIgnoreCase(day)) {
				return true;
			}
		}
		throw new DayNotFoundException("!!!Invalid Day!!!");
	}
	
	public static void printScheduleForPlayer(Player p) {
		for(int i=0;i<p.getSportsToRegister().size();i++) {
			System.out.println("________"+p.getSportsToRegister().get(i).toString()+"________");
			for(SportsSchedule ss : schedule) {
				for(int j=0;j<ss.getNamesOfSports().size();j++) {
					String s = ss.getNamesOfSports().toArray()[j].toString();
					if(p.getSportsToRegister().get(i).equalsIgnoreCase(s)) {
						System.out.println("	"+ss.getDay());
					}
				}
				
			}
		}
	}
	
	public static void printScheduleOfSport(String nameOfSport) {
		for(SportsSchedule ss : schedule) {
			for(int j=0;j<ss.getNamesOfSports().size();j++) {
				String s = ss.getNamesOfSports().toArray()[j].toString();
				if(s.equalsIgnoreCase(nameOfSport)) {
					System.out.println("________"+ss.getDay()+"________");
					System.out.println("List of Players");
					for(Player p : players) {
						ArrayList<String> regSports = p.getSportsToRegister();
						for(int i=0;i<regSports.size();i++) {
							if(regSports.get(i).equalsIgnoreCase(nameOfSport)) {
								System.out.println("	"+p.getName());
							}
						}
					}
				}
			}
		}
	}
	
	public static void printScheduleForDay(String day) {
		for(SportsSchedule ss : schedule) {
			if(ss.getDay().equalsIgnoreCase(day)) {
				ArrayList<String> sports = ss.getNamesOfSports();
				for(int i=0;i<sports.size();i++) {
					System.out.println("Sport Name: "+sports.get(i).toString());
					for(Player p : players) {
						ArrayList<String> sport = p.getSportsToRegister();
						for(int j=0;j<sport.size();j++) {
							if(sports.get(i).toString().equals(sport.get(j))) {
								System.out.println("   "+p.getName());
							}
						}
					}
				}
				break;
			}
		}
		
	}
	
	public static void addSportInSchedule(String day,String nameOfSport) {
		for(SportsSchedule ss : schedule) {
			if(ss.getDay().equalsIgnoreCase(day)) {
				ss.addSport(nameOfSport);
			}
		}
	}
	
	public static void removeSportFromSchedule(String day, String nameOfSport) {
		for(SportsSchedule ss : schedule) {
			if(ss.getDay().equalsIgnoreCase(day)) {
				ss.removeSport(nameOfSport);
			}
		}
	}
	
	public static void removePlayerFromSport(String nameOfSport, Player p) {
		p.getSportsToRegister().remove(nameOfSport);
	}
	
}
