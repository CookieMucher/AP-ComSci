/**
 * Created by HHUANG on 1/27/2017.
 */
public class APCS_506_EightQueens
{
    public static void main(String[] Theory)
    {
        int [][] DisHard= new int[8][8];

        if(queens(DisHard,0))
        {
            printer(DisHard);
        }
    }

    public static boolean isSafe(int[][] table, int row, int col)
    {
        //only need to check the left side of the board

        //row check
        for (int i = 0; i < col; i++)
            if (table[row][i] == 1)
                return false;

        int a,b;


        //diagonal check
        for (a=row, b=col; a>=0 && b>=0; a--, b--)
            if (table[a][b] == 1)
                return false;
        for (a=row, b=col; b>=0 && a<table.length; a++, b--)
            if (table[a][b] == 1)
                return false;

        return true;
    }

    // int [row] [col]

    public static boolean queens(int[][] table, int col)
    {
        if(col==table[0].length)
        {
            return true;
        }

        for (int i=0; i<table.length; i++)
        {
            if(isSafe(table,i,col))
            {
                table[i][col] = 1;
                if(queens(table, col+1))
                    return true;
                table[i][col] = 0;
            }
        }
        return false;
    }

    public static void printer(int[][] table)
    {
        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[0].length;j++)
            {
                if(table[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}
