import java.awt.Image;

public class Card_4 extends Card
{
	String name;
	Image img;
	public Card_4(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "ECS 302")
		{
			playerHolder.addLearn(1);
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-2);
			return false;
		}
	}

}
