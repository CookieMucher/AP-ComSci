import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class Location extends JButton
{
	private int row;
	private int col;
	private Color color=Color.blue;
	
	Location(int r, int c)
	{
		super("("+r+", "+c+")");
		row = r;
		col = c;
		Border noBorder = new LineBorder(Color.WHITE, 0);
		setBorder(noBorder);
		setPreferredSize(new Dimension(50, 50));
        setOpaque(true);
        setBackground(color);
	}
	
	int getCol(){	return col;}
	int getRow(){	return row;}
	
	public String toString()
	{
		return "("+row+", "+col+")";
	}

	public void update(int blue)
	{
		if (blue>0)
			color = new Color(0,0,blue);
		else
			color= new Color(0,0,0);
		setBackground(color);
	}
	
	public void hit()
	{
		if (color.getBlue()>25)
			color= new Color(0,0,color.getBlue()-25);
		else
			color= new Color(0,0,0);
		setBackground(color);
	}
} 
