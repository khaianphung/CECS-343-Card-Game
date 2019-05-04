import java.awt.Image;

public class Card_26 extends Card {

	String name;
	Image img;
	public Card_26(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals ("Elevators") ) &&
				 super.playerHolder.getLearn() >= 4){
			
			super.playerHolder.addCraft(2);
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals ("Elevators"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!( super.playerHolder.getLearn() >= 4)){
			super.playerHolder.addQuality(-2);
		}
		
			
			super.playerHolder.addQuality(-2);
			return false;
			
	

	}


}
