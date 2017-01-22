/*		This is a support class for the Project Bomber.  This class represents a 2D array of integers that controls
 *	the amount of blue on the screen.
 *
 */

public class IntMatrix 
{
	private int[][] matrix;
    
    public IntMatrix(int size) 
    {
        matrix = new int[size][size];
    }
    
    /*	Set all locations in the grid to a value
     */
    public void fill(int value)
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length;j++)
            {
                matrix[i][j] = value;
            }
        }
    }
    
    /*	Access spot in the int[][]
     */
    public int get(int r, int c)
    {
        return matrix[r][c];
    }
    
    /*		This method recieves a 2D array from the Graphical game.  Each slot in the array has an integer in it.
     *	The int in each slot of the array is subtracted from the current values in matrix.
     *
     *	Example:
     *		Matrix 10 10 10 10		blast 0 1 2		clickRow= 1  clickCol = 3
     *			   10 10 10 10			  0 1 1
     *			   10 10 10 10			  0 0 0 
     *			   10 10 10 10 
     *		result:
     *			   10 10  9  8
     *			   10 10  9  9
     *			   10 10 10 10
     *			   10 10 10 10
     *
     *	@param blast		A 2D array that detemrines the pattern of the weapon.  
     *	@param clickRow		The row (first []) that the user clicked on
     *	@param clickCol		The column (second[]) that the user clicked on
     *
     *	@return 			The turn scores 10 points for any cell changed or 20 points for getting down to 0.
     */
    public int applySpread(int[][] blast, int clickRow, int clickCol)
    {
        int score =0;
        //find where the will the matrix ends
        int endRow = clickRow+(blast.length/2);
        int endCol = clickCol+(blast[0].length/2);
        int blastRow =0;
        int blastCol =0;

        for(int row = clickRow-(blast.length/2);row<=endRow; row++)
        {
            for(int col = clickCol-(blast[0].length/2); col<=endCol; col++)
            {
                if(isValid(row,col))
                {
                    matrix[row][col] -= blast[blastRow][blastCol];
                    score+=10;
                }
                blastCol++;
            }
            blastCol=0;
            blastRow++;
        }
        return score;
    }
    
    /*	Helper method to check if coordinate is in bounds of grid
     *	@return 	True if the slot [r][c] is a valid spot in the array matrix
     */
    private boolean isValid(int r, int c)
    {
        return r<matrix.length&&c<matrix[matrix.length-1].length;
    }

}
