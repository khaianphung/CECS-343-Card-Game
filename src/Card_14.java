import java.awt.Image;

public class Card_14 extends Card
{
//Math 123
	String name;
	Image img;
	public Card_14(String name, Image img){
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
		if((playerHolder.getRoom().getRoomName() == "ECS 302"
				||playerHolder.getRoom().getRoomName() == "ECS 308") 
				&& super.playerHolder.getLearn() >= 5)
		{
			
			super.playerHolder.addQuality(5);
			
			
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-3);
			//discard
			return false;
		}
	

}
}

