import java.util.ArrayList;
import java.util.Collections;

public class DoubleBracket extends Bracket{

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
 
 //ArrayList<Team>[] round;
 ArrayList<ArrayList<String>> round;
 ArrayList<ArrayList<String>> loserRound;

 
 

  
 // DONE
 DoubleBracket(ArrayList<Team> teams) {
  this.teams = teams;
  
 
  numTeams = teams.size();
  numMatchesInRound = new int[numRounds + 1];  
  numMatches = (teams.size() - 1) * 2;
  
  //Calculate number of rounds 
  double L2 = log(teams.size(),2);  
  initalRounds = (int)Math.ceil(L2); 
  int surplusRounds = (int)(Math.ceil(log((int)L2,2)));
  numRounds = initalRounds + surplusRounds + 1; 
  
  round = new ArrayList<ArrayList<String>>(numRounds);
  loserRound = new ArrayList<ArrayList<String>>(numRounds);
  
  
  
   //Every round is an ArrayList of the teams that play in the round
  for (int i = 0; i < numRounds; i++) {
    ArrayList<String> indArr = new ArrayList<String>();
    round.add(indArr);
    //loserRound.add(indArr);
  }
  
  
  for (int i = 0; i < numRounds; i++) {
    ArrayList<String> indArr = new ArrayList<String>();
    loserRound.add(indArr);
  }
  

  // Add teams to the very first round 
  for (int i = 0; i < teams.size(); i++) {
   round.get(0).add(teams.get(i).getName());
   
  }
  
  for(int i = 1; i<=numRounds; i++){
    for(int j = 0; j<teams.size()/2; j++){//+1 incase its odd
      loserRound.get(i-1).add("?");      
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
 numMatchesWinners = (int) Math.floor((round.get(roundNum-1).size())/2); 
 numMatchesLosers = (int) Math.floor(numMatchesWinners/2) + (oldNumMatchesLosers/2);
  oldNumMatchesLosers = numMatchesLosers;
  //System.out.println(round.get(0));
  //System.out.println("loser amount " + loserRound.get(1));
  numMatches = numMatchesWinners + numMatchesLosers;
  return numMatches;  
 }

 @Override
 String[][] getTeamsInMatch(int roundNum, int matchNumber) {
  return null;
 }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 @Override
 void setMatchWinner(String teamName, int roundNum, int matchNumber) {  
   
  
  int roundSize = round.get(roundNum-1).size();
  int loserRoundSize = loserRound.get(roundNum-1).size();
   
  
  boolean inWinnersBracket;
  if(matchNumber*2<= roundSize){
     inWinnersBracket = true; 
  }else{
    inWinnersBracket = false;
  }
  
  
  //to change the value of roundNum to the index of the round 
  roundNum = roundNum - 1;
   
  //if size of mainRound is 1 delete all nulls in loser 
  
  if(roundSize != 1){
    if(roundSize % 2 != 0){
      round.get(roundNum).add("?");
    } 
  }
 
  
  //dont need later when i set it to automtically move on the team with by
  if(loserRoundSize % 2 != 0){
    loserRound.get(roundNum).add("?");
  }
  
    
  if(inWinnersBracket){
    round.get(roundNum+1).add(matchNumber-1, teamName);
    if(roundNum == 0){
      
      //add losing team to losers bracker
      if(round.get(roundNum).get(matchNumber*2-2).equals(teamName)){
        loserRound.get(roundNum).add(matchNumber-1,(round.get(roundNum).get(matchNumber*2-1)));
      }else if(round.get(roundNum).get(matchNumber*2-1).equals(teamName)){
        loserRound.get(roundNum).add(matchNumber-1, (round.get(roundNum).get(matchNumber*2-2)));
      }  
      
    }else if(roundNum != 0){
      //adding teams into the losers bracket after round 1 
      //index for add into black spaces in between the previous losers 
      
      
      addIndex = (matchNumber * 2) -1;
      
      //add losing team to losers bracker(might need to delete finals things) 
      if(!finals){
        if(round.get(roundNum).get(matchNumber*2-2).equals(teamName)){
          loserRound.get(roundNum).set(addIndex,(round.get(roundNum).get(matchNumber*2-1)));
        }else if(round.get(roundNum).get(matchNumber*2-1).equals(teamName)){
          loserRound.get(roundNum).set(addIndex, (round.get(roundNum).get(matchNumber*2-2)));
        }   
      }else{
        if(round.get(roundNum).get(matchNumber*2-2).equals(teamName)){
          loserRound.get(roundNum).add(round.get(roundNum).get(matchNumber*2-1));
        }else if(round.get(roundNum).get(matchNumber*2-1).equals(teamName)){
          loserRound.get(roundNum).add((round.get(roundNum).get(matchNumber*2-2)));
        } 
      }
    }
   
  }else if(!inWinnersBracket){   
    //add leaving one space in between   
    if(finals==true){
      System.out.println("roundSize equals 1");
      loserRound.get(roundNum + 1).add(teamName);
    }else{
        addIndex = ((matchNumber * 2) - roundSize) -2; 
        loserRound.get(roundNum + 1).set(addIndex,teamName);
    } 
  }
  
  

  
  
  /*
  if(roundNum+2 == getNumberOfRounds()-2){
    round.get(roundNum+1).add(loserRound.get(roundNum-1).get(0));
  }
  */
  
  
  
  if(finals){
    System.out.println(roundSize);
    if(round.get(roundNum+1).size() == 0){
      System.out.println("entered");
      round.get(roundNum+1).add(round.get(roundNum-1).get(0));
    }
  }
  

  if(roundSize == 2){
    System.out.println("finals");
    finals = true;
  }
  
  
  if(finals){
    for(int i = initalRounds; i<numRounds; i++){
    loserRound.get(i).removeAll(Collections.singleton("?"));
    }
  }
  
  if(roundSize == 1 && loserRoundSize == 1){
    
  }
  
  
  
  System.out.println("winnerRound " + round.get(0));   
  System.out.println("loserRound " + loserRound.get(0));
  System.out.println("winnerRound2 " + round.get(1));   
  System.out.println("loserRound2 " + loserRound.get(1));
  System.out.println("winnerRound3 " + round.get(2));   
  System.out.println("loserRound3 " + loserRound.get(2));
  System.out.println("winnerRound4 " + round.get(3));   
  System.out.println("loserRound4 " + loserRound.get(3));
  System.out.println("winnerRound5 " + round.get(4));   
  System.out.println("loserRound5 " + loserRound.get(4));
  
  
  System.out.println("winnerRound6 " + round.get(5));   
  System.out.println("loserRound6 " + loserRound.get(5));
  System.out.println("");
   
  

 }
 
 @Override
 int getMatchBracket(int roundNum, int matchNumber) {
   
   if(matchNumber*2 <= round.get(roundNum-1).size()){
     return 0;
     
   }else if(matchNumber*2 <= (round.get(roundNum-1).size() + loserRound.get(roundNum-1).size())){
     return 1;
   }
  
 
 // if losers bracket then 1
  // if winners bracket then 0
  
   return 3; 
 }

 static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }
 
 
 
 
 
 

}
