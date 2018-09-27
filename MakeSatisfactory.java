public class MakeSatisfactory{

  NPermutations permutationGenerator = new NPermutations;

  public String[] makeMatches(Company[] companyArray, Programmer[] programmerArray){
    Bin[][] result = findPossiblePairings(companyArray, programmerArray);


  }

  private Bin[][] findPossiblePairings(Company[] companyArray, Programmer[] progammerArray){
    Bin[][] combinedArray = new Bin[factorial(companyArray.length)][companyArray.length];

    int[][] permutatedProgrammers = (int)permutationGenerator.entryPoint(programmerArray.length);

    for(int i = 0; i < permutatedProgrammers.length; i++){
      Bin[] tempBin;
      for(int j = 0; j < companyArray.length; j++){
        tempBin[j] = new Bin(companyArray[j], permutatedProgrammers[i][j]);
      }
      combinedArray[i] = tempBin;
    }
    return combinedArray;
  }

  private Boolean checkSatisfactory(){

  }

  private int[] checkPreferenceDif(){

  }

  private int factorial(int n){
    int result = 1;
    for(int i = n; n > 1; i--){
      result = result * i;
    }
    return result;
  }

  public static void main(String[] args){
    Company A = new Company(new String[] = {"Two","Three","One"});
    Company B = new Company(new String[] = {"One","Two","Three"});
    Company C = new Company(new String[] = {"One","Three","Two"});
    //Company D = new Company(new String[] = {"One","Three","Two","Four","Five"});
    //Company E = new Company(new String[] = {"Two","Three","Five","Four","One"});

    Programmer One = new Programmer(new char[] = {'A','C','B'});
    Programmer Two = new Programmer(new char[] = {'B','C','A'});
    Programmer Three = new Programmer(new char[] = {'C','A','B'});
    //Programmer Four = new Programmer(new char[] = {'C','B','D','A','E'});
    //Programmer Five = new Programmer(new char[] = {'A','D','B','C','E'});

    Company[] companyArray = {A,B,C
      //,D,E
    };
    Programmer[] programmerArray = {One,Two,Three
      //,Four,Five
    };

    Bin[][] results = findPossiblePairings(companyArray, programmerArray);
    for(int i = 0; i < results.length; i++){
      String output = "";
      System.out.println("Permutation number " + i);
      for(int j = 0; j < results[i].length; j++){
        output = output + results[i][j].getCompany().toString() + results[i][j].getProgrammer().toString();
      }
      System.out.println(output);
    }

    //String[] result = makeMatches(companyArray, programmerArray);
  }

}