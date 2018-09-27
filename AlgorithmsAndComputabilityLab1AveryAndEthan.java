import node_helper.IntNode.*;
import java.util.Arrays;

class NPermutations {
   long[][] outputArray;
  int nextOutputIndex = 0;
  int numberOfElements;

  public NPermutations(){}

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    NPermutations program = new NPermutations();
    program.entryPoint(Integer.parseInt(args[0]));
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
  }

  public void entryPoint(int n){
    numberOfElements = n;
    long numberOfPermutations = factorial(numberOfElements);
    outputArray = new long[(int) numberOfPermutations][numberOfElements];

    int[] initialArray = generateInitialArray();

    node_helper.IntNode zeroIntNode = new node_helper.IntNode(0, null);
    recursionInsanity(zeroIntNode, initialArray);
    for (long[] permutation : outputArray) {
      System.out.println(Arrays.toString(permutation));
    }
  }

  private void recursionInsanity(node_helper.IntNode parent, int[] remainingElements){

    // base case
    if (remainingElements.length == 0){
      outputArray[nextOutputIndex] = getPermutation(parent, new long[numberOfElements], 0);
      nextOutputIndex++;
    }

    else {
      for(int element : remainingElements){
        int[] smallerArray = new int[remainingElements.length-1];
        node_helper.IntNode node = new node_helper.IntNode(element, parent);

        // create array without current element
        int smallCounter = 0;
        for (int i = 0; i < remainingElements.length; i++) {
          if(remainingElements[i] != element) {
            smallerArray[smallCounter] = remainingElements[i];
            smallCounter++;
          }
        }
        recursionInsanity(node, smallerArray);
      }
    }

  }

  private int[] generateInitialArray(){
    int[] result = new int[numberOfElements];

    for(int i = 0; i < numberOfElements; i++){
      result[i] = i + 1;
    }
    return result;
  }

  private long[] getPermutation(node_helper.IntNode leaf, long[] values, int index){
    if(leaf.getParent() == null) {
      return values;
    }
    else {
      values[index] = leaf.getValue();
      return getPermutation(leaf.getParent(), values, index + 1);
    }
  }

  //TODO: implement factorial
  private long factorial(int n) {
    long product = 1;
    for(int i = n; i > 1; i--){
      product = product * i;
    }
    return product;
  }

}
