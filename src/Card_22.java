import java.awt.Image;

public class Card_22 extends Card {
	String name;
	Image img;
	public Card_22(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals("Japanese Garden")) &&
				super.playerHolder.getLearn() >= 3){
			
			super.playerHolder.addIntegrity(1);
			super.playerHolder.addCraft(1);
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals("Japanese Garden"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!(super.playerHolder.getLearn() >= 3)){
			super.playerHolder.addQuality(-2);
		}
		
		
			super.playerHolder.setRoom(RoomList.getRoom("Lactation Lounge"));
			return false;

	

	}

}
