import java.util.ArrayList;

public class Player {
	
	private static int id=0;
	private String name;
	private ArrayList<String> sportsToRegister = new ArrayList<>();
	
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
	public ArrayList<String> getSportsToRegister() {
		return sportsToRegister;
	}
	public void setSportsToRegister(ArrayList<String> sportsToRegister) {
		this.sportsToRegister = sportsToRegister;
	}
	
}
