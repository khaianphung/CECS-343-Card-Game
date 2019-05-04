import java.awt.Image;

public class Card_19 extends Card
{
//score a goal
	String name;
	Image img;
	public Card_19(String name, Image img){
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
				&& super.playerHolder.getCraft() >= 3)
		{
			
			super.playerHolder.addQuality(5);
			super.playerHolder.addIntegrity(1);
			
			
			return true;
		}
		
		else
		{			
			playerHolder.addQuality(-3);
			super.playerHolder.setRoom(RoomList.getRoom("Student Parking"));
			return false;
		}
	

}
}

