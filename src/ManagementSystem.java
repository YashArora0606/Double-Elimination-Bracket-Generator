import java.util.ArrayList;

public class ManagementSystem {
		
	private DoubleGenerator doubleGenerator;
	private DoubleBracket doubleBracket;
	private ArrayList<Team> teams = new ArrayList<Team>();
	
	ManagementSystem() {
		doubleGenerator = new DoubleGenerator(teams);
		doubleBracket = (DoubleBracket) doubleGenerator.getBracket();
	}
}
