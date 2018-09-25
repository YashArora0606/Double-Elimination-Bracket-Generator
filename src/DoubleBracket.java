import java.util.ArrayList;

public class DoubleBracket extends Bracket{

	ArrayList<Team> teams;
  
	// DONE
	DoubleBracket(ArrayList<Team> teams) {
		this.teams = teams;
	}
	// DONE
	@Override
	int getNumberOfTeams() {
		return teams.size();
	}
	// DONE
	@Override
	int getNumberOfRounds() {
		return (int)(Math.ceil(Math.log(teams.size())/Math.log(2)));
	}


 
 
 @Override
 int getNumberOfMatchesInRound(int round) {
  return 0;  
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
