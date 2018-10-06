public class Team implements Comparable<Team> {

	private String name;
	private int seed;

	// constructors
	Team(String name) {
		this.name = name;
	}

	public Team(String name, int seed) {
		this.name = name;
		this.seed = seed;

	}

	public String getName() {
		return name;
	}
	
	public int getSeed() {
		return seed; 
	}
	
	public int compareTo(Team T) {
		return this.seed - T.seed;
	} 

}
