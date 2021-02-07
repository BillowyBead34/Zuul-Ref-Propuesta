package game.rooms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hikingcarrot7
 */
public class Room {

    public String description;
    public Map<RoomDirection, Room> exits;

    public Room(String description) {
	this(description, new HashMap<>());
    }

    public Room(String description, Map<RoomDirection, Room> exits) {
	this.description = description;
	this.exits = exits;
    }

    public void printExits() {
	System.out.println("\nYou are " + getDescription());
	System.out.print("Exits: ");
	exits.forEach((roomDirection, room) -> {
	    if (!room.isNullRoom())
		System.out.print(String.format("%s ", roomDirection));
	});
	System.out.println();
    }

    public Room determineNextRoom(RoomDirection direction) {
	return exits.get(direction);
    }

    public boolean isNullRoom() {
	return false;
    }

    public String getDescription() {
	return description;
    }

    public Map<RoomDirection, Room> getExits() {
	return exits;
    }

    public void setExits(Map<RoomDirection, Room> exits) {
	this.exits = exits;
    }

}
