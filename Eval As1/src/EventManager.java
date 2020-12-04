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
			if(sport.getNameOfSport().equalsIgnoreCase(nameOfSport)) {
				return sport;
			}
		}
		throw new SportNotFoundException("Sport Not Available");
	}
	
	public static Player searchPlayer(String playerName) throws PlayerNotFoundException {
		for(Player p : players) {
			if(p!=null && p.getName().equalsIgnoreCase(playerName)) {
				return p;
			}
		}
		throw new PlayerNotFoundException("Player Not Found...Enter Valid Name");
		
	}
	
	public static void printScheduleForPlayer(Player p) {
		for(int i=0;i<p.getSportsToRegister().length;i++) {
			for(SportsSchedule ss : schedule) {
				for(int j=0;j<ss.getNamesOfSports().size();j++) {
					String s = ss.getNamesOfSports().toArray()[j].toString();
					if(p.getSportsToRegister()[i].equalsIgnoreCase(s)) {
						System.out.println("<---------"+ss.getDay()+"--------->");
						System.out.println("   "+s);
					}
				}
			}
		}
		
	}
	
	
	
}
