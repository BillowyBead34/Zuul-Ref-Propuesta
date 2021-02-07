package game.rooms;

import game.exceptions.InvalidDirectionException;
import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author hikingcarrot7
 */
public enum RoomDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public static RoomDirection getDirection(String aString) {
	Optional<RoomDirection> roomDirectionMaybe = Arrays
		.asList(RoomDirection.values())
		.stream()
		.filter(roomDirection -> roomDirection.toString().equals(aString))
		.findAny();

	if (!roomDirectionMaybe.isPresent())
	    throw new InvalidDirectionException(aString);

	return roomDirectionMaybe.get();
    }

    @Override public String toString() {
	return super.toString().toLowerCase();
    }

}
