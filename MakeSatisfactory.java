import java.util.Arrays;
import java.util.Scanner;

public class MakeSatisfactory{

    public MakeSatisfactory(){}

    public Bin[] makeMatches(Company[] companyArray, Programmer[] programmerArray){
        //System.out.println("Initializing bin array and filling");
      Bin[] binArray = new Bin[companyArray.length];
      //Bin[][] possiblePairings = findPossiblePairings(companyArray, programmerArray);

      // Fill bin with first preference, companies are static
      for (int i = 0; i < companyArray.length; i++) {
          binArray[i] = new Bin(companyArray[i], companyArray[i].getProgrammerPreferences()[0]);
      }

      //System.out.println("Doing initial check for duplicates");
      Bin[][] problemPairs = new Bin[companyArray.length][2];
      boolean prefCheck = checkDuplicates(binArray, problemPairs);

      while(prefCheck){
          //System.out.println("Fixing duplicates");
          fixDuplicate(problemPairs);
          problemPairs = new Bin[companyArray.length][2];
          //System.out.println("Checking for new duplicates");
          prefCheck = checkDuplicates(binArray, problemPairs);
      }

      //System.out.println("Checking if the pairings are satisfactory and fixing otherwise");
      checkAndMakeSatisfactory(binArray);

      return binArray;
    }

    private void checkAndMakeSatisfactory(Bin[] pairings){
        boolean needsChecking = true;
        while(needsChecking) {
            needsChecking = false;
            for (int i = 0; i < pairings.length; i++) {
                for (int j = i + 1; j < pairings.length; j++) {
                    if (checkNotSatisfactory(pairings[i], pairings[j])) {
                        makeSatisfactory(pairings[i], pairings[j]);
                        needsChecking = true;
                    }
                }
            }
        }
    }

    private void makeSatisfactory(Bin pairingOne, Bin pairingTwo){
      Programmer tempProgrammer = pairingOne.getProgrammer();
      pairingOne.setProgrammer(pairingTwo.getProgrammer());
      pairingTwo.setProgrammer(tempProgrammer);
    }

    public Boolean checkNotSatisfactory(Bin pairingOne, Bin pairingTwo){
      int programmerOneCompanyOne = Arrays.asList(pairingOne.getProgrammer().getCompanyPreference()).indexOf(pairingOne.getCompany());
      int programmerOneCompanyTwo = Arrays.asList(pairingOne.getProgrammer().getCompanyPreference()).indexOf(pairingTwo.getCompany());
      int companyTwoProgrammerOne = Arrays.asList(pairingTwo.getCompany().getProgrammerPreferences()).indexOf(pairingOne.getProgrammer());
      int companyTwoProgrammerTwo = Arrays.asList(pairingTwo.getCompany().getProgrammerPreferences()).indexOf(pairingTwo.getProgrammer());

      return ((programmerOneCompanyOne > programmerOneCompanyTwo) && (companyTwoProgrammerOne > companyTwoProgrammerTwo));
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
          if(problemPairs[i][0] == null){
              break;
          }

          // Sets second of each duplicate to the next companies desired programmer
          problemPairs[i][1].setProgrammer(problemPairs[i][1].getCompany().getNextProgrammer());
      }
  }

  public static void main(String[] args){

      MakeSatisfactory run = new MakeSatisfactory();

      Company A = new Company("A");
      Company B = new Company("B");
      Company C = new Company("C");

      Programmer One = new Programmer("One");
      Programmer Two = new Programmer("Two");
      Programmer Three = new Programmer("Three");

      A.setProgrammerPreferences(new Programmer[] {Two,Three,One});
      B.setProgrammerPreferences(new Programmer[] {One,Two,Three});
      C.setProgrammerPreferences(new Programmer[] {One,Three,Two});

      One.setCompanyPreference(new Company[] {A,C,B});
      Two.setCompanyPreference(new Company[] {B,C,A});
      Three.setCompanyPreference(new Company[] {C,A,B});

      Company[] companyArray = new Company[] {A, B, C};
      Programmer[] programmerArray = new Programmer[] {One, Two, Three};

      Bin[] satisfactoryMatches = run.makeMatches(companyArray, programmerArray);

      for(int i = 0; i < satisfactoryMatches.length; i++) {
          System.out.println(satisfactoryMatches[i].getCompany().getName() + " and " + satisfactoryMatches[i].getProgrammer().getName());
      }
  }

}