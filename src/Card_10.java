import java.awt.Image;

public class Card_10 extends Card
{
//cecs 105
	String name;
	Image img;
	public Card_10(String name, Image img){
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
	public boolean playCard()
	{
		if(playerHolder.getRoom().getRoomName().equals("ECS 302")
	|| playerHolder.getRoom().getRoomName().equals("ECS 308"))
		{
			
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

