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
	
	@Override
	public String toString() {
		return "SportsSchedule [day=" + day + ", namesOfSports=" + namesOfSports + "]";
	}
	
}
