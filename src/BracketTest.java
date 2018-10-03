

import java.util.ArrayList;
import java.lang.*;

class BracketTest {
  
   static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }

 public static void main(String[] args) {

  ArrayList<Team> teams = new ArrayList<Team>();
  DoubleGenerator generator;
  
  int numTeamsMade = 9;

  for (int i = 0; i < numTeamsMade; i++) {
   teams.add(new Team(   Character.toString(((char)(65+i)))  ) );
  }
  
  generator = new DoubleGenerator(teams);

  DoubleBracket bracket = (DoubleBracket)generator.getBracket();

  
  
   //void setMatchWinner(String teamName, int roundNum, int matchNumber) {  
  /*
  for(int i = 0; i<4; i++){
    bracket.setMatchWinner(Integer.toString(i*2), 1, i+1);
  }
  */
  
 
  /*
  bracket.setMatchWinner(Integer.toString(1), 1, 5);
  bracket.setMatchWinner(Integer.toString(5), 1, 6);
=======
  
  teams.add(new Team("A"));
  teams.add(new Team("B"));
  
  teams.add(new Team("C"));
  teams.add(new Team("D"));
>>>>>>> 35651f044639e87ebb548439f9aec378e63b13a6
  
  teams.add(new Team("E"));
  teams.add(new Team("F"));
  
  teams.add(new Team("G"));
  teams.add(new Team("H"));
  
  
<<<<<<< HEAD
  bracket.setMatchWinner(Integer.toString(1), 3, 2);
  bracket.setMatchWinner(Integer.toString(6), 3, 3);
  bracket.setMatchWinner(Integer.toString(1), 4, 1);
  bracket.setMatchWinner(Integer.toString(1), 6, 1);
  bracket.setMatchWinner(Integer.toString(0), 7, 1);
  */

  
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
  
 
  generator = new DoubleGenerator(teams);



  System.out.print("[ ");
  
  String[][] teamsInMatch = bracket.getTeamsInMatch(1, 9);
  
  for (int i = 0; i < teamsInMatch[0].length; i++) {
	  System.out.print(teamsInMatch[0][i] + " ");
  }
  
  System.out.print("] vs. [ ");

  
  
  for (int i = 0; i < teamsInMatch[1].length; i++) {
	  System.out.print(teamsInMatch[1][i] + " ");
  }
  
  System.out.print("]");



 }

}
