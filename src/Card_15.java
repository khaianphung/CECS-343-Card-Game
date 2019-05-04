import java.awt.Image;

public class Card_15 extends Card
{
//Math 123
	String name;
	Image img;
	public Card_15(String name, Image img){
		this.name = name;
		this.img = img;
		
	}
	@Override
	public String getName(){
		return name;
	}
	public Image getImage(){
		return img;
	}
	@Override
	public boolean playCard()
	{
		if(playerHolder.getRoom().getRoomName() == "ECS 308"
				 
				&& super.playerHolder.getCraft() >= 3)
		{
			
			super.playerHolder.addQuality(5);
			
			
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-3);
			
			return false;
		}
	

}
}

