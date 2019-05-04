import java.awt.Image;

public class Card_9 extends Card
{
//parking violation
	String name;
	Image img;
	public Card_9(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "Forbidden Parking")
		{
			
			super.playerHolder.addLearn(1);
			//discard 1 game card
			super.playerHolder.addLearn(1);
			
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-2);
			return false;
		}
	

}
}

