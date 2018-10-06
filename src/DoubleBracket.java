import java.util.ArrayList;
import java.util.Collections;

public class DoubleBracket extends Bracket {

	ArrayList<Team> teams;
	int numRounds;
	int numTeams;
	int numMatches;
	int[] numMatchesInRound;
	int oldNumMatchesLosers = 0;
	int addIndex;
	int initalRounds;
	int numMatchesWinners;
	int numMatchesLosers;
	boolean finals = false;
	static boolean seed = false; 
	String tournamentWinner = null;

	// ArrayList<Team>[] round;
	ArrayList<ArrayList<String>> round;
	ArrayList<ArrayList<String>> loserRound;

	// DONE
	DoubleBracket(ArrayList<Team> teams) {
		this.teams = teams;

		numTeams = teams.size();
		numMatchesInRound = new int[numRounds + 1];
		numMatches = (teams.size() - 1) * 2;

		// Calculate number of rounds
		double L2 = log(teams.size(), 2);
		initalRounds = (int) Math.ceil(L2);
		int surplusRounds = (int) (Math.ceil(log((int) L2, 2)));
		numRounds = initalRounds + surplusRounds + 1 + 1;

		round = new ArrayList<ArrayList<String>>(numRounds);
		loserRound = new ArrayList<ArrayList<String>>(numRounds);

		// Every round is an ArrayList of the teams that play in the round
		for (int i = 0; i < numRounds; i++) {
			ArrayList<String> indArr = new ArrayList<String>();
			round.add(indArr);
			// loserRound.add(indArr);
		}

		for (int i = 0; i < numRounds; i++) {
			ArrayList<String> indArr = new ArrayList<String>();
			loserRound.add(indArr);
		}

		// Add teams to the very first round

		// add placeHolders for the winners round
		int previousSize = nextPowerOftwo(teams.size()) / 2;
		for (int i = 1; i <= initalRounds; i++) {

			for (int j = 0; j < previousSize; j++) {
				round.get(i).add("?");
			}
			previousSize = previousSize / 2;

		}

		for (int i = 0; i < teams.size(); i++) {
			round.get(0).add(i, teams.get(i).getName());
		}

		int numByes = nextPowerOftwo(teams.size()) - teams.size();

		// Add byes into

		for (int i = 1; i <= numByes; i++) {
			round.get(0).add((i * 2) - 1, "BYE");
		}

		for (int i = 1; i <= numRounds; i++) {

			for (int j = 0; j < calcNumberOfTeamsLosers(i); j++) {// +1 incase its odd
				loserRound.get(i - 1).add("?");
			}

		}
		
      if(seed) {
		for (int i = 1; i <= (nextPowerOftwo(teams.size())/2); i++) {

			if (round.get(0).get((i) - 1).equals("BYE")) {
				
				round.get(1).set((i - 1)/2, round.get(0).get((i - 2)));
				
				loserRound.get(0).set((i - 1)/2, "BYE");
			}
		}
		
			
		for (int i = (nextPowerOftwo(teams.size())/2)+1; i <=(nextPowerOftwo(teams.size()))-1; i++) {

			if (round.get(0).get((i) - 1).equals("BYE")) {
				
				round.get(1).set((i - 1)/2, round.get(0).get((i)));
				
				loserRound.get(0).set((i - 1)/2, "BYE");
			}
		}
      }else if(!seed){
    	  for (int i = 1; i <= (nextPowerOftwo(teams.size()) / 2); i++) {
  			if (round.get(0).get((i * 2) - 1).equals("BYE")) {
  			  round.get(1).set(i-1,round.get(0).get((i * 2) - 2));
  				loserRound.get(0).set(i - 1, "BYE");
  			}
  		}
  	}
      
		
		
			

	}

	// DONE
	@Override
	int getNumberOfTeams() {
		return numTeams;
	}

	// DONE
	@Override
	int getNumberOfRounds() {
		return numRounds;
	}

	@Override
	int getNumberOfMatchesInRound(int roundNum) {
		numMatchesWinners = (int) Math.floor((round.get(roundNum - 1).size()) / 2);
		numMatchesLosers = (int) Math.floor(calcNumberOfTeamsLosers(roundNum)) / 2;

		int numByes = numMatchesSkipped(roundNum, false);

		numMatches = numMatchesWinners + numMatchesLosers - numByes;

		/*
		 * // Eliminated extra added team to finals if (roundNum-1 == initalRounds) {
		 * System.out.println("Subtracted"); numMatches = numMatches - 1; }
		 * 
		 * if (roundNum == numRounds - 2 || roundNum == numRounds - 1) {
		 * System.out.println("Subtracted"); numMatches = 1; }
		 */

		return numMatches;

	}

	@Override
	String[][] getTeamsInMatch(int roundNum, int matchNumber) {

		String[][] teamsInMatch = new String[2][];

		ArrayList<String> possibleTop = new ArrayList<String>();
		ArrayList<String> possibleBottom = new ArrayList<String>();

		int roundSize = round.get(roundNum - 1).size();

		if (roundSize % 2 == 1) {
			roundSize++;
		}

		boolean inWinnersBracket;
		if (matchNumber * 2 <= roundSize) {
			inWinnersBracket = true;
		} else {
			inWinnersBracket = false;
		}

		boolean alreadyFull1 = false;
		boolean alreadyFull2 = false;

		if (inWinnersBracket) {
			System.out.println("YES WINNERS: ");

			System.out.println(roundSize);

			if (round.get(roundNum - 1).get((matchNumber * 2) - 2) != null
					&& !round.get(roundNum - 1).get((matchNumber * 2) - 2).isEmpty()) {

				alreadyFull1 = true;
				String top = round.get(roundNum - 1).get((matchNumber * 2) - 2);
				teamsInMatch[0] = new String[] { top };
				System.out.println("TOP1: " + top);

			}

			try {

				if (round.get(roundNum - 1).get((matchNumber * 2) - 1) != null
						&& !round.get(roundNum - 1).get((matchNumber * 2) - 1).isEmpty()) {
					alreadyFull2 = true;
					String bottom = round.get(roundNum - 1).get((matchNumber * 2) - 1);
					teamsInMatch[1] = new String[] { bottom };
					System.out.println("BOT1: " + bottom);
				}

			} catch (NullPointerException e) {

			}

			if (alreadyFull1 && alreadyFull2) {
				return teamsInMatch;
			}

		}

		if (roundNum > 1 && inWinnersBracket) {

			if (!alreadyFull1) {
				possibleTop.addAll(findPossTop(roundNum - 1, matchNumber * 2));
			}

			if (!alreadyFull2) {
				possibleBottom.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1));
			}

			for (int i = 0; i < possibleTop.size(); i++) {
				possibleTop.remove("BYE");
			}

			for (int i = 0; i < possibleBottom.size(); i++) {
				possibleBottom.remove("BYE");
			}

			teamsInMatch[1] = new String[possibleTop.size()];
			teamsInMatch[0] = new String[possibleBottom.size()];

			for (int i = 0; i < teamsInMatch[1].length; i++) {
				teamsInMatch[1][i] = possibleTop.get(i);
			}
			for (int i = 0; i < teamsInMatch[0].length; i++) {
				teamsInMatch[0][i] = possibleBottom.get(i);
			}

		} else {

			// winner bracket round 1
			if (inWinnersBracket) {
				String top = round.get(0).get((matchNumber * 2) - 2);
				String bottom = round.get(0).get((matchNumber * 2) - 1);

				teamsInMatch[0] = new String[] { top };
				teamsInMatch[1] = new String[] { bottom };

				// loser bracket
			} else {

				// System.out.println(matchNumber*2-roundSize + "\n");

				// IF LOSERBRACKET ROUND 1
				// (matchNumber*2)-(roundSize+1) == 1
				if (roundNum == 1) {
					int newTeamNumber = (matchNumber * 2) - (roundSize + 1);
					int newMatchNumber = (newTeamNumber + 1) / 2;

					// System.out.println("NEW: " + newMatchNumber);

					String top = loserRound.get(0).get((newMatchNumber * 2) - 2);
					String bottom = loserRound.get(0).get((newMatchNumber * 2) - 1);

					// THIS CODE SETS TEAMS AS NULL IF THEY ARE BYES
//					   if (top.equals("BYE")) {
//						   teamsInMatch[0] = null;
//					   } else {
//						   teamsInMatch[0] = new String[] {top};
//					   }
//					   
//					   if (bottom.equals("BYE")) {
//						   teamsInMatch[1] = null;
//					   } else {
//						   teamsInMatch[1] = new String[] {bottom};
//					   }

					teamsInMatch[0] = new String[] { top };
					teamsInMatch[1] = new String[] { bottom };

					// ELSE IF LOSERBRACKET ROUND 2 and above
				} else {
					possibleTop.addAll(findPossTop(roundNum - 1, matchNumber * 2));
					possibleBottom.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1));

//					   for (int i = 0; i < possibleTop.size(); i++) {
//					    possibleTop.remove("BYE");
//					   }
//					   
//					   for (int i = 0; i < possibleBottom.size(); i++) {
//					    possibleBottom.remove("BYE");
//					   }

					teamsInMatch[1] = new String[possibleTop.size()];
					teamsInMatch[0] = new String[possibleBottom.size()];

					for (int i = 0; i < teamsInMatch[1].length; i++) {
						teamsInMatch[1][i] = possibleTop.get(i);
					}
					for (int i = 0; i < teamsInMatch[0].length; i++) {
						teamsInMatch[0][i] = possibleBottom.get(i);
					}

				}

			}

		}

		// teamsInMatch[0] = (String[]) possibleBottom.toArray();
		// teamsInMatch[1] = (String[]) possibleTop.toArray();

		// System.out.println(findPossTop(roundNum-1, matchNumber*2).toString());
		// System.out.println(findPossTop(roundNum-1, (matchNumber*2)-1).toString());

		return teamsInMatch;

	}

	ArrayList<String> findPossTop(int roundNum, int matchNumber) {

		ArrayList<String> possibleTop = new ArrayList<String>();

		int roundSize = round.get(roundNum - 1).size();

		boolean inWinnersBracket;
		if (matchNumber * 2 <= roundSize) {
			inWinnersBracket = true;
		} else {
			inWinnersBracket = false;
		}

		// IF IN THE LOSERS BRACKET
		if (!inWinnersBracket) {
			int newTeamNumber = (matchNumber * 2) - (roundSize + 1);
			int newMatchNumber = (newTeamNumber + 1) / 2;

			if (roundNum == 0) {
				return possibleTop;
			}

			// System.out.println("THIS: " + round.get(roundNum).size());
			if (newMatchNumber > loserRound.get(roundNum).size()) {
				return possibleTop;
			}

			//
			if ((newMatchNumber * 2) - 2 < loserRound.get(roundNum - 1).size()) {

				possibleTop.add(loserRound.get(roundNum - 1).get((newMatchNumber * 2) - 1));
				if ((newMatchNumber * 2) - 2 < loserRound.get(roundNum - 1).size()) {
					possibleTop.add(loserRound.get(roundNum - 1).get((newMatchNumber * 2) - 2));
				}

				return possibleTop;

			} else {

				ArrayList<String> combinedArray = new ArrayList<String>();
				combinedArray.addAll(findPossTop(roundNum - 1, matchNumber * 2));
				combinedArray.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1));

				return combinedArray;
			}

			// IF IN THE WINNERS BRACKET
		} else {
			// If it gets to round 0, no teams are playing, so an empty array is returned
			if (roundNum == 0) {
				return possibleTop;
			}

			// System.out.println("THIS: " + round.get(roundNum).size());
			if (matchNumber > round.get(roundNum).size()) {
				return possibleTop;
			}

			//
			if ((matchNumber * 2) - 2 < round.get(roundNum - 1).size()) {

				possibleTop.add(round.get(roundNum - 1).get((matchNumber * 2) - 1));
				if ((matchNumber * 2) - 2 < round.get(roundNum - 1).size()) {
					possibleTop.add(round.get(roundNum - 1).get((matchNumber * 2) - 2));
				}

				return possibleTop;

			} else {

				ArrayList<String> combinedArray = new ArrayList<String>();
				combinedArray.addAll(findPossTop(roundNum - 1, matchNumber * 2));
				combinedArray.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1));

				return combinedArray;
			}
		}

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	void setMatchWinner(String teamName, int roundNum, int matchNumber) {

		int roundSize = round.get(roundNum - 1).size();

		boolean inWinnersBracket;
		if ((matchNumber + numMatchesSkipped(roundNum, true)) * 2 <= roundSize) {
			inWinnersBracket = true;
		} else {
			inWinnersBracket = false;
		}

		// change matchNumber to match the bracket

		matchNumber = matchNumber + numMatchesSkipped(roundNum, inWinnersBracket);

		// to change the value of roundNum to the index of the round
		roundNum = roundNum - 1;

		if (!finals) {

			if (inWinnersBracket) {
				round.get(roundNum + 1).set(matchNumber - 1, teamName);

				if (roundNum == 0) {
					// add losing team to losers bracket
					int index = matchNumber - 1;

					if (round.get(roundNum).get(matchNumber * 2 - 2).equals(teamName)) {
						loserRound.get(roundNum).set(index, (round.get(roundNum).get(matchNumber * 2 - 1)));
					} else if (round.get(roundNum).get(matchNumber * 2 - 1).equals(teamName)) {
						loserRound.get(roundNum).set(index, (round.get(roundNum).get(matchNumber * 2 - 2)));
					}

				} else {
					// move losing teams down the the loserRound +1
					addIndex = (matchNumber * 2) - 1;
					// roundNum = 2
					// add to loserRound 3
					if (round.get(roundNum).get(matchNumber * 2 - 2).equals(teamName)) {
						loserRound.get((roundNum - 1) * 2 + 1).set(addIndex,
								(round.get(roundNum).get(matchNumber * 2 - 1)));
					} else if (round.get(roundNum).get(matchNumber * 2 - 1).equals(teamName)) {
						loserRound.get((roundNum - 1) * 2 + 1).set(addIndex,
								(round.get(roundNum).get(matchNumber * 2 - 2)));
					}
				}

			}
			if (!inWinnersBracket) {

				if (roundNum % 2 == 0) {
					if (matchNumber != 1) {
						addIndex = ((matchNumber * 2) - roundSize) - 2;
					} else if (matchNumber == 1) {
						addIndex = 0;
					}
					loserRound.get(roundNum + 1).set(addIndex, teamName);

				} else if (roundNum % 2 == 1) {
					addIndex = (int) (matchNumber - Math.floor((roundSize) / 2) - 1);
					loserRound.get(roundNum + 1).set(addIndex, teamName);
				}
			}

			// Automatically move BYEs down
			if (loserRound.get(roundNum).contains("BYE")) {
				for (int i = 1; i <= (calcNumberOfTeamsLosers(roundNum + 1)) / 2; i++) {
					int matchNumberNew = i + (roundSize / 2);

					if ((loserRound.get(roundNum).get(i * 2 - 2)).equals("BYE")
							&& !loserRound.get(roundNum).get(i * 2 - 1).equals("?")) {

						if (roundNum % 2 == 0) {
							int index = ((matchNumberNew * 2) - roundSize) - 2;
							loserRound.get(roundNum + 1).set(index, loserRound.get(roundNum).get(i * 2 - 1));

						} else if (roundNum % 2 == 1) {
							int index = i - 1;
							loserRound.get(roundNum + 1).set(index, loserRound.get(roundNum).get(i * 2 - 1));
						}

					}
				}
			}

		} else if (finals) {

			// Doing finals
			if (roundNum == initalRounds) {
				if (teamName.equals(round.get(roundNum).get(0))) {
					round.get(roundNum + 1).add(teamName);
					tournamentWinner = teamName;
				} else if (teamName.equals(round.get(roundNum).get(1))) {
					round.get(roundNum + 1).add(teamName);
					loserRound.get(numRounds - 1).set(0, round.get(roundNum).get(0));
					round.get(roundNum + 1).add(round.get(roundNum).get(0));
				}
			} else {

				round.get(numRounds - 2).add(teamName);
				tournamentWinner = teamName;
			}

		}

		if (round.get(initalRounds).size() == 1 && loserRound.get(numRounds - 2).size() == 1
				&& !loserRound.get(numRounds - 2).get(0).equals("?")) {
			finals = true;
			round.get(initalRounds).add(teamName);
		}
	}

	@Override
	int getMatchBracket(int roundNum, int matchNumber) {

		if (matchNumber * 2 <= round.get(roundNum - 1).size()) {
			return 0;

		} else if (matchNumber * 2 <= (round.get(roundNum - 1).size() + loserRound.get(roundNum - 1).size())) {
			return 1;
		}

		// if losers bracket then 1
		// if winners bracket then 0

		return -1;
	}

	static double log(int x, int base) {
		return (double) (Math.log(x) / Math.log(base));
	}

	static int nextPowerOftwo(int n) {
		int p = 1;
		if (n > 0 && (n & (n - 1)) == 0) {
			return n;
		}
		while (p < n) {
			p <<= 1;
		}
		return p;

	}

	public int calcNumberOfTeamsLosers(int roundNumber) {
		int totalTeamsIncludingByes = nextPowerOftwo(teams.size());
		int divideBy;
		if (roundNumber % 2 == 0) {
			divideBy = (int) Math.pow(2.0, (double) (roundNumber / 2));
		} else {
			divideBy = (int) Math.pow(2.0, (double) ((roundNumber + 1) / 2));
		}
		return totalTeamsIncludingByes / divideBy;
	}

	public int numMatchesSkipped(int roundNum, boolean winnersRound) {

		int numByesW = 0;
		// calculate for number of byes in each round
		for (int i = 0; i < round.get(roundNum - 1).size(); i++) {

			if ((round.get(roundNum - 1).get(i)).equals("BYE")) {
				numByesW++;

			}

		}
		int numByesL = 0;
		for (int i = 0; i < loserRound.get(roundNum - 1).size(); i++) {
			if (loserRound.get(roundNum - 1).get(i).equals("BYE")) {
				if (loserRound.get(roundNum - 1).get(i).equals(loserRound.get(roundNum - 1).get(i + 1))) {
					numByesL++;
					i++;
				} else {
					numByesL++;
				}
			}
		}
		if (winnersRound) {
			return numByesW;
		} else {
			return numByesW + numByesL;
		}

	}

	@Override
	public String getTournamentWinner() {
		return tournamentWinner;
	}

	private ArrayList<Team> teamsReverse(ArrayList<Team> teams) {

		ArrayList<Team> teamSecond = new ArrayList<Team>();
		ArrayList<Team> newTeam = new ArrayList<Team>();
		for (int i = teams.size() / 2; i < teams.size(); i++) {
			teamSecond.add(teams.get(i));

		}

		for (int i = 0; i < teams.size() / 2; i++) {
			newTeam.add(teams.get(i));
		}

		Collections.reverse(teamSecond);

		for (int i = 0; i < teamSecond.size(); i++) {
			newTeam.add(teamSecond.get(i));
		}

		return newTeam;
	}
}
