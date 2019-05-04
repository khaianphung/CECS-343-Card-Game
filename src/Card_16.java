import java.awt.Image;

public class Card_16 extends Card
{
//kin 253
	String name;
	Image img;
	public Card_16(String name, Image img){
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
		if(playerHolder.getRoom().getRoomName() == "George Allen Field"
				&& super.playerHolder.getIntegrity() >= 4)
		{
			
			super.playerHolder.addCraft(2);
			
			
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-2);
			super.playerHolder.setRoom(RoomList.getRoom("Room of Retirement"));
			return false;
		}
	

}
}

