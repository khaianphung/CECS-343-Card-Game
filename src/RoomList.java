

import java.util.ArrayList;

public class RoomList
{
	private static ArrayList<Room> rooms;
	private Room georgeAllenField;
	private Room japaneseGarden;
	private Room bluePyramid;
	private Room studentParking;
	private Room recCenter;
	private Room forbiddenParking;
	private Room computerLab;
	private Room ECS302;		
	private Room eatClub;
	private Room cecsConf;
	private Room northHall;
	private Room southHall;
	private Room retireRoom;
	private Room elevators;
	private Room ECS308;
	private Room lactationLounge;
	private Room eastW;
	private Room westW;
	private Room lib;
	private Room la5;
	private Room bratwurstHall;
	
	public RoomList()
	{
		
		rooms = new ArrayList<Room>();
		
		georgeAllenField = new Room("George Allen Field");
		japaneseGarden = new Room("Japanese Garden");
		bluePyramid = new Room("Blue Pyramid");
		studentParking = new Room("Student Parking");
		recCenter = new Room("Rec Center");
		forbiddenParking = new Room("Forbidden Parking");
		computerLab = new Room("Computer Lab");
		ECS302 = new Room("ECS 302");		
		eatClub = new Room("Eat Club");
		cecsConf = new Room("Cecs Conference Room");
		northHall = new Room("North Hall");
		southHall= new Room("South Hall");
		retireRoom = new Room("Room of Retirement");
		elevators = new Room("Elevators");
		ECS308 = new Room("ECS 308");
		lactationLounge= new Room("Lactation Lounge");
		eastW = new Room("East Walkway");
		westW = new Room("West Walkway");
		lib = new Room("Library");
		la5 = new Room("LA 5");
		bratwurstHall = new Room("Bratwurst Hall");
		
		setNearbyRooms();
		
		rooms.add(ECS308);
		rooms.add(ECS302);
		rooms.add(georgeAllenField);
		rooms.add(japaneseGarden);
		rooms.add(bluePyramid);
		rooms.add(studentParking);
		rooms.add(recCenter);
		rooms.add(forbiddenParking);
		rooms.add(computerLab);	
		rooms.add(eatClub);
		rooms.add(cecsConf);
		rooms.add(northHall);
		rooms.add(southHall);
		rooms.add(retireRoom);
		rooms.add(elevators);
		rooms.add(lactationLounge);
		rooms.add(eastW);
		rooms.add(westW);
		rooms.add(lib);
		rooms.add(la5);
		rooms.add(bratwurstHall);
		
	}

	
	public ArrayList<Room> getRoomList()
	{
		return rooms;
	}
	public static Room getRoom(String s){
		System.out.println("S:"+s);
		for(Room r: rooms){
			if (s.equals(r.getRoomName())){
				return r;
			}
		}
	
//		System.out.println("Room index: "+rooms.indexOf(r));
//		return rooms.get(rooms.indexOf(new Room(s)));
		return null;
	}
		
		//ADD NEARBY ROOMS
	public  void setNearbyRooms()
	{
		georgeAllenField.setNearbyRoom(japaneseGarden);
		georgeAllenField.setNearbyRoom(bluePyramid);
		georgeAllenField.setNearbyRoom(recCenter);
		georgeAllenField.setNearbyRoom(westW);
		georgeAllenField.xCoord = 32;
		georgeAllenField.yCoord = 168;
		
		japaneseGarden.setNearbyRoom(georgeAllenField);
		japaneseGarden.setNearbyRoom(bluePyramid);
		japaneseGarden.setNearbyRoom(studentParking);
		japaneseGarden.xCoord = 368;
		japaneseGarden.yCoord = 50;
				
		bluePyramid.setNearbyRoom(georgeAllenField);
		bluePyramid.setNearbyRoom(japaneseGarden);
		bluePyramid.setNearbyRoom(studentParking);
	   	bluePyramid.setNearbyRoom(recCenter);
	    bluePyramid.xCoord = 427;
	    bluePyramid.yCoord = 247;
			
		studentParking.setNearbyRoom(japaneseGarden);
		studentParking.setNearbyRoom(bluePyramid);
		studentParking.setNearbyRoom(recCenter);
		studentParking.setNearbyRoom(forbiddenParking);
		studentParking.xCoord = 892;
		studentParking.yCoord = 168;
				
		recCenter.setNearbyRoom(georgeAllenField);
		recCenter.setNearbyRoom(bluePyramid);        
		recCenter.setNearbyRoom(studentParking);		
		recCenter.setNearbyRoom(forbiddenParking);		
		recCenter.setNearbyRoom(westW);
		recCenter.xCoord = 470;
		recCenter.yCoord = 478;
				
		forbiddenParking.setNearbyRoom(studentParking);
		forbiddenParking.setNearbyRoom(recCenter);
		forbiddenParking.setNearbyRoom(eastW);
		forbiddenParking.xCoord = 930;
		forbiddenParking.yCoord = 459;
				
		computerLab.setNearbyRoom(northHall);
		computerLab.xCoord = 234;
		computerLab.yCoord = 696;
		
		ECS302.setNearbyRoom(northHall);
		ECS302.setNearbyRoom(southHall);
		ECS302.xCoord = 548;
		ECS302.yCoord = 699;
		
		eatClub.setNearbyRoom(southHall);
		eatClub.xCoord = 746;
		eatClub.yCoord = 690;
		
		cecsConf.setNearbyRoom(southHall);
		cecsConf.xCoord = 928;
		cecsConf.yCoord = 710;
		
		northHall.setNearbyRoom(computerLab);
		northHall.setNearbyRoom(retireRoom);
		northHall.setNearbyRoom(westW);
		northHall.setNearbyRoom(ECS302);
		northHall.setNearbyRoom(elevators);
		northHall.setNearbyRoom(southHall);
		northHall.xCoord = 267;
		northHall.yCoord = 865;
		
		southHall.setNearbyRoom(eatClub);
		southHall.setNearbyRoom(ECS302);
		southHall.setNearbyRoom(cecsConf);
		southHall.setNearbyRoom(ECS308);
		southHall.setNearbyRoom(lactationLounge);
		southHall.setNearbyRoom(eastW);
		southHall.setNearbyRoom(northHall);
		southHall.xCoord = 779;
		southHall.yCoord = 853;
		
		retireRoom.setNearbyRoom(northHall);
		retireRoom.xCoord = 228;
		retireRoom.yCoord = 1033;
		
		elevators.setNearbyRoom(northHall);
		elevators.setNearbyRoom(la5);
		elevators.xCoord = 461;
		elevators.yCoord = 1044;
		
		ECS308.setNearbyRoom(southHall);
		ECS308.xCoord = 686;
		ECS308.yCoord = 1067;
		
		lactationLounge.setNearbyRoom(southHall);
		lactationLounge.xCoord = 915;
		lactationLounge.yCoord = 1034;
		
		eastW.setNearbyRoom(forbiddenParking);
		eastW.setNearbyRoom(southHall);
		eastW.setNearbyRoom(bratwurstHall);
		eastW.xCoord = 1091;
		eastW.yCoord = 863;
		
		westW.setNearbyRoom(georgeAllenField);
		westW.setNearbyRoom(recCenter);
		westW.setNearbyRoom(northHall);
		westW.setNearbyRoom(lib);
		westW.xCoord = 23;
		westW.yCoord = 864;
																			
		lib.setNearbyRoom(westW);
		lib.setNearbyRoom(la5);
		lib.xCoord = 103;
		lib.yCoord = 1317;
			
		la5.setNearbyRoom(lib);
		la5.setNearbyRoom(elevators);
		la5.setNearbyRoom(bratwurstHall);
		la5.xCoord = 472;
		la5.yCoord = 1338;
		
		bratwurstHall.setNearbyRoom(eastW);
		bratwurstHall.setNearbyRoom(la5);	
		bratwurstHall.xCoord = 907;
		bratwurstHall.yCoord = 1299;


	}

}
