public class DoubleBracket extends Bracket{
  
  

 @Override
 int getNumberOfTeams() {
  // TODO Auto-generated method stub
  return 6;
 }

 @Override
 int getNumberOfRounds() {
  // TODO Auto-generated method stub
  return 6;
 }

 @Override
 int getNumberOfMatchesInRound(int round) {
  // TODO Auto-generated method stub
  return 0;
 }

 @Override
 String[][] getTeamsInMatch(int round, int matchNumber) {
  // TODO Auto-generated method stub
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
