

import java.util.ArrayList;
import java.lang.*;

class BracketTest {
  
   static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }

 public static void main(String[] args) {

  ArrayList<Team> teams = new ArrayList<Team>();
  DoubleGenerator generator;

  for (int i = 0; i < 8; i++) {
   teams.add(new Team(Integer.toString(i)));
  }
  
  generator = new DoubleGenerator(teams);

  DoubleBracket bracket = (DoubleBracket)generator.getBracket();

  
  
   //void setMatchWinner(String teamName, int roundNum, int matchNumber) {  
  for(int i = 0; i<4; i++){
    bracket.setMatchWinner(Integer.toString(i*2), 1, i+1);
  }
  
 
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


  
  
 

   

  
  System.out.println();
  System.out.println(bracket.getNumberOfRounds());
  System.out.println(bracket.getNumberOfMatchesInRound(1));
  System.out.println(bracket.getMatchBracket(1,2));
  
  System.out.println(bracket.getNumberOfMatchesInRound(2));
  
  

 }

}
