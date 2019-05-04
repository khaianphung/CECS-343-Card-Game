import java.awt.Image;

public class Card_37 extends Card {
	String name;
	Image img;
	public Card_37(String name, Image img){
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
		if(!(super.playerHolder.getRoom().roomName.equals ("ECS 302") 
				|| super.playerHolder.getRoom().roomName.equals ("Cecs Conference Room")
				|| super.playerHolder.getRoom().roomName.equals ("ECS 308")
				|| super.playerHolder.getRoom().roomName.equals ("Eat Club")
				|| super.playerHolder.getRoom().roomName.equals ("Computer Lab")
				|| super.playerHolder.getRoom().roomName.equals ("Room of Retirement")
				|| super.playerHolder.getRoom().roomName.equals ("Elevators")
				|| super.playerHolder.getRoom().roomName.equals ("North Hall")
				|| super.playerHolder.getRoom().roomName.equals ("South Hall")
				|| super.playerHolder.getRoom().roomName.equals ("Lactation Lounge")
				) 
				){
			
			
			
			
			super.playerHolder.addCraft(1);
			super.playerHolder.setRoom(RoomList.getRoom("Lactation Lounge"));
			return true;
		}
		
		if((super.playerHolder.getRoom().roomName.equals ("ECS 302") 
				|| super.playerHolder.getRoom().roomName.equals ("Cecs Conference Room")
				|| super.playerHolder.getRoom().roomName.equals ("ECS 308")
				|| super.playerHolder.getRoom().roomName.equals ("Eat Club")
				|| super.playerHolder.getRoom().roomName.equals ("Computer Lab")
				|| super.playerHolder.getRoom().roomName.equals ("Room of Retirement")
				|| super.playerHolder.getRoom().roomName.equals ("Elevators")
				|| super.playerHolder.getRoom().roomName.equals ("North Hall")
				|| super.playerHolder.getRoom().roomName.equals ("South Hall")
				
				|| super.playerHolder.getRoom().roomName.equals ("Lactation Lounge")
				)){
			super.playerHolder.addQuality(-2);
		}
		
		
		
		
			
		
			return false;

	

	}

}
