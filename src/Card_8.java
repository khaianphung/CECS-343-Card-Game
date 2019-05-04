import java.awt.Image;

public class Card_8 extends Card
{
//enjoying the peace
	String name;
	Image img;
	public Card_8(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "Japanese Garden")
		{
			switch((String) getSkillChipReward()){
			case "Integrity":
				super.playerHolder.addIntegrity(1);
				break;
				
			case "Craft":
				super.playerHolder.addCraft(1);
				break;
				
			case "Learning":
				super.playerHolder.addLearn(1);
				break;
				
			default:
		}
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-2);
			return false;
		}
	

}
}

