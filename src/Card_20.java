import java.awt.Image;

public class Card_20 extends Card {
	String name;
	Image img;
	public Card_20(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals("North Hall") ||
				super.playerHolder.getRoom().roomName.equals("South Hall")) &&
				super.playerHolder.getLearn() >= 6){
			
			super.playerHolder.addQuality(5);
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals("North Hall") ||
				super.playerHolder.getRoom().roomName.equals("South Hall"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!(super.playerHolder.getLearn() >= 6)){
			super.playerHolder.addQuality(-2);
		}
		
			super.playerHolder.setRoom(RoomList.getRoom("Student Parking"));
			return false;

	

	}
}
