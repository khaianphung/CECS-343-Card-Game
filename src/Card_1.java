import java.awt.Image;

import javax.swing.JOptionPane;

public class Card_1 extends Card 
{
	String name;
	Image img;
	public Card_1(String name, Image img){
		this.name = name;
		this.img = img;
		
	}
	public String getName(){
		return name;
	}
	public Image getImage(){
		return img;
	}
	@Override
	public boolean playCard() 
	{
		if(super.playerHolder.getRoom().getRoomName() == "Library")
		{
			Object skillChip = getSkillChipReward();
			
			if(skillChip == "Integrity")
				super.playerHolder.addIntegrity(1);
			
			else if(skillChip == "Learning")
				super.playerHolder.addLearn(1);
			
			return true;
		}
		
		else
		{
			playerHolder.addQuality(-2);
			return false;
		}


	}
	
	@Override 
	public Object getSkillChipReward()
	{
		Object[] skillChips = { "Integrity", "Learning" };
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Choose your skill chip reward", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		skillChips, skillChips[0]);
		return selectedValue;
		
	}

}
