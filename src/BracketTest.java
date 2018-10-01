

import java.util.ArrayList;
import java.lang.*;

class BracketTest {
  
   static double log(int x, int base) {
     return (double) (Math.log(x) / Math.log(base));
 }

 public static void main(String[] args) {

  ArrayList<Team> teams = new ArrayList<Team>();
  DoubleGenerator generator;

  
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


  String[][] thing = bracket.getTeamsInMatch(3, 1);

  System.out.println();
  

  System.out.println("Top:");
  for (int i = 0; i < thing[0].length; i++) {
	  System.out.println(thing[0][i]);
  }
  
  System.out.println();

  System.out.println("Bottom:");
  for (int i = 0; i < thing[1].length; i++) {
	  System.out.println(thing[1][i]);
  }

  
\  
  

 }

}
