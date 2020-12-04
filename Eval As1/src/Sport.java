
public class Sport {
	private String nameOfSport;
	private int max_participants;
	
	private Player[] player = new Player[SportsEventConstants.maxPlayersPerSport];
	
	
	public Player[] getPlayer() {
		return player;
	}
	public void setPlayer(Player[] player) {
		this.player = player;
	}
	public String getNameOfSport() {
		return nameOfSport;
	}
	public void setNameOfSport(String nameOfSport) {
		this.nameOfSport = nameOfSport;
	}
	public int getMax_participants() {
		return max_participants;
	}
	public void setMax_participants(int max_participants) {
		this.max_participants = max_participants;
	}
	
	
}
