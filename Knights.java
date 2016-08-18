//Milind Pathiyal

//Chessboard- Knights
//Place as many knights as possible on the chessboard by following the actions of knight
import java.util.*;
import java.io.*;
public class Knights
{
    private final int ROWS = 8;
    private final int COLS = 8;

    private int[] move_x = {1, 2, 2, 1, -1, -2, -2, -1}; // possible moves (x-axis)
    private int[] move_y = {2, 1, -1, -2, -2, -1, 1, 2}; // possible moves (y-axis)
    private int[][] chessBoard = new int[ROWS][COLS];
    //Pre:NONE
    //Post:DEFAULT BOARD SETTING
    public void driver()
    {
        chessBoard[0][0] = 1; //1ST KNIGHT IS PLACED AT [0][0]
        plantKnight(0, 0, 2); //SETUP FOR plantKnight()
    }
    //Pre:NONE
    //Post: FINDS IF A CELL IS A VALID CELL
    public boolean isCellValid( int row, int col)
    {
        if( row < 8 && col < 8 && row > -1 && col > -1 && chessBoard[row][col] == 0) 
        {
            return true;//RETURNS TRUE IF CELL IS INBOUNDS AND EMPTY
        }
        return false;
    }
    //Pre:ALL VARIABLES MUST EXIST AND THERE MUST BE A VALID SPOT FOR KNIGHT TO DROPPED INTO
    //Post:PLACES KNIGHT INTO CELL AND PRINTS OUT CHESSBOARD
    public void plantKnight(int row, int col, int ranking)
    {
        if(ranking != 65)
        {
            for(int x = 0; x < 8; x++)
            {
                if(isCellValid(row + move_x[x], col + move_y[x]))
                {
                    chessBoard[row + move_x[x]][col + move_y[x]] = ranking;
                    //PLANTS ranking IN NEW LOCATION
                    plantKnight(row + move_x[x], col + move_y[x], ranking + 1);
                    //RECURSIVE CALL ALLOWS ranking TO GO THROUGH UNTIL ALL 64 CELLS ARE USED
                    chessBoard[row + move_x[x]][col + move_y[x]] = 0;
                    //VALID CELL
                }
            }
        }
        else
        {
            //ONCE RANKING HAS REACHED MAXIMUM CELL COUNT --> PRINT BOARD
            for(int i = 0; i < ROWS; i++)
            {
                System.out.println();
                for(int j = 0; j < COLS; j++)
                {
                    System.out.print(chessBoard[i][j] + "|");
                }
            } 
        }
    }
}
/*
1|38|59|36|43|48|57|52|
60|35|2|49|58|51|44|47|
39|32|37|42|3|46|53|56|
34|61|40|27|50|55|4|45|
31|10|33|62|41|26|23|54|
18|63|28|11|24|21|14|5|
9|30|19|16|7|12|25|22|
64|17|8|29|20|15|6|13|
ANSWER TO BOARD QUESTION: 9223372036854775808
etc.
 */

