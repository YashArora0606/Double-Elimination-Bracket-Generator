/**
 * [DoubleGenerator.java]
 * Generator for a double elimination bracket, can organize by seeds or without 
 * Authors: Jason Wang and Yash Arora 
 * September 19, 2018
 */

import java.util.ArrayList;
import java.util.Collections;

public class DoubleGenerator extends Generator {

	DoubleBracket bracket;

	DoubleGenerator(ArrayList<Team> teams, boolean seed) {

		if (seed) {
			DoubleBracket.seed = true;
			
			// add BYES as teams and assign a value of Seed
			int numByes = DoubleBracket.nextPowerOftwo(teams.size()) - teams.size();
			DoubleBracket.numByesSeed = numByes;
			
			for (int i = 0; i < numByes; i++) {
				teams.add(new Team("BYE", Integer.MAX_VALUE - i));
			}

			//sort teams in order of seed
			Collections.sort(teams);

			//rearrange teams in seeded order
			teams = teamsSeeded(teams);

			//rearrange teams and flip the second bracket
			teams = teamsReverse(teams);
		}

		bracket = new DoubleBracket(teams);
	}

	/**
	 * teamsReverse
	 * This method reverses the second part of the teams array list so that seed 2 is located at the bottom of the bracket
	 * @param teams, array list of teams in seeded order with second seed at the top of the second bracket, 
	 * @return newTeam, an array list of teams in a seeded order with seed 2 at the bottom of the bracket 	
	 */
	private ArrayList<Team> teamsReverse(ArrayList<Team> teams) {

		
		ArrayList<Team> teamSecond = new ArrayList<Team>();
		ArrayList<Team> newTeam = new ArrayList<Team>();

		//add the second half of the bracket to team second
		for (int i = teams.size() / 2; i < teams.size(); i++) {
			teamSecond.add(teams.get(i));

		}

		//add the first part of the bracket to new team
		for (int i = 0; i < teams.size() / 2; i++) {
			newTeam.add(teams.get(i));
		}

		//flip the order of the second bracket
		Collections.reverse(teamSecond);

		//recombine the 2 parts brackets 
		for (int i = 0; i < teamSecond.size(); i++) {
			newTeam.add(teamSecond.get(i));
		}

		return newTeam;
	}

	/**
	 * getBracket
	 * This method returns the generated bracket
	 * @return bracket, returns the generated bracket
	 */
	@Override
	Bracket getBracket() {
		return bracket;

	}

	/**
	 * teamsSeeded
	 * This method returns the teams after arranging them in a seeded order
	 * @param teams, a array list of teams in an unseeded order 
	 * @return teams, an array list of teams in a seeded order
	 */
	private ArrayList<Team> teamsSeeded(ArrayList<Team> teams) {

		if (teams.size() > 1) {
			
			// Split the teams in half 
			ArrayList<Team> teamFirst = new ArrayList<Team>();
			ArrayList<Team> teamSecond = new ArrayList<Team>();

			
			//always add first team into team First
			teamFirst.add(teams.remove(0));

			int i = 0;
			while (!teams.isEmpty()) {

				if ((i / 2) % 2 == 0) {
					
					// add the second team in teams to teamSecond
					teamSecond.add(teams.remove(0));
				} else {
					teamFirst.add(teams.remove(0));

				}
				i++;
			}

			// Recursive to go through the arrayList
			teamFirst = teamsSeeded(teamFirst);
			teamSecond = teamsSeeded(teamSecond);

			// combine the 2 split arrayLists back into one team now seeded
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
