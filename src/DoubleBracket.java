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
<<<<<<< HEAD
  
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
  
  
  
  
  
  
  
=======
  numMatches = (teams.size() - 1) * 2;
  numRounds = (int)   (Math.ceil(log(teams.size(),2)) + (int)(Math.ceil(log((int)log(teams.size(),2),2))));

  
  
//  double L2 = log(teams.size(),2);
//  int initalRounds = (int)Math.ceil(log(teams.size(),2));
//  int surplusRounds = (int)(Math.ceil(log((int)log(teams.size(),2),2)));
  
  
>>>>>>> 3222543caace12bdffa06c2876db8d019d0d7fd0
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
 


 static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
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
