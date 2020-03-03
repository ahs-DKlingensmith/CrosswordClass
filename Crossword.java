/*
 * Crossword class
 */

public class Crossword {
    
    //Establish variables
    private Square[][] puzzle;
    
    /*
    * The constructor accepts a boolean 2D array to indicate which squares are
    * black and white before determining and labeling the white squares with the
    * appropriate number
    */
    public Crossword(boolean[][] blackSquares)  {
        
        puzzle = new Square[blackSquares.length][blackSquares[0].length];
        
        int trackPositiveNumber = 0;
        
        for (int row = 0; row < puzzle.length; row++)   {
            for (int col = 0; col < puzzle[0].length; col++)    {
                
                boolean isBlack = true;
                int number = 0;
                
                if (blackSquares[row][col]) {
                    isBlack = true;
                    number = 0;
                } else if ((blackSquares[row - 1][col] || blackSquares[row][col-1])
                        || (row == 0 || col == 0))  {
                    isBlack = false;
                    trackPositiveNumber++;
                    number = trackPositiveNumber;
                }
                
                puzzle[row][col] = new Square(isBlack, number);
                
            }
        }
    }
    
    /*
    * The toBeLabeled method accepts the paramters for a specific square and 
    * determines if the square should be labeled with a positive number
    */
    public boolean toBeLabeled(int r, int c, boolean[][] blackSquares)  {
        
        if ((r < 0 || r > blackSquares.length) || (c < 0 || c > blackSquares[0].length))    {
            return false;
        }
        
        if (blackSquares[r][c]) {
            return false;
        } else {
            if ((blackSquares[r-1][c] || blackSquares[r][c-1])
                    || (r == 0 || c == 0))   {
                return true;
            } else {
                return false;
            }
        }
    }
}
