import java.awt.Image;

public class Card_30 extends Card {

	String name;
	Image img;
	public Card_30(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals ("Library") ) &&
				 super.playerHolder.getLearn() >= 2){
			
			super.playerHolder.addLearn(1);
			
			//GET A GAME CARD
			
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals ("Library"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!(super.playerHolder.getLearn() >= 2)){
			super.playerHolder.addQuality(-2);
		}
		
			
			super.playerHolder.addQuality(-2);
			return false;
			
	

	}

}
