import java.awt.Image;

public class Card_38 extends Card {
	String name;
	Image img;
	public Card_38(String name, Image img){
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
	public boolean playCard() {
		if((super.playerHolder.getRoom().roomName.equals ("Student Parking") ) 
				){
			
			super.playerHolder.addCraft(1);
			super.playerHolder.setRoom(RoomList.getRoom("Lactation Lounge"));
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals ("Student Parking"))){
			super.playerHolder.addQuality(-2);
		}
		
		
		
			
			
			return false;
			
	

	}
}
