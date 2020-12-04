
public class Player {
	
	private static int id=0;
	private String name;
	private String[] sportsToRegister = new String[SportsEventConstants.maxSportsPerPlayer];
	
	public int getId() {
		return id;
	}
	public void setId() {
		id++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSportsToRegister() {
		return sportsToRegister;
	}
	public void setSportsToRegister(String[] sportsToRegister) {
		this.sportsToRegister = sportsToRegister;
	}
}
