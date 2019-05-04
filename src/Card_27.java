import java.awt.Image;

public class Card_27 extends Card {
	String name;
	Image img;
	public Card_27(String name, Image img){
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
		if((super.playerHolder.getRoom().roomName.equals ("Eat Club") ) &&
				 super.playerHolder.getCraft() >= 3){
			
			switch((String) getSkillChipReward()){
			case "Integrity":
				super.playerHolder.addIntegrity(1);
				break;
				
			case "Craft":
				super.playerHolder.addCraft(1);
				break;
				
			case "Learning":
				super.playerHolder.addLearn(1);
				break;
				
			default:
				
		
		}
			return true;
		}
		
		if(!(super.playerHolder.getRoom().roomName.equals ("Eat Club"))){
			super.playerHolder.addQuality(-2);
		}
		
		if(!( super.playerHolder.getCraft() >= 3)){
			super.playerHolder.addQuality(-2);
		}
		
			
			super.playerHolder.addQuality(-2);
			return false;
			
	

	}

}
