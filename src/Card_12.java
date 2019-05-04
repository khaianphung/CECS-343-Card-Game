import java.awt.Image;

public class Card_12 extends Card {
	// late for class
	String name;
	Image img;
	public Card_12(String name, Image img){
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

		if (playerHolder.getRoom().getRoomName() == "Forbidden Parking") {
			playerHolder.addQuality(-2);
			return false;
		} else {

			super.playerHolder.addCraft(1);
			super.playerHolder.setRoom(RoomList.getRoom("Lactation Lounge"));
			return true;
		}
	}

}
