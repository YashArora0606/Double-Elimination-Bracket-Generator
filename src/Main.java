import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	
	public static int round = 0;

	public static ArrayList<Character> losers = new ArrayList<Character>();
	
	public static void main(String[] args) {
		
		 System.out.println((int)(Math.ceil(Math.log(5)/Math.log(2))));

		
		
//		ArrayList<Character> teams = new ArrayList<Character>();
//
//
//		teams.add('a');
//		teams.add('b');
//		teams.add('c');
//		teams.add('d');
//		teams.add('e');
//		teams.add('f');
//		teams.add('g');
//
//		
//
//		printRound(teams); // print bracket part 1
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//
//		for (int i = 0; i < losers.size(); i++) {
//			System.out.println(losers.get(i));
//		}


	
		
		
	}
	
	public static void printRound(ArrayList<Character> teams) {
		
		
		if (teams.size()%2 == 1 && teams.size() != 1) {
			teams.add(' ');
		}
		
		if (teams.size() == 1) {
			System.out.println(teams.get(0));
			
		} else {
		
			for (int i = 0; i < teams.size(); i++) {
				System.out.print(teams.get(i) + "\t");
			}
			
			

			
			
			
			System.out.println();
			
			
			Collections.reverse(teams);
			getRemainingTeams(teams);
			round++;

		}
		
		
		
		
	}
	
	public static void getRemainingTeams(ArrayList<Character> teams) {
		
		ArrayList<Character> teamsLeft= new ArrayList<Character>();
		for (int i = 0; i < Math.ceil((double) (teams.size()/2)); i++) {
			char winner = fight(teams.get(i*2), teams.get((i*2)+1));
			teamsLeft.add(winner);
		}
		
		//Collections.reverse(losers);
		
		
		if (round%2 == 0) {
			Collections.reverse(teamsLeft);
		}
		
		printRound(teamsLeft);
	}
	
	public static char fight(char team1, char team2) {
		
		if (team1 == ' ') {
			return team2;
		} else  if (team2 == ' ') {
			return team1;
		}
		
		
		if (team1 < team2) {
			losers.add(team2);
			return team1;
		} else {
			losers.add(team1);
			return team2;
		}
		
	
	}


	
}



