import java.awt.Image;

public class Card_17 extends Card
{
//learning netbeans
	String name;
	Image img;
	public Card_17(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "Lactation Lounge"
				&& super.playerHolder.getLearn() >= 3)
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

