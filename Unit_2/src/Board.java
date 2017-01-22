
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JFrame implements ActionListener
{
	final int SIZE  = 10;
	
	JPanel weapons	= new JPanel();
	JPanel header 	= new JPanel();
	JPanel grid		= new JPanel(new GridLayout(SIZE,SIZE));
	JLabel score  	= new JLabel("0");
    ButtonGroup weaponGroup = new ButtonGroup();
    
    Weapon[] weaponArray = new Weapon[3]; 
	Location[][] colors;
	IntMatrix matrix;
	    
    public Board() 
    {
    	setTitle("Bomber");
	    setBounds(235,160,650,450);
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    
	    getContentPane().setLayout( new BorderLayout() );
	//header    
	    score.setFont(new Font("Serif", Font.PLAIN, 18));
		header.add(new JLabel("Score:"));
		header.add(score);
		getContentPane().add( header, BorderLayout.NORTH );
	//board   
		matrix = new IntMatrix(SIZE);
		matrix.fill(255);
		
		colors = new Location[SIZE][SIZE];
		for(int i=0;i<SIZE;i++)
			for(int j=0;j<SIZE;j++)
			{
				colors[i][j] = new Location(i,j);
				colors[i][j].update(matrix.get(i,j));			
        		colors[i][j].addActionListener(this); 
				grid.add(colors[i][j]);
			}
	    getContentPane().add( grid, BorderLayout.WEST );
	//weapons
	    
	    weapons.setLayout(new BoxLayout(weapons, BoxLayout.Y_AXIS));
		//weapons.setLayout(new FlowLayout());
		for(int i=0;i<weaponArray.length;i++)
		{
			weaponArray[i]= new Weapon(i+1,weaponGroup);
			weapons.add(weaponArray[i]);
			weapons.add(Box.createRigidArea(new Dimension(0, 15)));
		}
		weapons.add(Box.createVerticalGlue());
	    //weapons.add(Box.createRigidArea(new Dimension(0, 15)));
	    
	    getContentPane().add( weapons, BorderLayout.EAST );
    }
    
    public void actionPerformed(ActionEvent a)
    {
    	int points=0;
    	String radioName = weaponGroup.getSelection().getActionCommand();
    	//score.setText("10"+((Location)a.getSource()).getRow());    	
    	//score.setText(radioName);
    	int row =((Location)a.getSource()).getRow();
    	int col = ((Location)a.getSource()).getCol();
//    	board.change(row,col);
		Weapon selected=weaponArray[0];
		for(int c=1;c<=weaponArray.length;c++)
			if (radioName.equals("Weapon "+c))
			{
				selected = weaponArray[c-1];
			}
		
		int[][] wreck = selected.spread();
		if (selected.useAmmo())
			points = matrix.applySpread(wreck,row,col);
		draw();
		points += Integer.parseInt(score.getText());
		score.setText(""+points);    
 	}
	public void draw()
	{
		for(int i=0;i<SIZE;i++)
			for(int j=0;j<SIZE;j++)
			{
				colors[i][j].update(matrix.get(i,j));			
			}
		repaint();
	}
    
    public static void main(String[] args)
  	{
    	Board demo = new Board();
    	demo.setVisible(true);
  	}
}
