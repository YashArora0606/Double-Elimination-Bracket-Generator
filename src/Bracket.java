/**
 * [Bracket.java]
 * interface outline for methods needed in double bracket
 * Authors: Jason Wang and Yash Arora 
 * September 19, 2018
 */

public abstract class Bracket {

	/**
	 * getNumberOfTeams
	 * This method returns number of teams in tournament
	 * @return numTeams, an integer representing number of teams in tournament 
	 */
	abstract int getNumberOfTeams();

	/**
	 * getNumberOfRounds
	 * This method returns number of rounds in the tournament
	 * @return numRounds,  an integer representing number of rounds in tournament 
	 */
	abstract int getNumberOfRounds();

	/**
	 * getNumberOfMatchesInRound
	 * This method returns number of matches in given round
	 * @param round, An integer representing round number
	 * @return numMatches, an integer of how many matches are in the round 
	 */
	abstract int getNumberOfMatchesInRound(int round);

	/**
	 * getTeamsInMatch
	 * This method returns the teams that could possibly play in a match
	 * @param round, an integer representing the round number
	 * @param matchNumber, an integer representing the matchNumber 
	 * @return teamsInMatch, a 2D array of String that contains all the possible teams that can play in the given match
	 */
	abstract String[][] getTeamsInMatch(int round, int matchNumber); // String[2][]

	/**
	 * setMatchWinner
	 * This method updates the tournament bracket once a winner has been determined
	 * @param teamName, a string representing the winning team name 
	 * @param round, a integer representing the winner round number
	 * @param matchNumber, a integer representing the winner match number
	 */
	abstract void setMatchWinner(String teamName, int round, int matchNumber);

	/**
	 * getMatchBracket
	 * This method returns whether the entered match is in the winners of loser bracket 
	 * @param round, an integer representing the round number
	 * @param matchNumber, an integer representing the match number
	 * @return return 0 if match is in winners bracket and return -1 if matchNumber is in loser bracket
	 */
	abstract int getMatchBracket(int round, int matchNumber);

	/**
	 * getTournamentWinner
	 * This method returns the winner of the whole tournament
	 * @return tournamentWinner, a string representing the winner of the tournament
	 */
	abstract String getTournamentWinner();

}
