import java.awt.Image;

public class Card_18 extends Card
{
//choosing a major
	String name;
	Image img;
	public Card_18(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "Cecs Conference Room"
				&& super.playerHolder.getIntegrity() >= 3)
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

