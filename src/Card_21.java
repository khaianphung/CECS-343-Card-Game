import java.awt.Image;

public class Card_21 extends Card {
	String name;
	Image img;
	public Card_21(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals("George Allen Field") ) &&
				super.playerHolder.getCraft()>=5){
			
			super.playerHolder.addQuality(5);
			return true;
		}
		
		
		if(!(super.playerHolder.getRoom().roomName.equals("George Allen Field"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!(super.playerHolder.getCraft()>=5)){
			super.playerHolder.addQuality(-2);
		}
		
		
			super.playerHolder.addQuality(-3);
			return false;

	}

}
