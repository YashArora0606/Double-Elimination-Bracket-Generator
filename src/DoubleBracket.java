import java.util.ArrayList;

public class DoubleBracket extends Bracket{

 ArrayList<Team> teams;
 int numRounds;
 int numTeams;
 int numMatches;
 int[] numMatchesInRound;
 Team [][] winnersBracket;
 Team [][] losersBracket;
  
 // DONE
 DoubleBracket(ArrayList<Team> teams) {
  this.teams = teams;
  
 
  numTeams = teams.size();
  
  numMatchesInRound = new int[numRounds + 1];  
  
  numMatches = (teams.size() - 1) * 2;
  
  //Calculate number of rounds 
  double L2 = log(teams.size(),2);  
  int initalRounds = (int)Math.ceil(L2); 
  int surplusRounds = (int)(Math.ceil(log((int)L2,2)));
  numRounds = initalRounds + surplusRounds; 
  
  
  //Create 2D array 
  winnersBracket = new Team[initalRounds][teams.size()];
  losersBracket = new Team[numRounds][teams.size()/2];
  
  
  
  
  
  
  
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
 
  static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }
 
 
 
 

}
