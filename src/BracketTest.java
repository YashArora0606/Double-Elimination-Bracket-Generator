import java.util.ArrayList;

class BracketTest {

	static double log(int x, int base) {
		return (double) (Math.log(x) / Math.log(base));
	}

	public static void main(String[] args) {

		ArrayList<Team> teams = new ArrayList<Team>();
		DoubleGenerator generator;
		// SingleGenerator singleGenerator;

		int numTeamsMade = 7;

		for (int i = 0; i < numTeamsMade; i++) {
			teams.add(new Team(Character.toString(((char) (65 + i))), (i + 1)));
		}

		// generate without seeds

		// generator = new DoubleGenerator(teams,false);
		// generate with seeds
		
		boolean seed = true; 
		generator = new DoubleGenerator(teams, seed);

		/*
		for (int i = 0; i < teams.size(); i++) {
			System.out.println(teams.get(i).getName() + " " +teams.get(i).getSeed());
		}
		
		*/
		// singleGenerator = new SingleGenerator(teams, false);

		DoubleBracket bracket = (DoubleBracket) generator.getBracket();
		// SingleBracket singleBracket = (SingleBracket)singleGenerator.getBracket();

		ManagementSystem managementSystem = new ManagementSystem();
		

		Display disp = new Display(bracket);


		
//		bracket.setMatchWinner("E", 1, 1);
//		bracket.setMatchWinner("F", 1, 2);
//		bracket.setMatchWinner("G", 1, 3);
//		
//		bracket.setMatchWinner("F", 2, 2);
//		bracket.setMatchWinner("A", 2, 1);
//		
//		bracket.setMatchWinner("F", 3, 1);
//		
//		bracket.setMatchWinner("C", 1, 4);
//		
//		bracket.setMatchWinner("D", 2, 3);
//		bracket.setMatchWinner("C", 2, 4);
//		bracket.setMatchWinner("D", 3, 2);
//		bracket.setMatchWinner("D", 4, 1);
//		
//		bracket.setMatchWinner("D", 4, 1);
//		
//		bracket.setMatchWinner("D", 5, 1);
		
	   /*
		 bracket.setMatchWinner("H", 1, 1);
		 
		 
		  bracket.setMatchWinner("E", 2, 3);
		  bracket.setMatchWinner("G", 2, 4);
		  bracket.setMatchWinner("A", 2, 1);
		  bracket.setMatchWinner("C", 2, 2);
		  
		  
		  bracket.setMatchWinner("I", 2, 5);
		  
		  bracket.setMatchWinner("E", 3, 2); 
		  bracket.setMatchWinner("A", 3, 1);
		  
		  
		  bracket.setMatchWinner("F", 3, 4); 
		  bracket.setMatchWinner("B", 3, 3);
		  
		  
		  bracket.setMatchWinner("C", 4, 2); 
		  bracket.setMatchWinner("G", 4, 3);
		  
		  bracket.setMatchWinner("C", 5, 1);
		  
		  bracket.setMatchWinner("A", 4, 1);
		  
		  bracket.setMatchWinner("C", 6, 1);
		  
		 bracket.setMatchWinner("A", 5, 1);
		 */
		 

		// 8 teams
		/*
		 * bracket.setMatchWinner(Integer.toString(1), 1, 5);
		 * bracket.setMatchWinner(Integer.toString(5), 1, 6);
		 * 
		 * bracket.setMatchWinner(Integer.toString(0), 2, 1);
		 * bracket.setMatchWinner(Integer.toString(4), 2, 2);
		 * 
		 * bracket.setMatchWinner(Integer.toString(1), 2, 3);
		 * bracket.setMatchWinner(Integer.toString(6), 2, 4);
		 * 
		 * bracket.setMatchWinner(Integer.toString(0), 3, 1);
		 * 
		 * 
		 * 
		 * bracket.setMatchWinner(Integer.toString(1), 3, 2);
		 * bracket.setMatchWinner(Integer.toString(6), 3, 3);
		 * bracket.setMatchWinner(Integer.toString(1), 4, 1);
		 * bracket.setMatchWinner(Integer.toString(1), 6, 1);
		 * bracket.setMatchWinner(Integer.toString(0), 7, 1);
		 */

		// 3 teams
		// bracket.setMatchWinner(Integer.toString(0), 0, 1);

		// UNCOMMENT IN JUST A BIT

//		System.out.println("winnerRound1 " + bracket.round.get(0));
//		System.out.println("winnerRound2 " + bracket.round.get(1));
//		System.out.println("winnerRound3 " + bracket.round.get(2));
//		System.out.println("winnerRound4 " + bracket.round.get(3));
//		System.out.println("winnerRound5 " + bracket.round.get(4));
//		System.out.println("winnerRound6 " + bracket.round.get(5));
//		//System.out.println("winnerRound7 " + bracket.round.get(6));
//
//		System.out.println("loserRound " + bracket.loserRound.get(0));
//		System.out.println("loserRound2 " + bracket.loserRound.get(1));
//		System.out.println("loserRound3 " + bracket.loserRound.get(2));
//		System.out.println("loserRound4 " + bracket.loserRound.get(3));
//		System.out.println("loserRound5 " + bracket.loserRound.get(4));
//		System.out.println("loserRound6 " + bracket.loserRound.get(5));
		//System.out.println("loserRound7 " + bracket.loserRound.get(6));
		// System.out.println("loserRound8 " + bracket.loserRound.get(7));

		/*
		 * System.out.println("winnerRound4 " + bracket.round.get(3));
		 * System.out.println("loserRound4 " + bracket.loserRound.get(3));
		 * System.out.println("winnerRound5 " + bracket.round.get(4));
		 * System.out.println("loserRound5 " + bracket.loserRound.get(4));
		 * 
		 */

		/*
		 * System.out.println("winnerRound6 " + bracket.round.get(5));
		 * System.out.println("loserRound6 " + bracket.loserRound.get(5));
		 * System.out.println("final Round2 " + bracket.finalRound[0] + " , " +
		 * bracket.finalRound[1] ); System.out.println("winnerRound7 " +
		 * bracket.round.get(6)); System.out.println("loserRound7 " +
		 * bracket.loserRound.get(6)); System.out.println("");
		 */

		/*
		 * System.out.println(); 
		 * System.out.println(bracket.getNumberOfMatchesInRound(1));
		 * System.out.println(bracket.getMatchBracket(1,2));
		 */
		
//		System.out.println(bracket.getNumberOfRounds());
//		System.out.println(bracket.getNumberOfMatchesInRound(2));
//		System.out.println(bracket.getTournamentWinner());

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
  
		
//		  System.out.println();
//
//  
//  String[][] teamsInMatch = bracket.getTeamsInMatch(6,2);
//  
//  
//  
//  for (int i = 0; i < teamsInMatch[0].length; i++) {
//	  System.out.println(teamsInMatch[0][i]);
//  }
//  
//  System.out.println("VS.");
//
//  
//  for (int i = 0; i < teamsInMatch[1].length; i++) {
//	  System.out.println(teamsInMatch[1][i]);
//  }
 

  




	}
}
