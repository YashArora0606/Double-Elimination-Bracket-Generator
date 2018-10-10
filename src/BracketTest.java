import java.util.ArrayList;

class BracketTest {

	static double log(int x, int base) {
		return (double) (Math.log(x) / Math.log(base));
	}
	
	static void printTeams(String[][] t) {
		for (int i = 0; i < t[0].length; i++) {
			System.out.println(t[0][i]);
		}
		System.out.println("----");
		for (int i = 0; i < t[1].length; i++) {
			System.out.println(t[1][i]);
		}
		System.out.println();

	}

	public static void main(String[] args) {
		
		ManagementSystem managementSystem = new ManagementSystem();	

		
	
//		ArrayList<Team> teams = new ArrayList<Team>();
//		int numTeamsMade = 5;
//
//		for (int i = 0; i < numTeamsMade; i++) {
//			teams.add(new Team(Character.toString(((char) (65 + i))), (i + 1)));
//		}
//		
//
//		
//		boolean seed = false; 
//		DoubleGenerator generator = new DoubleGenerator(teams, seed);
//		DoubleBracket bracket = (DoubleBracket) generator.getBracket();
//		
//		bracket.setMatchWinner("D", 1, 1);
//		
//		
//		System.out.println("winnerRound1 " + bracket.round.get(0));
//		System.out.println("winnerRound2 " + bracket.round.get(1));
//		System.out.println("winnerRound3 " + bracket.round.get(2));
//		System.out.println("winnerRound4 " + bracket.round.get(3));
//		System.out.println("winnerRound5 " + bracket.round.get(4));
//
//		System.out.println("loserRound " + bracket.loserRound.get(0));
//		System.out.println("loserRound2 " + bracket.loserRound.get(1));
//		System.out.println("loserRound3 " + bracket.loserRound.get(2));
//		System.out.println("loserRound4 " + bracket.loserRound.get(3));
//		System.out.println("loserRound5 " + bracket.loserRound.get(4));
////		
//		
//		
//		printTeams(bracket.getTeamsInMatch(2,2));

//		System.out.println(bracket.getMatchBracket(1, 1));


		
		//System.out.println("THING " + bracket.getNumberOfMatchesInRound(1));
		//printTeams(bracket.getTeamsInMatch(1, 5));
		
		//System.out.println(bracket.getNumberOfMatchesInRound(1));
		
	/*

		bracket.setMatchWinner("A", 1, 1);
		//bracket.setMatchWinner("C", 1, 2);

		// UNCOMMENT IN JUST A BIT

		System.out.println("winnerRound1 " + bracket.round.get(0));
		System.out.println("winnerRound2 " + bracket.round.get(1));
		System.out.println("winnerRound3 " + bracket.round.get(2));
		System.out.println("winnerRound4 " + bracket.round.get(3));

		System.out.println("loserRound " + bracket.loserRound.get(0));
		System.out.println("loserRound2 " + bracket.loserRound.get(1));
	System.out.println("loserRound3 " + bracket.loserRound.get(2));
	System.out.println("loserRound4 " + bracket.loserRound.get(3));
	
	System.out.println(bracket.getNumberOfTeams());
	System.out.println("");
	printTeams(bracket.getTeamsInMatch(2, 1));
	
//	 System.out.println(bracket.getNumberOfRounds());
//	 
//	 // THIS IS THE ERROR


*/
		 //System.out.println(bracket.getNumberOfMatchesInRound(1));


  




	}
}
