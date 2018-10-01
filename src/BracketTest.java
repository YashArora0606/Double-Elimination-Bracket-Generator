

import java.util.ArrayList;
import java.lang.*;

class BracketTest {
  
   static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }

 public static void main(String[] args) {

  ArrayList<Team> teams = new ArrayList<Team>();
  DoubleGenerator generator;

<<<<<<< HEAD
//  for (int i = 0; i < 20; i++) {
//   teams.add(new Team(((char)(i+64))+""));
//  }
  
  teams.add(new Team("A"));
  teams.add(new Team("B"));
  
  teams.add(new Team("C"));
  teams.add(new Team("D"));
  
  teams.add(new Team("E"));
  teams.add(new Team("F"));
  
  teams.add(new Team("G"));
  teams.add(new Team("H"));
  
  teams.add(new Team("I"));




=======
  for (int i = 0; i < 8; i++) {
   teams.add(new Team(Integer.toString(i)));
  }
>>>>>>> b6dd7ff1cf0b8717f040d8acc2edfa77ef321ddb
  
  generator = new DoubleGenerator(teams);

  DoubleBracket bracket = (DoubleBracket)generator.getBracket();

  
<<<<<<< HEAD

  //System.out.println("Round 1, match 1: " + bracket.getTeamsInMatch(2, 1)[0][0] + " " + bracket.getTeamsInMatch(2, 1)[1][0]);
=======
  
   //void setMatchWinner(String teamName, int roundNum, int matchNumber) {  
  for(int i = 0; i<4; i++){
    bracket.setMatchWinner(Integer.toString(i*2), 1, i+1);
  }
>>>>>>> b6dd7ff1cf0b8717f040d8acc2edfa77ef321ddb
  
 
  bracket.setMatchWinner(Integer.toString(1), 1, 5);
  bracket.setMatchWinner(Integer.toString(5), 1, 6);
  
  bracket.setMatchWinner(Integer.toString(0), 2, 1);
  bracket.setMatchWinner(Integer.toString(4), 2, 2);  
  
  bracket.setMatchWinner(Integer.toString(1), 2, 3);
  bracket.setMatchWinner(Integer.toString(6), 2, 4);
  
<<<<<<< HEAD
  //System.out.println(bracket.getNumberOfRounds());

//  for (int j = 1; j < bracket.getNumberOfRounds(); j++) {
//	  for (int i = 1; i <= bracket.getNumberOfMatchesInRound(j); i++) {
//		  bracket.setMatchWinner(Integer.toString((i-1)*2), j, i);
//	  }
//  }
  
//  for (int i = 1; i <= bracket.getNumberOfMatchesInRound(2); i++) {
//	  bracket.setMatchWinner(Integer.toString((i-1)*2), 2, i);
//  }

//  for (int i = 1; i <)

=======
  bracket.setMatchWinner(Integer.toString(0), 3, 1);
  
  bracket.setMatchWinner(Integer.toString(1), 3, 2);
  bracket.setMatchWinner(Integer.toString(6), 3, 3);
  bracket.setMatchWinner(Integer.toString(1), 4, 1);
>>>>>>> b6dd7ff1cf0b8717f040d8acc2edfa77ef321ddb

  
//  bracket.setMatchWinner("A", 1, 1);
//  bracket.setMatchWinner("B", 1, 2);
//  bracket.setMatchWinner("C", 1, 3);
//  bracket.setMatchWinner("D", 1, 4);


  
//  System.out.println();
//  
//  for (int i = 1; i < bracket.getNumberOfRounds(); i++) {
//	  
//	  int num = bracket.getNumberOfMatchesInRound(i);
//	  
//	  if (num != 0) {
//		  System.out.println(num);
//	  }
//  }

  System.out.println();
  
  String[][] thing = bracket.getTeamsInMatch(3, 1);
  
<<<<<<< HEAD
  System.out.println("Top:");
  for (int i = 0; i < thing[0].length; i++) {
	  System.out.println(thing[0][i]);
  }
  
  System.out.println();

  System.out.println("Bottom:");
  for (int i = 0; i < thing[1].length; i++) {
	  System.out.println(thing[1][i]);
  }

  
  //System.out.print(bracket.getNumberOfRounds());

=======
>>>>>>> b6dd7ff1cf0b8717f040d8acc2edfa77ef321ddb
 

   

  
  System.out.println();
  System.out.println(bracket.getNumberOfRounds());
  System.out.println(bracket.getNumberOfMatchesInRound(1));
  System.out.println(bracket.getMatchBracket(1,2));
  
  System.out.println(bracket.getNumberOfMatchesInRound(2));
  
  

 }

}
