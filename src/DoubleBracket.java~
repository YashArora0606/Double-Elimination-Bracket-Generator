import java.util.ArrayList;

public class DoubleBracket extends Bracket{

 ArrayList<Team> teams;
 int numRounds;
 int numTeams;
 int numMatches;
 int[] numMatchesInRound;
 
 ArrayList<Team>[] round;
 
 

  
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
  
  
  
  // Every round is an ArrayList of the teams that play in the round
  for (int i = 0; i < numRounds; i++) {
   round[i] = new ArrayList<Team>();
  }
  
  // Add teams to the very first round 
  for (int i = 0; i < teams.size(); i++) {
   round[0].add(teams.get(i));
  }
  
  
  
<<<<<<< HEAD
  
  
=======
  //Create 2D array 
>>>>>>> af4b58b69c7a295b55111bc0699b4d88d9c25d15
  
  
  
  
  
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
   
  int numMatches = (int)Math.floor((round[roundNum].size()) / 2) ; 
  return numMatches;
 }

 @Override
 String[][] getTeamsInMatch(int roundNum, int matchNumber) {
  return null;
 }

 @Override
 void setMatchWinner(String teamName, int roundNum, int matchNumber) {  
  
 }
 
 @Override
 int getMatchBracket(int roundNum, int matchNumber) {
 
 // if losers bracket then 1
  // if winners bracket then 0
  
   return 0; 
 }

 static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }
 
 
 
 
 
 

}
