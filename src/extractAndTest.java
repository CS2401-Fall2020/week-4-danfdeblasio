
public class extractAndTest {
  public static int[][] extractSubArray(int[][] inArray, int rowMin, int rowMax, int colMin, int colMax){
    if(rowMin > rowMax) return null;
    if(colMin > colMax) return null;
    if(rowMax >= inArray.length) return null;
    if(rowMin < 0) return null;
    if(colMin < 0) return null;
    for(int i=rowMin; i<=rowMax; i++) {
      if(colMax >= inArray[i].length) return null;
    }
    
    int[][] rtn = new int[rowMax-rowMin+1][colMax-colMin+1];
    for(int i=0; i<=(rowMax-rowMin); i++) {
      for(int j=0; j<=(colMax-colMin); j++) {
        rtn[i][j] = inArray[rowMin+i][colMin+j];
      }
    }
    
    return rtn;
  }
  
  public static boolean noneTrue(boolean[][] inArray) {
    boolean haveNotFoundTrue = true;
    for(int i=0; i<inArray.length; i++) {
      for(int j=0; j<inArray[i].length; j++) {
        haveNotFoundTrue &= !inArray[i][j];
      }
    }
    return haveNotFoundTrue;
  }
}
