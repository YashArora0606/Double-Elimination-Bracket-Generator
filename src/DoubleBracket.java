import java.util.ArrayList;

public class DoubleBracket extends Bracket{

	ArrayList<Team> teams;
	int numRounds;
	int numTeams;
	int numMatches;
	int[] numMatchesInRound;
  
	// DONE
	DoubleBracket(ArrayList<Team> teams) {
		this.teams = teams;
		
		numRounds = (int)(Math.ceil(Math.log(teams.size())/Math.log(2)));
		numTeams = teams.size();
		numMatches = (teams.size() - 1) * 2;
		
		
		
		int L2 = log(teams.size(), 2);
		int surplus = (int)(Math.ceil(L2) + Math.ceil(log(L2, 2)));
		
		
		int total = (int)(Math.ceil(Math.log(teams.size())/Math.log(2))) + surplus;
		
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
	


	static int log(int x, int base) {
	    return (int) (Math.log(x) / Math.log(base));
	}
 
 @Override
 int getNumberOfMatchesInRound(int round) {
  return 5;  
 }

 @Override
 String[][] getTeamsInMatch(int round, int matchNumber) {
  return null;
 }

 @Override
 void setMatchWinner(String teamName, int round, int matchNumber) {  
 }
 
 @Override
 int getMatchBracket(int round, int matchNumber) {
   return 0; 
 }
 
 
 
 
 

}
