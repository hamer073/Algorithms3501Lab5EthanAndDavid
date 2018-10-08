import java.io.File;
import java.io.FileNotFoundException;
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

    private Boolean checkNotSatisfactory(Bin pairingOne, Bin pairingTwo){
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

    public static void main(String[] args) throws FileNotFoundException {

        // Reading input from a file for this needs quite a bit of setup

        Scanner sc = new Scanner(new File(args[0]));
        MakeSatisfactory run = new MakeSatisfactory();

        // First we get the number of companies and programmers
        // This is not a combined value, so it can be read as just the number of companies or just the number of programmers
        int n = sc.nextInt();
        sc.nextLine();

        // Setting up the company and programmer arrays that we'll pass to the main function
        // as well as a couple of arrays to keep track of the preferences
        Company[] companies = new Company[n];
        String[][] companyPreferences = new String[n][n];
        Programmer[] programmers = new Programmer[n];
        String[][] programmerPreferences = new String[n][n];

        // This populates the company array with all the new companies
        // As well as the company preference array for each company
        for (int i = 0; i < n; i++) {
            companies[i] = new Company(sc.next());
            for (int j = 0; j < n; j++) {
                companyPreferences[i][j] = sc.next();
            }
        }

        // This loop does the same as the above except this one is working on programmers and their preferences
        for (int i = 0; i < n; i++) {
            programmers[i] = new Programmer(sc.next());
            for (int j = 0; j < n; j++) {
                programmerPreferences[i][j] = sc.next();
            }
        }

        // A couple lines for debugging
        /*System.out.println(Arrays.toString(companies));
        for (String[] preferences : companyPreferences) {
            System.out.println(Arrays.toString(preferences));
        }

        System.out.println(Arrays.toString(programmers));
        for (String[] preferences : programmerPreferences) {
            System.out.println(Arrays.toString(preferences));
        }*/

        // Now we need to match up the company preferences with programmers
        // And the programmer preferences with companies
        for (int i = 0; i < n; i++) {
            Company currentCompany = companies[i];
            String[] currentCompanyPreferences = companyPreferences[i];
            Programmer[] tempProgrammers = new Programmer[n];

            Programmer currentProgrammer = programmers[i];
            String[] currentProgrammerPreferences = programmerPreferences[i];
            Company[] tempCompanies = new Company[n];

            for (int j = 0; j < n; j++) {
                boolean notFound = true;
                int programmerIndex = 0;

                while (notFound) {
                    if (currentCompanyPreferences[j].equals(programmers[programmerIndex].getName())) {
                        tempProgrammers[j] = programmers[programmerIndex];
                        notFound = false;
                    } else {
                        programmerIndex++;
                    }
                }
                currentCompany.setProgrammerPreferences(tempProgrammers);
            }

            for (int j = 0; j < n; j++) {
                boolean notFound = true;
                int companyIndex = 0;

                while (notFound) {
                    if (currentProgrammerPreferences[j].equals(companies[companyIndex].getName())) {
                        tempCompanies[j] = companies[companyIndex];
                        notFound = false;
                    } else {
                        companyIndex++;
                    }
                }
                currentProgrammer.setCompanyPreference(tempCompanies);
            }
        }

        // Now we should be able to pass the company and programmer arrays to the top level method and get a correct output
        Bin[] satisfactoryMatches = run.makeMatches(companies, programmers);

        for(Bin pairing : satisfactoryMatches) {
            System.out.println(pairing.getCompany().getName() + " and " + pairing.getProgrammer().getName());
        }

    }

}