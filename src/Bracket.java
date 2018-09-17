
public abstract class Bracket {
	abstract int getNumberOfTeams();
	abstract int getNumberOfRounds();
	abstract int getNumberOfMatchesInRound(int round);
	abstract String[][] getTeamsInMatch(int round, int matchNumber); // String[2][]
	abstract void setMatchWinner(String teamName, int round, int matchNumber);
	
	
}
