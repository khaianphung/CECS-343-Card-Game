
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class CardList {
	private ArrayList<Card> gameDeck;
	private ArrayList<Card> copy;
	public CardList() {

		gameDeck = new ArrayList<Card>();
		// To be initialized just like in RoomList
		// String cardName, int integReq, int craftReq, int learnReq, String
		// roomReq, int qualityReward, int qualityPen

		Card c0 = new Card_0("CECS 100", (new ImageIcon("cardm00.png")).getImage());
		Card c1 = new Card_1("MATH 122", (new ImageIcon("cardm01.png")).getImage());
		Card c2 = new Card_2("Lunch at Bratwurst Hall", (new ImageIcon("cardm02.png")).getImage());
		Card c3 = new Card_3("Research Compilers", (new ImageIcon("cardm03.png")).getImage());
		Card c4 = new Card_4("Professor Murgolo's CECS 174 Class", (new ImageIcon("cardm04.png")).getImage());
		Card c5 = new Card_5("CECS 100 (ECS 308)", (new ImageIcon("cardm05.png")).getImage());
		Card c6 = new Card_6("Exercising Mind and Body", (new ImageIcon("cardm06.png")).getImage());
		Card c7 = new Card_7("Finding the Lab", (new ImageIcon("cardm07.png")).getImage());
		Card c8 = new Card_8("Enjoying the Peace", (new ImageIcon("cardm08.png")).getImage());
		Card c9 = new Card_9("Parking Violation", (new ImageIcon("cardm09.png")).getImage());
		Card c10 = new Card_10("CECS 105", (new ImageIcon("cardm10.png")).getImage());

		Card c11 = new Card_11("Buddy Up", (new ImageIcon("cardm11.png")).getImage());
		Card c12 = new Card_12("Late For Class", (new ImageIcon("cardm12.png")).getImage());
		Card c13 = new Card_13("The Big Game", (new ImageIcon("cardm13.png")).getImage());
		Card c14 = new Card_14("MATH 123", (new ImageIcon("cardm14.png")).getImage());
		Card c15 = new Card_15("Physic 151", (new ImageIcon("cardm15.png")).getImage());
		Card c16 = new Card_16("KIN 253 Learning the Rules of Soccer", (new ImageIcon("cardm16.png")).getImage());
		Card c17 = new Card_17("Learning Netbeans", (new ImageIcon("cardm17.png")).getImage());
		Card c18 = new Card_18("Choosing the Major", (new ImageIcon("cardm18.png")).getImage());
		Card c19 = new Card_19("Score A Goal", (new ImageIcon("cardm19.png")).getImage());
		Card c20 = new Card_20("Make the Dean List", (new ImageIcon("cardm20.png")).getImage());

		Card c21 = new Card_21("Play Soccer Class", (new ImageIcon("cardm21.png")).getImage());
		Card c22 = new Card_22("Fall in The Pond", (new ImageIcon("cardm22.png")).getImage());
		Card c23 = new Card_23("A New Laptop", (new ImageIcon("cardm23.png")).getImage());
		Card c24 = new Card_24("Meet The Dean", (new ImageIcon("cardm24.png")).getImage());
		Card c25 = new Card_25("Program Crashes", (new ImageIcon("cardm25.png")).getImage());
		Card c26 = new Card_26("Press the Right Floor", (new ImageIcon("cardm26.png")).getImage());
		Card c27 = new Card_27("Loud Buzzing", (new ImageIcon("cardm27.png")).getImage());
		Card c28 = new Card_28("Professor Englert", (new ImageIcon("cardm28.png")).getImage());
		Card c29 = new Card_29("Soccer Goalie", (new ImageIcon("cardm29.png")).getImage());
		Card c30 = new Card_30("Elective Class", (new ImageIcon("cardm30.png")).getImage());

		Card c31 = new Card_31("Professor Hoffman", (new ImageIcon("cardm31.png")).getImage());
		Card c32 = new Card_32("The Outpost", (new ImageIcon("cardm32.png")).getImage());
		Card c33 = new Card_33("Oral Communication", (new ImageIcon("cardm33.png")).getImage());
		Card c34 = new Card_34("CHEM 111", (new ImageIcon("cardm34.png")).getImage());
		Card c35 = new Card_35("Learning LINUX", (new ImageIcon("cardm35.png")).getImage());
		Card c36 = new Card_36("Make a Friend", (new ImageIcon("cardm36.png")).getImage());
		Card c37 = new Card_37("Enjoying Nature", (new ImageIcon("cardm37.png")).getImage());
		Card c38 = new Card_38("Student Parking", (new ImageIcon("cardm38.png")).getImage());
		Card c39 = new Card_39("Goodbye Professor", (new ImageIcon("cardm39.png")).getImage());

		gameDeck.add(c0);
		gameDeck.add(c1);
		gameDeck.add(c2);
		gameDeck.add(c3);
		gameDeck.add(c4);
		gameDeck.add(c5);
		gameDeck.add(c6);
		gameDeck.add(c7);
		gameDeck.add(c8);
		gameDeck.add(c9);
		gameDeck.add(c10);

		gameDeck.add(c11);
		gameDeck.add(c12);
		gameDeck.add(c13);
		gameDeck.add(c14);
		gameDeck.add(c15);
		gameDeck.add(c16);
		gameDeck.add(c17);
		gameDeck.add(c18);
		gameDeck.add(c19);
		gameDeck.add(c20);

		gameDeck.add(c21);
		gameDeck.add(c22);
		gameDeck.add(c23);
		gameDeck.add(c24);
		gameDeck.add(c25);
		gameDeck.add(c26);
		gameDeck.add(c27);
		gameDeck.add(c28);
		gameDeck.add(c29);
		gameDeck.add(c30);

		gameDeck.add(c31);
		gameDeck.add(c32);
		gameDeck.add(c33);
		gameDeck.add(c34);
		gameDeck.add(c35);
		gameDeck.add(c36);
		gameDeck.add(c37);
		gameDeck.add(c38);
		gameDeck.add(c39);

		//System.out.println("Actual ArrayList:");
		//System.out.println(printArray(gameDeck));
		
		//System.out.println("Cloned ArrayList:");
		//System.out.println(printArray(copy));
		
		

		System.out.println("SHUFFLING...");

		Collections.shuffle(gameDeck);

	}

	public void copy(){
		copy = (ArrayList<Card>) gameDeck.clone();
	}
	public void repopulate(){
		gameDeck = (ArrayList<Card>) copy.clone();
		Collections.shuffle(gameDeck);

	}
	public ArrayList<Card> getGameDeck() {
		return gameDeck;
	}

	public String printArray(ArrayList<Card> deck) {
		String s = "";
		for (Card c : deck) {
			s = s + c.getName();
			s += " ";
			//System.out.println(s);
		}
		return s;
	}

}
