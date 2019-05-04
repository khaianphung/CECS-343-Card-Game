import java.awt.Image;

public class Card_31 extends Card {

	String name;
	Image img;
	public Card_31(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals ("ECS 302") 
				|| super.playerHolder.getRoom().roomName.equals ("Cecs Conference Room")
				|| super.playerHolder.getRoom().roomName.equals ("ECS 308")
				|| super.playerHolder.getRoom().roomName.equals ("Eat Club")
				|| super.playerHolder.getRoom().roomName.equals ("Computer Lab")
				|| super.playerHolder.getRoom().roomName.equals ("Room of Retirement")
				|| super.playerHolder.getRoom().roomName.equals ("Elevators")
				|| super.playerHolder.getRoom().roomName.equals ("North Hall")
				|| super.playerHolder.getRoom().roomName.equals ("South Hall")
				
				) 
				&& super.playerHolder.getLearn() >= 3){
			
			super.playerHolder.addQuality(5);
			
			// ADD 2 GAME CARDS

			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals ("ECS 302") 
				|| super.playerHolder.getRoom().roomName.equals ("Cecs Conference Room")
				|| super.playerHolder.getRoom().roomName.equals ("ECS 308")
				|| super.playerHolder.getRoom().roomName.equals ("Eat Club")
				|| super.playerHolder.getRoom().roomName.equals ("Computer Lab")
				|| super.playerHolder.getRoom().roomName.equals ("Room of Retirement")
				|| super.playerHolder.getRoom().roomName.equals ("Elevators")
				|| super.playerHolder.getRoom().roomName.equals ("North Hall")
				|| super.playerHolder.getRoom().roomName.equals ("South Hall")
				)){
			super.playerHolder.addQuality(-2);
		}
		
		if(!( super.playerHolder.getLearn() >= 3)){
			super.playerHolder.addQuality(-2);
		}
		
		super.playerHolder.addQuality(-5);
		super.playerHolder.setRoom(RoomList.getRoom("Lactation Lounge"));
		
			return false;

	

	}
}
