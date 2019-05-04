import java.awt.Image;

public class Card_0 extends Card 
{
	
	public String name;
	Image img;
	public Card_0(String name, Image img){
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
		if(super.playerHolder.getRoom().getRoomName().equals("ECS 302") 
				|| super.playerHolder.getRoom().getRoomName().equals("ECS 308"))
		{
			super.playerHolder.addLearn(1);
			return true;
		}
		
		else
			return false;
	}
}
