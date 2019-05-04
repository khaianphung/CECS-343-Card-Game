import java.awt.Image;

public class Card_13 extends Card
{
//The big game
	String name;
	Image img;
	public Card_13(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "Blue Pyramid")
		{
			
			super.playerHolder.addCraft(1);
			super.playerHolder.setRoom(RoomList.getRoom("Lactation Lounge"));
			
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-2);
			return false;
		}
	

}
}

