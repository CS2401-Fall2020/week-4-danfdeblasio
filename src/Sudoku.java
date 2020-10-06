
public class Sudoku {
  private int[][] board;
  
  public Sudoku() {
    board = new int[9][9];
    for(int i=0; i<9; i++) {
      for(int j=0; j<9; j++) {
        board[i][j] = -1 * (9 * i) - j;
      }
    }
  }
  
  public boolean checkBoard() {
    boolean okaySoFar = true;
    //check rows
    for(int i=0; i<9; i++) {
      okaySoFar &= extractAndTest.noneTrue(
        searchAndPrint.gridOfMultiples(
         extractAndTest.extractSubArray(board, i, i, 0, 8)
        )
       );
    }
    
    //check columns
    for(int j=0; j<9; j++) {
      okaySoFar &= extractAndTest.noneTrue(
         searchAndPrint.gridOfMultiples(
          extractAndTest.extractSubArray(board, 0, 8, j, j)
         )
        );
    }
    
    //check sub grids
    for(int i=0; i<9; i+=3) {
      for(int j=0; j<9; j+=3) {
        okaySoFar &= extractAndTest.noneTrue(
          searchAndPrint.gridOfMultiples(
           extractAndTest.extractSubArray(board, i, i+2, j, j+2)
          )
         );
      }
    }
    return okaySoFar;
  }
  
  public boolean setLocation(int x, int y, int value) {
    board[x][y] = value;
    if(checkBoard()) return true;
    
    board[x][y]= -1 * (9 * x) - y;
    return false;
  }
  
  public int[] possibleValues(int x, int y) {
    if(board[x][y] > 0) return null;
    boolean[] valid = new boolean[10];
    int countValid = 0;
    for(int i=1; i<=9; i++) {
      board[x][y] = i;
      valid[i] = checkBoard();
      if(valid[i]) {
        countValid++;
      }
    }
    board[x][y] = -1 * (9 * x) - y;
    int[] rtn = new int[countValid];
    int index = 0;
    for(int i=1; i<=9; i++) {
     if(valid[i]) {
       rtn[index++] = i;
     }
    }
    return rtn;
  }
}
