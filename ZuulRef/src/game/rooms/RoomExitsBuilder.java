package game.rooms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hikingcarrot7
 */
public class RoomExitsBuilder {

    private final Map<RoomDirection, Room> exits;

    public RoomExitsBuilder() {
	exits = new HashMap<>();
	exits.put(RoomDirection.NORTH, NullRoom.getInstance());
	exits.put(RoomDirection.SOUTH, NullRoom.getInstance());
	exits.put(RoomDirection.EAST, NullRoom.getInstance());
	exits.put(RoomDirection.WEST, NullRoom.getInstance());
    }

    public RoomExitsBuilder setNorthRoom(Room room) {
	exits.put(RoomDirection.NORTH, room);
	return this;
    }

    public RoomExitsBuilder setSouthRoom(Room room) {
	exits.put(RoomDirection.SOUTH, room);
	return this;
    }

    public RoomExitsBuilder setEastRoom(Room room) {
	exits.put(RoomDirection.EAST, room);
	return this;
    }

    public RoomExitsBuilder setWestRoom(Room room) {
	exits.put(RoomDirection.WEST, room);
	return this;
    }

    public Map<RoomDirection, Room> build() {
	return exits;
    }

}
