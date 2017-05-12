/**
 * Created by HHUANG on 2/2/2017.
 */
public class tester
{
    public static void main(String[] args)
    {
        int[][] table = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {1,1,0,0}
        };


        int row = 2;
        int col = 2;


        //row check
        for(int c=0; c<col; c++)
            if(table[row][c]==1)
            {
                System.out.println("NO");
                System.exit(0);
            }

        int a,b;
        //diagonal check
        for(a=col,b=row; a>=0&&b>0 ;a--,b--)
            if(table [a][b]==1 )
            {
                System.out.println("NO");
                System.exit(0);
            }
        for (a=row, b=col; b>=0 && a<table.length; a++, b--)
            if(table [a][b]==1 )
            {
                System.out.println("NO");
                System.exit(0);
            }
        System.out.println("YES");




    }
}
