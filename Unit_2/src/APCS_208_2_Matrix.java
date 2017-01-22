import java.util.Arrays;

/**
 * Created by Hank on 11/19/2016.
 */
public class APCS_208_2_Matrix
{
    public static void main(String[] Theory)
    {
        Matrix neo = new Matrix(3, 3);
        Matrix trinity = new Matrix(3, 1);

        int[][] results;
        results = neo.add(trinity.getMatty());
        System.out.println("Addition results");
        printer(results);

        results=neo.subtract(trinity.getMatty());
        System.out.println("Subtraction results");
        printer(results);

        results=neo.multiply(trinity.getMatty());
        System.out.println("Multiplication results");
        printer(results);

        int result;
        result=neo.sumColumn(2);
        System.out.println("Column Sum results\n"+result);

        result=neo.sumRow(2);
        System.out.println("Row Sum results\n"+result);

        result=neo.sumDiagonal();
        System.out.println("Diagonal Sum results\n"+result);

        results=neo.transpose();
        System.out.println("Transpose results");
        printer(results);

    }

    public static void printer(int[][] morpheus)
    {
        for(int i=0; i<morpheus.length; i++)
        {
            for(int j=0; j<morpheus[0].length; j++)
            {
                System.out.print(morpheus[i][j]);
            }
            System.out.print("\n");
        }
    }
}

class Matrix
{
    private int[][] matty;

    public Matrix(int[][] matrices)
    {
        this.matty = matrices;
    }
    public Matrix(int size, int value)
    {
        matty = new int [size][size];
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                matty[a][b] = value;
            }
        }
    }

    public int[][] getMatty() {
        return matty;
    }

    public boolean checker(int[][] patty)
    {
        return matty.length==patty.length&&matty[0].length==patty[0].length;
    }
    public int[][] add(int[][] patty)
    {
        int[][] sum = new int[matty.length][matty[0].length];
        if(checker(patty))
        {
            for(int i=0; i<matty.length;i++)
            {
                for(int j=0; j<matty[0].length; j++)
                {
                    sum[i][j] = matty[i][j]+patty[i][j];
                }
            }
            return sum;
        }
        else
        {
            return null;
        }
    }

    public int[][] subtract(int[][] patty)
    {
        int[][] difference = new int[matty.length][matty[0].length];
        if(checker(patty))
        {
            for(int i=0; i<matty.length;i++)
            {
                for(int j=0; j<matty[0].length; j++)
                {
                    difference[i][j] = matty[i][j]-patty[i][j];
                }
            }
            return difference;
        }
        else
        {
            return null;
        }
    }

    public boolean checker2(int[][] patty)
    {
        return matty.length==patty[0].length;
    }

    public int[][] multiply(int[][] patty)
    {
        if(checker2(patty))
        {
            int[][] product = new int[matty.length][patty[0].length];
            for (int i = 0; i < matty.length; i++)
            {
                for (int j = 0; j < patty[0].length; j++)
                {
                    for (int k = 0; k < matty[0].length; k++) {
                        product[i][j] += matty[i][k] * patty[k][j];
                    }
                }
            }
            return product;
        }
        else
        {
            return null;
        }
    }

    public int sumColumn(int column)
    {
        int columSum=0;
        if(column<matty[0].length)
        {

            for(int i=0;i<matty.length;i++)
            {
                columSum+=matty[i][column];
            }

        }
        return columSum;
    }

    public int sumRow(int row)
    {
        int rowSum=0;
        if(row<matty.length)
        {

            for(int i=0;i<matty[0].length;i++)
            {
                rowSum+=matty[i][row];
            }

        }
        return rowSum;
    }

    public int sumDiagonal()
    {
        int diagonalSum = 0;
        for (int r = 0; r < matty.length; r++) {
            diagonalSum += matty[r][r];
        }
        return diagonalSum;
    }

    public int[][] transpose()
    {
        int[][] transposed = new int[matty[0].length][matty.length];
        for (int r = 0; r < matty.length; r++) {
            for (int c = 0; c < matty[0].length; c++) {
                transposed[c][r] = matty[r][c];
            }
        }
        return transposed;
    }
}
