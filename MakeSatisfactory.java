public class MakeSatisfactory{

  public String[] makeMatches(Company[] companyArray, Programmer[] programmerArray){
      Bin[] binArray = new Bin[companyArray.length];
      //Bin[][] possiblePairings = findPossiblePairings(companyArray, programmerArray);

      // Fill bin with first preference, companies are static
      for (int i = 0; i < companyArray.length; i++) {
          binArray[i] = new Bin(companyArray[i], companyArray[i].getProgrammerPreferences()[1]);
      }

      Bin[][] problemPairs = new Bin[companyArray.length][2];
      boolean prefCheck = checkDuplicates(binArray, problemPairs);

      while(prefCheck){
          fixDuplicate(problemPairs);
          problemPairs = new Bin[companyArray.length][2];
          prefCheck = checkDuplicates(binArray, problemPairs);
      }

      if(!checkSatisfactory()){
          makeSatisfactory();
      }

  }

  private Boolean checkSatisfactory(){

  }

  //
  private boolean checkDuplicates(Bin[] binArray, Bin[][] problemPairs){
      int problemPairsIndex = 0;
      boolean prefCheck = false;

      //
      for(int i = 0; i < binArray.length; i++) {
          for (int j = i+1; j < binArray.length; j++) {
              if (binArray[i].getProgrammer() == binArray[j].getProgrammer()) {
                  problemPairs[problemPairsIndex][0] = binArray[i];
                  problemPairs[problemPairsIndex][1] = binArray[j];
                  prefCheck = true;
                  problemPairsIndex++;
              }
          }
      }
      return prefCheck;
  }

  private void fixDuplicate(Bin[][] problemPairs){
      //
      for(int i = 0; i < problemPairs.length; i++){
          if(problemPairs[i] == null){
              break;
          }

          // Sets second of each duplicate to the next companies desired programmer
          problemPairs[i][1].setProgrammer(problemPairs[i][1].getCompany().getNextProgrammer());
      }
  }

  public static void main(String[] args){
  }

}