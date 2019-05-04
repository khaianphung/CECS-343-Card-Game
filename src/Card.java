

import java.awt.Image;

import javax.swing.JOptionPane;

public abstract class Card
{
	public String cardName;
	//requirements to play the card, will be compared with the player values
	public int integrityReq;
	public int craftReq;
	public int learningReq;
	public String roomNameReq;
	public String imageFileName;
	//qualityPoints rewarded for playing the card successfully
	public int qualityReward;
	//quality point penalty for not meeting the requirements and trying to play the card	
	public int qualityPenalty;
	//to be chosen by the player after playing the card successfully
	public String skillChipReward;
	//when this card is assigned to a player, this Player variable will be set to that player
	public Player playerHolder;

	public Card()
	{
		cardName = "";
		integrityReq = 0;
		craftReq = 0;
		learningReq = 0;
		roomNameReq = "";
		qualityReward = 0;
		qualityPenalty = 0;
		skillChipReward = "";
		playerHolder = null;
	}


	public Card(String cardName)
	{
		this.cardName = cardName;		
	}

	public abstract boolean playCard();


	public void discard()
	{
		playerHolder = null;
	}
	public String getName(){
		return "";
	}
	public Image getImage(){
		return null;
	}

	public Object getSkillChipReward()
	{
		Object[] skillChips = { "Integrity", "Craft", "Learning" };
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Choose your skill chip reward", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		skillChips, skillChips[0]);
		return selectedValue;
	}
	
}
