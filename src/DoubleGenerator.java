import java.util.ArrayList;
import java.util.Collections;

public class DoubleGenerator extends Generator {

	DoubleBracket bracket;

	DoubleGenerator(ArrayList<Team> teams, boolean seed) {

		if (seed) {
			DoubleBracket.seed = true; 
			//add BYES as teams and assign a value of Seed
			int numByes = DoubleBracket.nextPowerOftwo(teams.size()) - teams.size();
			for(int i = 0; i<numByes; i++) {
				teams.add(new Team("BYE",Integer.MAX_VALUE-i));
			}
			
			Collections.sort(teams);
				
			teams = teamsSeeded(teams);
			
			
			
			teams = teamsReverse(teams);
		}

		bracket = new DoubleBracket(teams);
	}

	//reverse the second part of the bracket so that 2 is the last match played(Looks better)
	private ArrayList<Team> teamsReverse(ArrayList<Team> teams) {

		ArrayList<Team> teamSecond = new ArrayList<Team>();
		ArrayList<Team> newTeam = new ArrayList<Team>();
		
		for(int i = teams.size()/2; i<teams.size(); i++) {
			teamSecond.add(teams.get(i));

		}
		
		for(int i = 0; i<teams.size()/2; i++) {
			newTeam.add(teams.get(i));
		}
	
		Collections.reverse(teamSecond);
		
		for(int i = 0; i<teamSecond.size(); i++) {
			newTeam.add(teamSecond.get(i));
		}
		
		return newTeam;
	}

	@Override
	Bracket getBracket() {
		return bracket;

	}

	private ArrayList<Team> teamsSeeded(ArrayList<Team> teams) {

		if (teams.size() > 1) {
			// Split the teams array in half
			ArrayList<Team> teamFirst = new ArrayList<Team>();
			ArrayList<Team> teamSecond = new ArrayList<Team>();

			teamFirst.add(teams.remove(0));

			int i = 0; 
			while(!teams.isEmpty()) {
				
				if((i /2) % 2 == 0) {
					//add the second team in teams to  teamSecond
					teamSecond.add(teams.remove(0));	  
				}else {
					teamFirst.add(teams.remove(0));
					
				}
				i++; 
			}
			
			//Recursive to go through the arrayList
			teamFirst = teamsSeeded(teamFirst);
			teamSecond = teamsSeeded(teamSecond);

			//combine the 2 split arrayLists back into teams
			
			for (int k = 0; k < teamFirst.size(); k++) {
				teams.add(teamFirst.get(k));
			}

			for (int j = 0; j < teamSecond.size(); j++) {
				teams.add(teamSecond.get(j));
			}
		}
		
		return teams;
	}

}
