
import java.util.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyBoundsAdapter;



public class Player 
{
	int quality, learn, craft, integrity;
	String name;
	Room currRoom;
	ArrayList<Card> hand;
	Card currentCard;
	
	public Player(String n, Room r, ArrayList<Card> h){
		name = n;
		currRoom = r;
		hand = h;
		quality = 0;
		startSkill();		
	}
	
	public void startSkill(){ // randomly generate initial stats
		Random rand = new Random();
		learn = rand.nextInt(7);
		craft = rand.nextInt(7 - learn);
		integrity = 6 - (learn + craft);
		
	}
	
	
	public void addQuality(int q)
	{
		quality += q;
		
		if(quality < 0)
			quality = 0;
	}
	
	public void addLearn(int l){
		learn += l;
	}
	
	public void addCraft(int c){
		craft += c;
	}
	
	public void addIntegrity(int i){
		integrity += i;
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
	public int getQuality(){
		return quality;
	}
	
	public int getLearn(){
		return learn;
	}
	
	public int getCraft(){
		return craft;
	}
	public int getIntegrity(){
		return integrity;
	}
	
	public String getName(){
		return name;
	}
	public Room getRoom(){
		return currRoom;
	}
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	
	public void setName(String n){
		name = n;
	}
	public void setRoom(Room r){
		currRoom = r;
	}
	
	public void setHand(ArrayList<Card> h)
	{
		hand = h;
	}
	
	public Card getCurrentCard()
	{
		return currentCard;
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void discard()
	{
		Object[] skillChips  = new Object[hand.size()];	
		
		for(int i = 0; i < hand.size(); i++)
		{
			skillChips[i] = hand.get(i).cardName;
		}
		
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Choose which card you wish to discard", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		skillChips, skillChips[0]);
		
		 
		for(int i = 0; i < hand.size(); i++)
		{
			if(hand.get(i).cardName == selectedValue)
			{
				hand.get(i).discard();
				hand.remove(i);
			}
		}
	}
	
	public void print(){
		System.out.println(learn +" "+  craft +" "+ integrity);
	}
}

