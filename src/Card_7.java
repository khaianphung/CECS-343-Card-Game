import java.awt.Image;

public class Card_7 extends Card
{
//finding the lab
	String name;
	Image img;
	public Card_7(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "Elevators")
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
