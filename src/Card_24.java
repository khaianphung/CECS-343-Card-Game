import java.awt.Image;

public class Card_24 extends Card {
	String name;
	Image img;
	public Card_24(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals ("North Hall") ||
				super.playerHolder.getRoom().roomName.equals("South Hall")) &&
				super.playerHolder.getIntegrity() >= 3 
				&& super.playerHolder.getCraft() >= 3 && super.playerHolder.getLearn() >= 3){
			
			super.playerHolder.addQuality(5);
			
			//ADD A GAME CARD
			
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals("North Hall") ||
				super.playerHolder.getRoom().roomName.equals("South Hall"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!(super.playerHolder.getIntegrity() >= 3 
				&& super.playerHolder.getCraft() >= 3 && super.playerHolder.getLearn() >= 3)){
			super.playerHolder.addQuality(-2);
		}
		
			// Discard 1 game card
		
			return false;

	

	}
}
