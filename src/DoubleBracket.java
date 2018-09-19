public class DoubleBracket extends Bracket{
  
  

 @Override
 int getNumberOfTeams() {
  // HARD CODED
  return 3;
 }

 @Override
 int getNumberOfRounds() {
  // HARD CODED
  return 3;
 }

 @Override
 int getNumberOfMatchesInRound(int round) {
  // HARD CODED
	 
	 if (round == 1) {
		 return 1;
	 } else if (round == 2) {
		 return 2;
	 } else if (round == 3) {
		 return 1;
	 }
  return 0;
  
 }

 @Override
 String[][] getTeamsInMatch(int round, int matchNumber) {
	 
  if (round == 1) {
	  
	  if (matchNumber == 1) {
		  String[][] arr = new String[2][1];
		  arr[0][0] = "A";
		  arr[1][0] = "B";
		  return arr;
	  }
	  
  } else if (round == 2) {
	  
	  if (matchNumber == 1) {
		  String[][] arr = new String[2][2];
		  arr[0][0] = "A";
		  arr[0][1] = "B";
		  arr[1][0] = "C";
		  return arr;
	  }
	  
	  if (matchNumber == 2) {
		  String[][] arr = new String[2][3];
		  arr[0][0] = "A";
		  arr[0][1] = "B";
		  
		  arr[1][0] = "A";
		  arr[1][1] = "B";
		  arr[1][2] = "C";
		  return arr;
	  }
	  
  } else if (round == 3) {
	  if (matchNumber == 1) {
		  String[][] arr = new String[2][3];
		  arr[0][0] = "A";
		  arr[0][1] = "B";
		  arr[0][2] = "C";
		  
		  arr[1][0] = "A";
		  arr[1][1] = "B";
		  arr[1][2] = "C";
		  return arr;
	  }
  }
  return null;
 }

 @Override
 void setMatchWinner(String teamName, int round, int matchNumber) {
  // TODO Auto-generated method stub
  
 }
 
 @Override
 int getMatchBracket(int round, int matchNumber) {
   return 0; 
 }
 
 

}
