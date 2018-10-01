//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Main {
// 
// 
// public static int round = 0;
//
// public static ArrayList<Character> losers = new ArrayList<Character>();
// 
// public static void main(String[] args) {
//  
//   System.out.println((int)(Math.ceil(Math.log(5)/Math.log(2))));
//
//  
//  
////  ArrayList<Character> teams = new ArrayList<Character>();
////
////
////  teams.add('a');
////  teams.add('b');
////  teams.add('c');
////  teams.add('d');
////  teams.add('e');
////  teams.add('f');
////  teams.add('g');
////
////  
////
////  printRound(teams); // print bracket part 1
////  
////  System.out.println();
////  System.out.println();
////  System.out.println();
////
////  for (int i = 0; i < losers.size(); i++) {
////   System.out.println(losers.get(i));
////  }
//
//
// 
//  
//  
// }
// 
// public static void printRound(ArrayList<Character> teams) {
//  
//  
//  if (teams.size()%2 == 1 && teams.size() != 1) {
//   teams.add(' ');
//  }
//  
//  if (teams.size() == 1) {
//   System.out.println(teams.get(0));
//   
//  } else {
//  
//   for (int i = 0; i < teams.size(); i++) {
//    System.out.print(teams.get(i) + "\t");
//   }
//   
//   
//
//   
//   
//   
//   System.out.println();
//   
//   
//   Collections.reverse(teams);
//   getRemainingTeams(teams);
//   round++;
//
//  }
//  
//  
//  
//  
// }
// 
// public static void getRemainingTeams(ArrayList<Character> teams) {
//  
//  ArrayList<Character> teamsLeft= new ArrayList<Character>();
//  for (int i = 0; i < Math.ceil((double) (teams.size()/2)); i++) {
//   char winner = fight(teams.get(i*2), teams.get((i*2)+1));
//   teamsLeft.add(winner);
//  }
//  
//  //Collections.reverse(losers);
//  
//  
//  if (round%2 == 0) {
//   Collections.reverse(teamsLeft);
//  }
//  
//  printRound(teamsLeft);
// }
// 
// public static char fight(char team1, char team2) {
//  
//  if (team1 == ' ') {
//   return team2;
//  } else  if (team2 == ' ') {
//   return team1;
//  }
//  
//  
//  if (team1 < team2) {
//   losers.add(team2);
//   return team1;
//  } else {
//   losers.add(team1);
//   return team2;
//  }
//  
// 
// }
//
//
// 
//}
//
//
//


import java.util.ArrayList;
import java.lang.*;

class BracketTest {
  
   static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }

 public static void main(String[] args) {

  ArrayList<Team> teams = new ArrayList<Team>();
  DoubleGenerator generator;

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




  
  generator = new DoubleGenerator(teams);

  DoubleBracket bracket = (DoubleBracket)generator.getBracket();

  

  //System.out.println("Round 1, match 1: " + bracket.getTeamsInMatch(2, 1)[0][0] + " " + bracket.getTeamsInMatch(2, 1)[1][0]);
  
  //bracket.setMatchWinner("5", 1, 1);
  
  //System.out.println("Round 1, match 1: " + bracket.getTeamsInMatch(2, 1)[0][0] + " " + bracket.getTeamsInMatch(2, 1)[1][0]);
  
  //System.out.println(bracket.getNumberOfMatchesInRound(1));
  //System.out.println(bracket.getNumberOfMatchesInRound(2));
  //System.out.println(bracket.getNumberOfMatchesInRound(3));
  //System.out.println(bracket.getNumberOfMatchesInRound(4));
  
//  double L2 = log(4,2);
//  
//  int initalRounds = (int)Math.ceil(L2);
//  
//  int surplusRounds = (int)(Math.ceil(log((int)L2,2)));
//  int totalRounds = initalRounds + surplusRounds; 
//  
  
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

 

  
  

  

 }

}
