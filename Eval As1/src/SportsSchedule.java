import java.util.ArrayList;

public class SportsSchedule {
	private String day;
	private ArrayList<String> namesOfSports = new ArrayList<>(); 
	
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public ArrayList<String> getNamesOfSports() {
		return namesOfSports;
	}
	public void setNamesOfSports(ArrayList<String> namesOfSports) {
		this.namesOfSports = namesOfSports;
	}
	
	public void addSport(String nameOfSport) {
		this.namesOfSports.add(nameOfSport);
	}
	
	public void removeSport(String nameOfSport) {
		this.namesOfSports.remove(nameOfSport);
	}
	
	@Override
	public String toString() {
		return "SportsSchedule [day=" + day + ", namesOfSports=" + namesOfSports + "]";
	}
	
}
