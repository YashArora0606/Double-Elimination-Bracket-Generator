import java.util.ArrayList;

public class DoubleGenerator extends Generator{
  
 private Bracket bracket;
 
 DoubleGenerator(ArrayList<Team> teams) {
   //Team [][] winnerBracker = new Team[bracket.getNumberOfTeams()][bracket.getNumberOfTeams()];
	 bracket = this.getBracket();
	 
	 logic((DoubleBracket) bracket);
 }

 @Override
 Bracket getBracket() {
  return new DoubleBracket();
 }
 
 public 	void logic(DoubleBracket bracket) {
	 
	 
	 
 }
 


}
