
/**
 * [DoubleBracket.java]
 * Bracket for double elimination, updates bracket as tournament progress 
 * Authors: Jason Wang and Yash Arora 
 * September 19, 2018
 */

import java.util.ArrayList;

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
	boolean inWinnersBracket;
	static int numByesSeed = 0;
	String[] finalMatch = new String[2];
	int timesLoserBeatWinner = 0;
	
	
	// ArrayList<Team>[] round;
	ArrayList<ArrayList<String>> round;
	ArrayList<ArrayList<String>> loserRound;

	DoubleBracket(ArrayList<Team> teams) {
		this.teams = teams;

		numTeams = teams.size();
		numMatchesInRound = new int[numRounds + 1];
		numMatches = (teams.size() - 1) * 2;

		// Calculate number of rounds
		double L2 = log(teams.size(), 2);
		initalRounds = (int) Math.ceil(L2); // Initial rounds represents rounds in winners bracket
		int surplusRounds = (int) (Math.ceil(log((int) L2, 2))); // Surplus rounds represent rounds the extra rounds
		numRounds = initalRounds + surplusRounds + 1 + 1; // add 2 to account for the extra possible bonus round, and to
															// double count finals

		// create arrayLists of arrayLists one for loserRound one fore winnerRound
		// use array lists for easy use and easy access
		round = new ArrayList<ArrayList<String>>(numRounds);
		loserRound = new ArrayList<ArrayList<String>>(numRounds);

		// Every round is an ArrayList of the teams that play in the round
		for (int i = 0; i < numRounds; i++) {
			ArrayList<String> indArr = new ArrayList<String>();
			round.add(indArr);
		}

		for (int i = 0; i < numRounds; i++) {
			ArrayList<String> indArr = new ArrayList<String>();
			loserRound.add(indArr);
		}

		// add placeHolders for the winners round enables the round to be played in any
		// match number order
		int previousSize = nextPowerOftwo(teams.size()) / 2;
		for (int i = 1; i <= initalRounds; i++) {

			for (int j = 0; j < previousSize; j++) {
				round.get(i).add("unknown");
			}
			previousSize = previousSize / 2;
		}
		round.get(initalRounds).add("unknown");

		// add teams in to the first round
		for (int i = 0; i < teams.size(); i++) {
			round.get(0).add(i, teams.get(i).getName());
		}

		// calculate number of BYES that is needed
		int numByes = nextPowerOftwo(teams.size()) - teams.size();

		// Add byes into the first round
		for (int i = 1; i <= numByes; i++) {
			round.get(0).add((i * 2) - 1, "BYE");
		}

		for (int i = 1; i <= numRounds; i++) {
			for (int j = 0; j < calcNumberOfTeamsLosers(i); j++) {
				loserRound.get(i - 1).add("unknown");
			}

		}

		// automatically move byes down to the next round
		if (seed) {
			for (int i = 1; i <= (nextPowerOftwo(teams.size()) / 2); i++) {
				if (round.get(0).get((i) - 1).equals("BYE")) {
					round.get(1).set((i - 1) / 2, round.get(0).get((i - 2)));
					loserRound.get(0).set((i - 1) / 2, "BYE");
				}
			}

			for (int i = (nextPowerOftwo(teams.size()) / 2) + 1; i <= (nextPowerOftwo(teams.size())) - 1; i++) {
				if (round.get(0).get((i) - 1).equals("BYE")) {
					round.get(1).set((i - 1) / 2, round.get(0).get((i)));
					loserRound.get(0).set((i - 1) / 2, "BYE");
				}
			}
		} else if (!seed) {
			for (int i = 1; i <= (nextPowerOftwo(teams.size()) / 2); i++) {
				if (round.get(0).get((i * 2) - 1).equals("BYE")) {
					round.get(1).set(i - 1, round.get(0).get((i * 2) - 2));
					loserRound.get(0).set(i - 1, "BYE");
				}
			}
		}

	}

	/**
	 * getNumberOfTeams This method returns number of teams in tournament
	 * 
	 * @return numTeams, an integer representing number of teams in tournament
	 */
	@Override
	int getNumberOfTeams() {
		return numTeams;
	}

	/**
	 * getNumberOfRounds This method returns number of rounds in the tournament
	 * 
	 * @return numRounds, an integer representing number of rounds in tournament
	 */
	@Override
	int getNumberOfRounds() {
		// minus 1 because the final round is double counted
		return numRounds-2;
	}

	/**
	 * getNumberOfMatchesInRound This method returns number of matches in given
	 * round
	 * 
	 * @param round,
	 *            An integer representing round number
	 * @return numMatches, an integer of how many matches are in the round
	 */
	@Override
	int getNumberOfMatchesInRound(int roundNum) {
		numMatchesWinners = (int) Math.floor((round.get(roundNum - 1).size()) / 2);
		numMatchesLosers = (int) Math.floor(calcNumberOfTeamsLosers(roundNum)) / 2;

		// Calculate number of byes in round
		int numByes = numMatchesSkipped(roundNum, false);

		// subtract number of byes as those do not count as matches
		numMatches = numMatchesWinners + numMatchesLosers - numByes;

		return numMatches;

	}

	/**
	 * getTeamsInMatch This method returns the teams that could possibly play in a
	 * match
	 * 
	 * @param round,
	 *            an integer representing the round number
	 * @param matchNumber,
	 *            an integer representing the matchNumber
	 * @return teamsInMatch, a 2D array of String that contains all the possible
	 *         teams that can play in the given match
	 */
	@Override
	String[][] getTeamsInMatch(int roundNum, int matchNumber) {

		//System.out.println("RoundNumber: " + roundNum);
		//System.out.println("MatchNumber: " + matchNumber);

		int roundSize = round.get(roundNum - 1).size();

		if (roundSize % 2 == 1) {
			roundSize++;
		}

		// System.out.println(roundSize);

		// boolean inWinnersBracket;
		// if (matchNumber * 2 <= roundSize) {
		// inWinnersBracket = true;
		// } else {
		// inWinnersBracket = false;
		// }

		if (getMatchBracket(roundNum, matchNumber) == 0) {
			inWinnersBracket = true;
		} else {
			inWinnersBracket = false;
		}

		matchNumber = matchNumber + numMatchesSkipped(roundNum, inWinnersBracket);
		

		// System.out.println(inWinnersBracket);
		//System.out.println(inWinnersBracket);

		String[][] teamsInMatch = new String[2][];

		ArrayList<String> possibleTop = new ArrayList<String>();
		ArrayList<String> possibleBottom = new ArrayList<String>();

		boolean alreadyFull1 = false;
		boolean alreadyFull2 = false;

		// If the match is part of the winner's bracket
		if (inWinnersBracket) {
			
			
			// If final round
			if (roundNum-1 == initalRounds) {
				
				// If not yet decided winner of loser round
				if (loserRound.get(initalRounds + 1).get(0).equals("unknown")) {
					//System.out.println("CASE 1");

					String top = round.get(roundNum-1).get((matchNumber * 2) - 2);
					
					String[] bottom = new String[loserRound.get(roundNum-1).size()];
//					
//					String bottom1 = loserRound.get(roundNum-1).get(0);
//					String bottom2 = loserRound.get(roundNum-1).get(1);
					
					for (int i = 0; i < bottom.length; i++) {
						bottom[i] = loserRound.get(roundNum-1).get(i);
					}
					

					teamsInMatch[0] = new String[] { top };
					teamsInMatch[1] = bottom;
					
					return teamsInMatch;			
					
					// If winner of the loser round has been decided
				} else {
					
					//System.out.println("CASE 2");
										
					String top = round.get(roundNum-1).get((matchNumber * 2) - 2);
					
					round.get(roundNum-1).set(1, loserRound.get(roundNum).get(0));
					String bottom = round.get(roundNum-1).get(1);
					
					finalMatch[0] = round.get(roundNum-1).get((matchNumber * 2) - 2);
					finalMatch[1] = loserRound.get(roundNum).get(0);
					
					
					
					
					//System.out.println("THIS: " + round.get(roundNum-1).get(1));



					teamsInMatch[0] = new String[] { finalMatch[0] };
					teamsInMatch[1] = new String[] { finalMatch[1] };
					
					return teamsInMatch;
					
				}
			}
			
			
			

			// If it is round 1 of the winners bracket
			if (roundNum == 1) {
				String top = round.get(0).get((matchNumber * 2) - 2);
				String bottom = round.get(0).get((matchNumber * 2) - 1);

				teamsInMatch[0] = new String[] { top };
				teamsInMatch[1] = new String[] { bottom };

				// If it is any other round in the winner's bracket
			} else if (roundNum > 1) {

				if (((matchNumber * 2) - 2) < round.get(roundNum - 1).size()
						&& !round.get(roundNum - 1).get((matchNumber * 2) - 2).isEmpty()
						&& round.get(roundNum - 1).get((matchNumber * 2) - 2) != "unknown") {

					alreadyFull1 = true;
					String top = round.get(roundNum - 1).get((matchNumber * 2) - 2);
					teamsInMatch[0] = new String[] { top };

				}

				try {

					if (round.get(roundNum - 1).get((matchNumber * 2) - 1) != "unknown"
							&& !round.get(roundNum - 1).get((matchNumber * 2) - 1).isEmpty()) {
						alreadyFull2 = true;
						String bottom = round.get(roundNum - 1).get((matchNumber * 2) - 1);
						teamsInMatch[1] = new String[] { bottom };

					}

				} catch (IndexOutOfBoundsException e) {

				}

				//System.out.println("full1" + alreadyFull1);
				//System.out.println("full2" + alreadyFull2);

				if (alreadyFull1 && alreadyFull2) {
					return teamsInMatch;
				}

				// If only top side is full
				if (alreadyFull1 && !alreadyFull2) {
					
					
					possibleTop.addAll(findPossTop(roundNum - 1, matchNumber * 2, inWinnersBracket));
					int tempCounter = 0;
					while (possibleTop.size() == 0) {
						tempCounter++;
						possibleTop.addAll(findPossTop(roundNum - 1, matchNumber * 2 - tempCounter, inWinnersBracket));
					}
					for (int i = 0; i < possibleTop.size(); i++) {
						possibleTop.remove("BYE");
					}
					teamsInMatch[1] = new String[possibleTop.size()];
					for (int i = 0; i < teamsInMatch[1].length; i++) {
						teamsInMatch[1][i] = possibleTop.get(i);
					}
					
					return teamsInMatch;


					// If only bot side is full
				} else if (alreadyFull2 && !alreadyFull1) {
					possibleBottom.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1, inWinnersBracket));
					for (int i = 0; i < possibleBottom.size(); i++) {
						possibleBottom.remove("BYE");
					}
					teamsInMatch[0] = new String[possibleBottom.size()];
					for (int i = 0; i < teamsInMatch[0].length; i++) {
						teamsInMatch[0][i] = possibleBottom.get(i);
					}
					
					return teamsInMatch;
				}

				possibleTop.addAll(findPossTop(roundNum - 1, matchNumber * 2, inWinnersBracket));

				int tempCounter = 0;
				while (possibleTop.size() == 0) {
					tempCounter++;
					possibleTop.addAll(findPossTop(roundNum - 1, matchNumber * 2 - tempCounter, inWinnersBracket));

				}

				possibleBottom.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1, inWinnersBracket));

				for (int i = 0; i < possibleTop.size(); i++) {
					possibleTop.remove("BYE");
				}

				for (int i = 0; i < possibleBottom.size(); i++) {
					possibleBottom.remove("BYE");
				}

				teamsInMatch[0] = new String[possibleBottom.size()];
				teamsInMatch[1] = new String[possibleTop.size()];

				for (int i = 0; i < teamsInMatch[1].length; i++) {
					teamsInMatch[1][i] = possibleTop.get(i);
				}
				for (int i = 0; i < teamsInMatch[0].length; i++) {
					teamsInMatch[0][i] = possibleBottom.get(i);
				}
			}
			
			return teamsInMatch;

			// If it is in the loser's bracket
		} else if (!inWinnersBracket) {

			// Need to calculate the new match number to work with
			roundSize = round.get(roundNum - 1).size();
			int newTeamNumber = (matchNumber * 2) - (roundSize + 1);
			int newMatchNumber = (newTeamNumber + 1) / 2;
			//System.out.println(newMatchNumber);

			// If it is round 1 of the loser's bracket
			if (roundNum == 1) {
				String top = loserRound.get(0).get((newMatchNumber * 2) - 2);
				String bottom = loserRound.get(0).get((newMatchNumber * 2) - 1);

				teamsInMatch[0] = new String[] { top };
				teamsInMatch[1] = new String[] { bottom };

				// If it is any other round in the loser's bracket
			} else if (roundNum > 1) {

				String top = loserRound.get(roundNum - 1).get((newMatchNumber * 2) - 2);
				String bottom = loserRound.get(roundNum - 1).get((newMatchNumber * 2) - 1);

				teamsInMatch[0] = new String[] { top };
				teamsInMatch[1] = new String[] { bottom };


			}

		}

		return teamsInMatch;

	}

	/**
	 * findPossTop This method returns the teams that might play, if no teams are
	 * already playing in that round and match
	 * 
	 * @param roundNum,
	 *            an integer representing the round number
	 * @param matchNumber,
	 *            an integer representing the matchNumber
	 * @return combinedArray/possibleTop, an ArrayList of String that contains all
	 *         the possible teams that can play in the given position of a match
	 */
	ArrayList<String> findPossTop(int roundNum, int matchNumber, boolean inWinnersBracket) {

		ArrayList<String> possibleTop = new ArrayList<String>();

		int roundSize = round.get(roundNum - 1).size();
		// System.out.println(round.get(roundNum-1).get((matchNumber*2)-1));
		// System.out.println(roundNum);
		// System.out.println(matchNumber);

		// If in the winner's bracket
		if (inWinnersBracket) {

			// If the round number is 1 or the teams in that match have already been decided
			// if (roundNum == 1 || round.get(roundNum-1).get((matchNumber*2)-1) != "unknown") {
			// possibleTop.add(round.get(roundNum-1).get((matchNumber*2)-1));
			// }

			if (roundNum == 0) {
				return possibleTop;
			}

			// if (roundNum == 1) {
			// //System.out.println("YESYES");
			// //possibleTop.add(round.get(0).get((matchNumber * 2) - 2));
			// return possibleTop;
			// }

			if (matchNumber > round.get(roundNum).size()) {
				return possibleTop;
			}

			if ((matchNumber * 2) - 2 < round.get(roundNum - 1).size()) {
				// System.out.println("R" + roundNum);
				// System.out.println("M" + matchNumber);
				//
				//
				// System.out.println(round.get(roundNum - 1).get((matchNumber * 2) - 1));
				// System.out.println(round.get(roundNum - 1).get((matchNumber * 2) - 2));
				//
				// System.out.println();

				possibleTop.add(round.get(roundNum - 1).get((matchNumber * 2) - 1));

				if ((matchNumber * 2) - 1 < round.get(roundNum - 1).size()) {
					possibleTop.add(round.get(roundNum - 1).get((matchNumber * 2) - 2));

				}
				if (round.get(roundNum - 1).get((matchNumber * 2) - 1) == "unknown") {
					possibleTop.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1, inWinnersBracket));
					possibleTop.addAll(findPossTop(roundNum - 1, (matchNumber * 2), inWinnersBracket));

				}

				for (int j = 0; j < possibleTop.size(); j++) {
					for (int i = 0; i < possibleTop.size(); i++) {
						if (possibleTop.get(i).equals("unknown")) {
							possibleTop.remove(i);
						}
					}
				}

				return possibleTop;

			} else {

				ArrayList<String> combinedArray = new ArrayList<String>();
				combinedArray.addAll(findPossTop(roundNum - 1, matchNumber * 2, inWinnersBracket));
				combinedArray.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1, inWinnersBracket));

				for (int i = 0; i < combinedArray.size(); i++) {
					if (combinedArray.get(i).equals("unknown")) {
						combinedArray.remove(i);
					}
				}

				return combinedArray;
			}

		} else if (!inWinnersBracket) {
			int newTeamNumber = (matchNumber * 2) - (roundSize + 1);
			int newMatchNumber = (newTeamNumber + 1) / 2;

			if (roundNum == 0) {
				return possibleTop;
			}

			if (newMatchNumber > loserRound.get(roundNum).size()) {
				return possibleTop;
			}

			if ((newMatchNumber * 2) - 2 < loserRound.get(roundNum - 1).size()) {

				// System.out.println(roundNum);
				// System.out.println(newMatchNumber);

				possibleTop.add(loserRound.get(roundNum - 1).get((newMatchNumber * 2) - 1));
				if ((newMatchNumber * 2) - 2 < loserRound.get(roundNum - 1).size()) {
					possibleTop.add(loserRound.get(roundNum - 1).get((newMatchNumber * 2) - 2));
				}

				return possibleTop;

			} else {

				ArrayList<String> combinedArray = new ArrayList<String>();
				combinedArray.addAll(findPossTop(roundNum - 1, matchNumber * 2, inWinnersBracket));
				combinedArray.addAll(findPossTop(roundNum - 1, (matchNumber * 2) - 1, inWinnersBracket));

				return combinedArray;
			}
		}
		return null;


	}

	/**
	 * setMatchWinner This method updates the tournament bracket once a winner has
	 * been determined
	 * 
	 * @param teamName,
	 *            a string representing the winning team name
	 * @param round,
	 *            a integer representing the winner round number
	 * @param matchNumber,
	 *            a integer representing the winner match number
	 */
	@Override
	void setMatchWinner(String teamName, int roundNum, int matchNumber) {
		
		
		// If it is the finals
		if (roundNum-1 == initalRounds && matchNumber == 1) {
			
			String tempWinner = teamName;
			timesLoserBeatWinner++;
			
			// if the winner was from the winner bracket
			if (tempWinner.equals(round.get(roundNum-1).get(0))) {
				tournamentWinner = teamName;
			} else if (timesLoserBeatWinner == 2) {
				tournamentWinner = teamName;
			}
			
			
		} else {

		int roundSize = round.get(roundNum - 1).size();

		if ((matchNumber + numMatchesSkipped(roundNum, true)) * 2 <= roundSize) {
			inWinnersBracket = true;
		} else {
			inWinnersBracket = false;
		}

		// change matchNumber to match the bracket(including byes)
		matchNumber = matchNumber + numMatchesSkipped(roundNum, inWinnersBracket);

		// to change the value of roundNum to the index of the round
		roundNum = roundNum - 1;
		
		//System.out.println("finals: "+ finals);

		if (!finals) {

			if (inWinnersBracket) {
				// update bracket with winning team
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
					// move losing teams down to the loser round based on the round number
					addIndex = (matchNumber * 2) - 1; // index of where the loser goes
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
				// update the loser round bracket and move on winners from loser bracket
				if (roundNum % 2 == 0) {
					// different index for where to add team based on round number
					if (matchNumber != 1) {
						addIndex = ((matchNumber * 2) - roundSize) - 2;
					} else if (matchNumber == 1) {
						addIndex = 0;
					}
					loserRound.get(roundNum + 1).set(addIndex, teamName);

				} else if (roundNum % 2 == 1) {
					// different index for where to add team based on round number
					addIndex = (int) (matchNumber - Math.floor((roundSize) / 2) - 1);
					loserRound.get(roundNum + 1).set(addIndex, teamName);
				}
			}

			// Automatically move BYEs down
			if (loserRound.get(roundNum).contains("BYE")) {
				for (int i = 1; i <= (calcNumberOfTeamsLosers(roundNum + 1)) / 2; i++) {
					int matchNumberNew = i + (roundSize / 2);
					if ((loserRound.get(roundNum).get(i * 2 - 2)).equals("BYE")
							&& !loserRound.get(roundNum).get(i * 2 - 1).equals("unknown")) {
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
			
			//System.out.println("WE ARE ON FINALS");

			// Doing finals

			if (roundNum == initalRounds) {
				if (teamName.equals(round.get(roundNum).get(0))) {
					// if winner of winner bracket wins finals update bracket and set tournament
					// winner
					round.get(roundNum + 1).add(teamName);
					tournamentWinner = teamName;
				} else if (teamName.equals(round.get(roundNum).get(1))) {
					// if winner of loser bracket wins finals update bracket with winners and losers
					// and have a rematch in bonus round
					round.get(roundNum + 1).add(teamName);
					loserRound.get(numRounds - 2).set(0, round.get(roundNum).get(0));
					round.get(roundNum + 1).add(round.get(roundNum).get(0));
				}
			} else {
				// if bonus round occurs, after winner is set update bracket and set tournament
				// winner
				round.get(numRounds - 2).add(teamName);
				tournamentWinner = teamName;
			}

		}

		// check if finals conditions has been reached
		if (round.get(initalRounds).size() == 1 && !loserRound.get(numRounds - 3).get(0).equals("unknown")) {
			finals = true;
			round.get(initalRounds).set(1, teamName);
		}
		
		}
	}

	/**
	 * getMatchBracket This method returns whether the entered match is in the
	 * winners of loser bracket
	 * 
	 * @param round,
	 *            an integer representing the round number
	 * @param matchNumber,
	 *            an integer representing the match number
	 * @return return 0 if match is in winners bracket and return -1 if matchNumber
	 *         is in loser bracket
	 */
	@Override
	int getMatchBracket(int roundNum, int matchNumber) {

		int roundSize = round.get(roundNum - 1).size();

		int numByes = nextPowerOftwo(teams.size()) - teams.size();

		if (roundNum == 1) {
			if (matchNumber + numByes <= roundSize / 2) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (matchNumber <= roundSize / 2) {
				return 0;
			} else {
				return 1;
			}
		}

	}

	/**
	 * log This method calculates log to a certain base
	 * 
	 * @param x,
	 *            an integer to be logged
	 * @param base.
	 *            an integer representing the base of the log
	 * @return a value after logged to a certain base
	 */
	static double log(int x, int base) {
		return (double) (Math.log(x) / Math.log(base));
	}

	/**
	 * nextPowerOftwo This method calculates the bracket size by finding the nearest
	 * power of 2 based of n
	 * 
	 * @param n,
	 *            an integer based off of to find the next power of 2
	 * @return p, a integer representing the nearest power of two based of n
	 */
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

	/**
	 * calcNumberOfTeamsLosers This method calculates number of teams in loser round
	 * based of a round number
	 * 
	 * @param roundNum,
	 *            an integer representing the round number
	 * @return totalTeamsIncludingByes / divideBy, a integer representing number of
	 *         teams in loser round
	 */
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

	/**
	 * numMatchesSkipped This method returns the number of matches skipped because
	 * of byes
	 * 
	 * @param roundNum,
	 *            an integer representing the round number
	 * @param winnersRound,
	 *            a boolean value determine if the match is in winners bracket or
	 *            not
	 * @return numByesW if in winners round , numByesW + numByesW if not in winners
	 *         round, an integer representing number of matches skipped
	 */
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

	/**
	 * getTournamentWinner This method returns the winner of the whole tournament
	 * 
	 * @return tournamentWinner, a string representing the winner of the tournament
	 */
	@Override
	public String getTournamentWinner() {
		return tournamentWinner;
	}

}
