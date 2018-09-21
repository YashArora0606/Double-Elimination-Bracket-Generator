import java.util.ArrayList;

public class DoubleGenerator extends Generator{
  
	DoubleBracket bracket;
 
 DoubleGenerator(ArrayList<Team> teams) {
  bracket = new DoubleBracket(teams);
  
 }


 @Override
 Bracket getBracket() {
	 return bracket;
 
 
 }
 


}
