import java.awt.Image;

public class Card_11 extends Card {
	// late for class
	String name;
	Image img;
	public Card_11(String name, Image img){
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
		if (playerHolder.getRoom().getRoomName() == "Eat Club"
				|| playerHolder.getRoom().getRoomName() == "George Allen Field") {

			switch ((String) getSkillChipReward()) {

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

		else {
			playerHolder.addQuality(-2);
			return false;
		}

	}
}
