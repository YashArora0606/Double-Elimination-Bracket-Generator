import java.util.ArrayList;

public class DoubleGenerator extends Generator{
	
	DoubleGenerator(ArrayList<Team> teams) {
		
	}

	@Override
	Bracket getBracket() {
		Bracket bracket = new DoubleBracket();
		return bracket;
	}

}
