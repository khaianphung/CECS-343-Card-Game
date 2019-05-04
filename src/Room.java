


import java.util.*;


public class Room {


String roomName;



ArrayList<String> nearbyRooms = new ArrayList<String>();

ArrayList<Room> adjRooms = new ArrayList<Room>();

public  int xCoord;///////////////////////////////////sdfsdffs
public int yCoord;///////////////////////////////////sffdsf

public Room(){}
public Room(String name){
	roomName = name;
}

public void setRoomName(String name){


	this.roomName = name;
	xCoord = 0;
	yCoord = 0;
}


public String getRoomName(){


	return roomName;


}




public void setNearbyRoom(Room r){ 

	adjRooms.add(r);
	nearbyRooms.add(r.getRoomName());


}



public ArrayList<Room> getNearByRoomArray(){


	return adjRooms;


}

public ArrayList<Room> getNearByRoomArray2(){


	return adjRooms;


}




}
