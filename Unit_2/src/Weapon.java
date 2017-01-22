import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Weapon extends JPanel
{
	private String name ="Weapon ";
	private int ammo = 10;
	private int[][] pattern;
	JLabel nameL;
	JLabel ammoL;
	
	JPanel data = new JPanel(new BorderLayout());
	JRadioButton choice;
	
	Weapon(int wepNum, ButtonGroup group)
	{
		name +=wepNum;
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(130,60));
	//	setMinimumSize(new Dimension(130, 60));
		setMaximumSize(new Dimension(140,80));
	data.setBackground(Color.white); 
	//radio
		choice = new JRadioButton("",true);
		choice.setActionCommand(name);
		add(choice);
		group.add(choice);
			
	//pattern
		switch(wepNum)
		{
			case 1:
				ammo = 8;
				ammoL = new JLabel(""+ammo);
				pattern=new int[5][5];
				for (int i=0;i<pattern.length;i++)
					for(int j=0;j<pattern.length;j++)
						pattern[i][j]=25;
				break;
			case 2:
				ammo = 12;
				ammoL = new JLabel(""+ammo);
				pattern=new int[7][7];
				for(int j=0;j<pattern.length;j++)
					pattern[j][j]=25;
				break;
			default:
				ammo = 3;
				ammoL = new JLabel(""+ammo);
				pattern=new int[3][3];
				for (int i=0;i<pattern.length;i++)
					for(int j=0;j<pattern.length;j++)
						pattern[i][j]=255;
				break;
		}
	//data	
		nameL = new JLabel(name);
		nameL.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		data.add(nameL,BorderLayout.CENTER);
		ammoL.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		data.add(ammoL,BorderLayout.SOUTH);
		add(data);	
	}
	
	public int[][] spread()
	{
		return pattern;
	}

	public boolean useAmmo()
	{
		boolean done = false;
		if (ammo >0)
		{	
			ammo--;
			done = true;
		}
			
		ammoL.setText(ammo+"");
		return done;
	}
}