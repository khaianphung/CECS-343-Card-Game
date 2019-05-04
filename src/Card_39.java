import java.awt.Image;

public class Card_39 extends Card {
	String name;
	Image img;
	public Card_39(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals ("Room of Retirement") ) &&
				 super.playerHolder.getLearn() >= 6
				 &&
				 super.playerHolder.getIntegrity() >= 6
				 &&
				 super.playerHolder.getCraft() >= 6){
			
			super.playerHolder.addQuality(10);;
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals ("Room of Retirement"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!( super.playerHolder.getLearn() >= 6
				 &&
				 super.playerHolder.getIntegrity() >= 6
				 &&
				 super.playerHolder.getCraft() >= 6)){
			super.playerHolder.addQuality(-2);
		}
		
			
			//LOSE 1 GAME CARD
			// LEAVE THIS CARD IN ROOM OF RETIREMENT
			return false;
			
	

	}

}
