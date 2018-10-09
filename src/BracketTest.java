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
//		int numTeamsMade = 3;
//
//		for (int i = 0; i < numTeamsMade; i++) {
//			teams.add(new Team(Character.toString(((char) (65 + i))), (i + 1)));
//		}
//		boolean seed = true; 
//		DoubleGenerator generator = new DoubleGenerator(teams, true);
//		DoubleBracket bracket = (DoubleBracket) generator.getBracket();
//		
//		bracket.setMatchWinner("C", 1, 1);
//
//		bracket.setMatchWinner("A", 2, 1);
//
//		bracket.setMatchWinner("B", 2, 2);
//		
//		bracket.setMatchWinner("A", 1, 2);
		
//		printTeams(bracket.getTeamsInMatch(1, 1));
//		printTeams(bracket.getTeamsInMatch(1, 2));
//		printTeams(bracket.getTeamsInMatch(1, 3));
//		printTeams(bracket.getTeamsInMatch(1, 4));
//		printTeams(bracket.getTeamsInMatch(1, 5));
//		printTeams(bracket.getTeamsInMatch(1, 6));
//		printTeams(bracket.getTeamsInMatch(2, 1));
//		printTeams(bracket.getTeamsInMatch(2, 2));
//		printTeams(bracket.getTeamsInMatch(2, 3));
		
		//printTeams(bracket.getTeamsInMatch(3,2));



	 
	/*
	ArrayList<Team> teams = new ArrayList<Team>();
		DoubleGenerator generator;
	SingleGenerator singleGenerator;

	int numTeamsMade = 4;

		for (int i = 0; i < numTeamsMade; i++) {
			teams.add(new Team(Character.toString(((char) (65 + i))), (i + 1)));
		}
		

		
		boolean seed = true; 
		generator = new DoubleGenerator(teams, seed);


		DoubleBracket bracket = (DoubleBracket) generator.getBracket();
		
		bracket.setMatchWinner("A", 1, 1);
		bracket.setMatchWinner("B", 1, 2);
		
		bracket.setMatchWinner("A", 2, 1);
		
		bracket.setMatchWinner("D", 1, 3);
		
		bracket.setMatchWinner("D", 2, 2);
			 
		bracket.setMatchWinner("D", 3, 1);

		// UNCOMMENT IN JUST A BIT

		System.out.println("winnerRound1 " + bracket.round.get(0));
		System.out.println("winnerRound2 " + bracket.round.get(1));
		System.out.println("winnerRound3 " + bracket.round.get(2));
		System.out.println("winnerRound4 " + bracket.round.get(3));

		System.out.println("loserRound " + bracket.loserRound.get(0));
		System.out.println("loserRound2 " + bracket.loserRound.get(1));
	System.out.println("loserRound3 " + bracket.loserRound.get(2));
	System.out.println("loserRound4 " + bracket.loserRound.get(3));
	
	 System.out.println(bracket.getNumberOfRounds());
	 System.out.println(bracket.getNumberOfMatchesInRound(4));
*/

	


  




	}
}
