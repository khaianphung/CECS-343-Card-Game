import java.awt.Image;

public class Card_6 extends Card
{
	String name;
	Image img;
	public Card_6(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "Rec Center")
		{
			playerHolder.addIntegrity(1);
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-2);
			return false;
		}
	}

}
