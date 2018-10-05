

import java.util.ArrayList;
import java.lang.*;

class BracketTest {
  
   static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }

 public static void main(String[] args) {

  ArrayList<Team> teams = new ArrayList<Team>();
  //DoubleGenerator generator;
  //SingleGenerator singleGenerator;

  
//  int numTeamsMade = 9;
//
//  for (int i = 0; i < numTeamsMade; i++) {
//   teams.add(new Team(Character.toString(((char)(65+i)))  ) );
//  }
  
  //generator = new DoubleGenerator(teams);
  //singleGenerator = new SingleGenerator(teams, false);

  //DoubleBracket bracket = (DoubleBracket)generator.getBracket();
  //SingleBracket singleBracket = (SingleBracket)singleGenerator.getBracket();

  ManagementSystem managementSystem = new ManagementSystem();
  
  //Display disp = new Display(singleBracket);

  
  
   //void setMatchWinner(String teamName, int roundNum, int matchNumber) {  
  /*
  for(int i = 0; i<4; i++){
    bracket.setMatchWinner(Integer.toString(i*2), 1, i+1);
  }
  */
  
  
  bracket.setMatchWinner("H", 1, 8);
  
 
 bracket.setMatchWinner("A", 2, 1);
 bracket.setMatchWinner("C", 2, 2);
 bracket.setMatchWinner("E", 2, 3);
 bracket.setMatchWinner("G", 2, 4);
 
 bracket.setMatchWinner("I", 2, 8);
 
 bracket.setMatchWinner("A", 3, 1);
 bracket.setMatchWinner("E", 3, 2);
 
 bracket.setMatchWinner("B", 3, 3);
 bracket.setMatchWinner("F", 3, 4);
 
 bracket.setMatchWinner("C", 4, 2);
 bracket.setMatchWinner("G", 4, 3);
 
 bracket.setMatchWinner("A", 4, 1);

 bracket.setMatchWinner("C", 5, 1);
 
 bracket.setMatchWinner("C", 6, 1);
 
 bracket.setMatchWinner("C", 5, 1);
 
 bracket.setMatchWinner("C", 6, 1);

 
 

 
  
   

   



  
  
  
  
 
  //8 teams
  /*
  bracket.setMatchWinner(Integer.toString(1), 1, 5);
  bracket.setMatchWinner(Integer.toString(5), 1, 6);
  
  bracket.setMatchWinner(Integer.toString(0), 2, 1);
  bracket.setMatchWinner(Integer.toString(4), 2, 2);  
  
  bracket.setMatchWinner(Integer.toString(1), 2, 3);
  bracket.setMatchWinner(Integer.toString(6), 2, 4);
  
  bracket.setMatchWinner(Integer.toString(0), 3, 1);
  

  
  bracket.setMatchWinner(Integer.toString(1), 3, 2);
  bracket.setMatchWinner(Integer.toString(6), 3, 3);
  bracket.setMatchWinner(Integer.toString(1), 4, 1);
  bracket.setMatchWinner(Integer.toString(1), 6, 1);
  bracket.setMatchWinner(Integer.toString(0), 7, 1);
  */

  //3 teams
  //bracket.setMatchWinner(Integer.toString(0), 0, 1);

  System.out.println("winnerRound1 " + bracket.round.get(0));    
  System.out.println("winnerRound2 " + bracket.round.get(1));     
  System.out.println("winnerRound3 " + bracket.round.get(2));
  System.out.println("winnerRound4 " + bracket.round.get(3)); 
  System.out.println("winnerRound5 " + bracket.round.get(4));  
  System.out.println("winnerRound6 " + bracket.round.get(5));  
  System.out.println("winnerRound7 " + bracket.round.get(6));  
  
  System.out.println("loserRound " + bracket.loserRound.get(0));
  System.out.println("loserRound2 " + bracket.loserRound.get(1));
  System.out.println("loserRound3 " + bracket.loserRound.get(2));
  System.out.println("loserRound4 " + bracket.loserRound.get(3));
  System.out.println("loserRound5 " + bracket.loserRound.get(4));
  System.out.println("loserRound6 " + bracket.loserRound.get(5));
  System.out.println("loserRound7 " + bracket.loserRound.get(6));
  System.out.println("loserRound8 " + bracket.loserRound.get(7));
  /*
  System.out.println("winnerRound4 " + bracket.round.get(3));   
  System.out.println("loserRound4 " + bracket.loserRound.get(3));
  System.out.println("winnerRound5 " + bracket.round.get(4));   
  System.out.println("loserRound5 " + bracket.loserRound.get(4));
  
  */
  
  /*
  System.out.println("winnerRound6 " + bracket.round.get(5));   
  System.out.println("loserRound6 " + bracket.loserRound.get(5));
  System.out.println("final Round2 " + bracket.finalRound[0] + " , " + bracket.finalRound[1] );
  System.out.println("winnerRound7 " + bracket.round.get(6));   
  System.out.println("loserRound7 " + bracket.loserRound.get(6));
  System.out.println("");
  */
  
 

   

  /*
  System.out.println();
  System.out.println(bracket.getNumberOfRounds());
  System.out.println(bracket.getNumberOfMatchesInRound(1));
  System.out.println(bracket.getMatchBracket(1,2));
  */
  
  System.out.println(bracket.getNumberOfMatchesInRound(1));
  
//  System.out.println("winnerRound " + bracket.round.get(0));   
//  System.out.println("loserRound " + bracket.loserRound.get(0));
//  System.out.println("winnerRound2 " + bracket.round.get(1));   
//  System.out.println("loserRound2 " + bracket.loserRound.get(1));
//  System.out.println("winnerRound3 " + bracket.round.get(2));   
//  System.out.println("loserRound3 " + bracket.loserRound.get(2));
//  System.out.println("winnerRound4 " + bracket.round.get(3));   
//  System.out.println("loserRound4 " + bracket.loserRound.get(3));
//  System.out.println("winnerRound5 " + bracket.round.get(4));   
//  System.out.println("loserRound5 " + bracket.loserRound.get(4));
//  System.out.println("final Round " + bracket.finalRound[0] + " , " + bracket.finalRound[1] );
//  
//  System.out.println("winnerRound6 " + bracket.round.get(5));   
//  System.out.println("loserRound6 " + bracket.loserRound.get(5));
//  System.out.println("final Round2 " + bracket.finalRound[0] + " , " + bracket.finalRound[1] );
//  System.out.println("winnerRound7 " + bracket.round.get(6));   
//  System.out.println("loserRound7 " + bracket.loserRound.get(6));
//  System.out.println("");
  
 
<<<<<<< HEAD
=======


  
//  String[][] teamsInMatch = bracket.getTeamsInMatch(1, 8);
//  
//  for (int i = 0; i < teamsInMatch[0].length; i++) {
//	  System.out.println(teamsInMatch[0][i] + " ");
//  }
//  
//  System.out.println("\nvs.\n");
//
//  
//  
//  for (int i = 0; i < teamsInMatch[1].length; i++) {
//	  System.out.println(teamsInMatch[1][i] + " ");
//  }
>>>>>>> 6c934c6002c142b9a31d9bfba956d515abec1226
  
  
//  
//  for (int i = 0; i < bracket.getNumberOfRounds(); i++) {
//   System.out.println(bracket.calcNumberOfMatchLosers(i+1));
//  }

  





 }

}
