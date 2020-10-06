public class searchAndPrint{
  /* This method will take as input a full (all rows are of the same length) two dimensional integer array
     and return a two dimensional boolean array of the same size 
     where each element in the output is true if the value in that position occurs more than once in the total array
     and false otherwise. */
  public static boolean[][] gridOfMultiples(int[][] inputArray){
    boolean[][] outputGrid = new boolean[inputArray.length][inputArray[0].length];
    for(int i=0; i<inputArray.length; i++) {
      for(int j=0; j<inputArray[i].length; j++) {
        outputGrid[i][j] = searchForMultiple(inputArray, inputArray[i][j]);
      }
    }
    return outputGrid;
  }
  
  /* This method takes as input a full two dimensional boolean array
     and prints a grid to the screen where each element is represented as a "_" if the value is false and a "X" otherwise. */
  public static void printGrid(boolean[][] inputGrid){
    for(int i=0; i<inputGrid.length; i++) {
      for(int j=0; j<inputGrid[i].length; j++) {
        if(inputGrid[i][j]) {
          System.out.print("X");
        }else {
          System.out.print("_");
        }
      }
      System.out.print("\n");
    }
  }
  
  /* This method takes as input a two dimensional array and an integer
      returns a boolean which is true if the value is present in the array more than once. */
  public static boolean searchForMultiple(int[][] inputArray, int search){
    int count = 0; 
    for(int i=0; i<inputArray.length; i++) {
      for(int j=0; j<inputArray[i].length; j++) {
        if(inputArray[i][j] == search) {
          if(count > 0) return true;
          count++;
        }
      }
    }
    return false;
  }
}
